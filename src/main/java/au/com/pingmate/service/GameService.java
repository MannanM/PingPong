package au.com.pingmate.service;

import au.com.pingmate.domain.PingPongGame;

import java.util.List;

public interface GameService {
    public void addGame(PingPongGame game);
    List<PingPongGame> findGamesPlayedBy(int id);
}
