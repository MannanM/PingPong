package au.com.pingmate.service;

import au.com.pingmate.domain.PingPongPlayer;
import au.com.pingmate.domain.leaderboard.PlayerAndGameCount;

import java.util.List;

public interface PlayerService {
    public PingPongPlayer findPlayer(int id);
    public void addPlayer(PingPongPlayer player);
    public List<PingPongPlayer> listActivePlayers();
    public List<PlayerAndGameCount> listLeaderboard();
}
