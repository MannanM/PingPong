package au.com.pingmate.service;

import au.com.pingmate.dao.PlayerDao;
import au.com.pingmate.domain.PingPongPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DefaultPlayerService implements PlayerService {

    @Autowired
    private PlayerDao playerDao;

    @Transactional
    public PingPongPlayer findPlayer(int id) {
        return playerDao.find(id);
    }

    @Transactional
    public void addPlayer(PingPongPlayer player) {
        player.setRanking(1000);
        player.setResigned(false);
        playerDao.save(player);
    }

    @Transactional
    public List<PingPongPlayer> listActivePlayers() {
        //todo: filter active only players here
        return playerDao.listPlayers();
    }
}
