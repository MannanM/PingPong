package au.com.pingmate.service;

import au.com.pingmate.dao.PlayerDao;
import au.com.pingmate.domain.PingPongPlayer;
import au.com.pingmate.domain.leaderboard.Leaderboard;
import au.com.pingmate.domain.leaderboard.PlayerAndGameCount;
import org.joda.time.DateTime;
import org.joda.time.Weeks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DefaultPlayerService implements PlayerService {
    public static final int INITIAL_RANKING = 1200;

    //todo: think of a better way to get the start, probably minimum game played
    public static final DateTime START = new DateTime(2013, 2, 11, 0, 0);
    public static final int INITIAL_REQUIRED_GAMES = 4;
    public static final int GAMES_PER_WEEK = 2;

    @Autowired
    private PlayerDao playerDao;

    @Transactional
    public PingPongPlayer findPlayer(int id) {
        return playerDao.find(id);
    }

    @Transactional
    public void addPlayer(PingPongPlayer player) {
        player.setRanking(INITIAL_RANKING);
        player.setResigned(false);
        playerDao.save(player);
    }

    @Transactional
    public List<PingPongPlayer> listActivePlayers() {
        //todo: filter active only players here
        return playerDao.listPlayers();
    }

    @Transactional
    public List<PlayerAndGameCount> listLeaderboard() {
        return new Leaderboard(
                playerDao.listPlayersAndGameCounts(true),
                playerDao.listPlayersAndGameCounts(false), minimumGamesRequired()).getResult();
    }

    public static int minimumGamesRequired() {
        return INITIAL_REQUIRED_GAMES + (GAMES_PER_WEEK * Weeks.weeksBetween(START, new DateTime()).getWeeks());
    }
}