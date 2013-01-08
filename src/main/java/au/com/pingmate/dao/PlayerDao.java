package au.com.pingmate.dao;

import au.com.pingmate.domain.PingPongPlayer;

public interface PlayerDao {
    void save(PingPongPlayer player);
    void update(PingPongPlayer player);
    PingPongPlayer find(int playerId);
}
