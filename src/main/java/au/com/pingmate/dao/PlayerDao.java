package au.com.pingmate.dao;

import au.com.pingmate.domain.PingPongPlayer;

import java.util.List;

public interface PlayerDao {
    void save(PingPongPlayer player);
    void update(PingPongPlayer player);
    PingPongPlayer find(int playerId);
    List<PingPongPlayer> listPlayers();
    List<Object[]> listPlayersAndGameCounts(boolean wins);
}
