package au.com.pingmate.domain;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "PINGPONG_GAME")
@SequenceGenerator(name="SEQ_PLAYER", sequenceName="pingpong_game_game_id_seq", initialValue = 1)
public class PingPongGame {

    @Id
    @Column(name="GAME_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PLAYER")
    private int id;
    
    @Column(name="DATE_PLAYED")
    private Date played;
    
    @Column(name="WINNING_SCORE")
    private int winningScore;
    
    @Column(name="LOSING_SCORE")
    private int losingScore;
    
    @Column(name="WINNING_RANKING")
    private double winningPlayerRanking;
    
    @Column(name="LOSING_RANKING")
    private double losingPlayerRanking;

    @ManyToOne
    @Cascade({CascadeType.SAVE_UPDATE})
    @JoinColumn(name="WINNING_PLAYER")
    private PingPongPlayer winner;

    @ManyToOne
    @Cascade({CascadeType.SAVE_UPDATE})
    @JoinColumn(name="LOSING_PLAYER")
    private PingPongPlayer loser;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getPlayed() {
        return played;
    }

    public void setPlayed(Date played) {
        this.played = played;
    }

    public int getWinningScore() {
        return winningScore;
    }

    public void setWinningScore(int winningScore) {
        this.winningScore = winningScore;
    }

    public int getLosingScore() {
        return losingScore;
    }

    public void setLosingScore(int losingScore) {
        this.losingScore = losingScore;
    }

    public double getWinningPlayerRanking() {
        return winningPlayerRanking;
    }

    public void setWinningPlayerRanking(double winningPlayerRanking) {
        this.winningPlayerRanking = winningPlayerRanking;
    }

    public double getLosingPlayerRanking() {
        return losingPlayerRanking;
    }

    public void setLosingPlayerRanking(double losingPlayerRanking) {
        this.losingPlayerRanking = losingPlayerRanking;
    }
    
    public PingPongPlayer getLoser() {
        return loser;
    }

    public PingPongPlayer getWinner() {
        return winner;
    }

    public void setWinner(PingPongPlayer winner) {
        this.winner = winner;
    }

    public void setLoser(PingPongPlayer loser) {
        this.loser = loser;
    }
}