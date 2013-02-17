package au.com.pingmate.domain.leaderboard;

import au.com.pingmate.domain.PingPongPlayer;

public class PlayerAndGameCount {
    private PingPongPlayer player;
    private int wins;
    private int losses;

    public PlayerAndGameCount(PingPongPlayer player) {
        this.player = player;
    }

    public int getTotal() {
        return wins + losses;
    }

    public double getWinPercent() {
        return Math.round((((double)wins) / ((double)getTotal()))*1000)/10.0;
    }

    public double getLossPercent() {
        return Math.round((((double)losses) / ((double)getTotal()))*1000)/10.0;
    }

    public PingPongPlayer getPlayer() {
        return player;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }
}
