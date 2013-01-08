package au.com.pingmate.domain;

import java.util.Date;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.Table;

//@Entity
//@Table(name = "PINGPONG_GAME")
public class PingPongGame {

//    @Id
//    @Column(name="GAME_ID")
//    @GeneratedValue
    private int id;
    
//    @Column(name="DATE_PLAYED")
    private Date played;
    
//    @Column(name="WINNING_SCORE")
    private int winningScore;
    
//    @Column(name="LOSING_SCORE")
    private int losingScore;
    
//    @Column(name="WINNING_PLAYER")
    private int winnerId;
    
//    @Column(name="LOSING_PLAYER")
    private int loserId;
    
//    @Column(name="WINNING_RANKING")
    private double winningPlayerRanking;
    
//    @Column(name="LOSING_RANKING")
    private double losingPlayerRanking;

    private PingPongPlayer winner;
    private PingPongPlayer loser;

    public void populateRankings() {
        winningPlayerRanking = winner.getRanking();
        losingPlayerRanking = loser.getRanking();
    }

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

    public int getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(int winnerId) {
        this.winnerId = winnerId;
    }

    public int getLoserId() {
        return loserId;
    }

    public void setLoserId(int loserId) {
        this.loserId = loserId;
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
        this.winnerId = winner.getIdentifier();
    }

    public void setLoser(PingPongPlayer loser) {
        this.loser = loser;
        this.loserId = loser.getIdentifier();
    }
}