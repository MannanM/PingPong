package au.com.pingmate.dao;

import au.com.pingmate.domain.PingPongGame;

import java.util.List;

public interface GameDao {
    void save(PingPongGame game);
    public List<PingPongGame> findGamesPlayedBy(int id);
}
