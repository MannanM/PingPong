package au.com.pingmate.dao;

import au.com.pingmate.domain.PingPongGame;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("gameDao")
public class DefaultGameDao implements GameDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(PingPongGame game) {
        sessionFactory.getCurrentSession().save(game);
    }

    public List<PingPongGame> findGamesPlayedBy(int id) {
        return sessionFactory.getCurrentSession().createQuery(
                String.format("from PingPongGame g " +
                              "where g.winner = %d or g.loser = %d " +
                              "order by played desc, id desc", id, id)).list();
    }
}
