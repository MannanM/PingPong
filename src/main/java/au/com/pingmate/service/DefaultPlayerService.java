package au.com.pingmate.service;

import au.com.pingmate.dao.PlayerDao;
import au.com.pingmate.domain.PingPongPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DefaultPlayerService implements PlayerService {

    @Autowired
    private PlayerDao playerDao;

    @Transactional
    public void addPlayer(PingPongPlayer player) {
        playerDao.save(player);
    }
}
