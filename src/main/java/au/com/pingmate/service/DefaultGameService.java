package au.com.pingmate.service;

import au.com.pingmate.dao.GameDao;
import au.com.pingmate.domain.PingPongGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DefaultGameService implements GameService {

    @Autowired
    private GameDao gameDao;

    @Transactional
    public void addGame(PingPongGame game) {
        gameDao.save(game);
    }

    @Transactional
    public List<PingPongGame> findGamesPlayedBy(int id) {
        return gameDao.findGamesPlayedBy(id);
    }
}
