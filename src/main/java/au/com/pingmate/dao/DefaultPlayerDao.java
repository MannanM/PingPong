package au.com.pingmate.dao;

import au.com.pingmate.domain.PingPongPlayer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("playerDao")
public class DefaultPlayerDao implements PlayerDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(PingPongPlayer player) {
        sessionFactory.getCurrentSession().save(player);
    }

    public void update(PingPongPlayer player) {
        sessionFactory.getCurrentSession().update(player);
    }

    public List<PingPongPlayer> listPlayers() {
        return sessionFactory.getCurrentSession().createQuery("from PingPongPlayer order by ranking desc").list();
    }

    public PingPongPlayer find(int playerId) {
        return (PingPongPlayer)sessionFactory.getCurrentSession().get(PingPongPlayer.class, playerId);
    }
}
