package au.com.pingmate.domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PlayerStats {
    private int id;
    private int wins;
    private int losses;
    private int tieBreakWins;
    private int tieBreakLosses;
    private int winMaxScore;
    private int lossMaxScore;
    private int winMinScore = 100;
    private int lossMinScore = 100;
    private int winTotalScore;
    private int lossTotalScore;
    private Set<PingPongPlayer> players = new HashSet<PingPongPlayer>();
    private Map<PingPongPlayer, Integer> victims = new HashMap<PingPongPlayer, Integer>();
    private Map<PingPongPlayer, Integer> bullies = new HashMap<PingPongPlayer, Integer>();
    private PingPongPlayer victim;
    private PingPongPlayer bully;
    private PingPongPlayer nemesis;
    private String victimScore;
    private String bullyScore;
    private String nemesisScore;

    public PlayerStats(List<PingPongGame> games, int playerId) {
        id = playerId;
        for (PingPongGame game : games) {
            addGame(game);
        }
        calculatePlayers();
    }

    private void addGame(PingPongGame game) {
        if (game.getWinner().getIdentifier() == id) {
            wins++;
            tieBreakWins += isTieBreak(game) ? 1 : 0;
            winTotalScore += game.getWinningScore();
            winMaxScore = game.getWinningScore() > winMaxScore ? game.getWinningScore() : winMaxScore;
            winMinScore = game.getWinningScore() < winMinScore ? game.getWinningScore() : winMinScore;
            addPlayerToList(game.getLoser(), victims);
        } else {
            losses++;
            tieBreakLosses += isTieBreak(game) ? 1 : 0;
            lossTotalScore += game.getLosingScore();
            lossMaxScore = game.getLosingScore() > lossMaxScore ? game.getLosingScore() : lossMaxScore;
            lossMinScore = game.getLosingScore() < lossMinScore ? game.getLosingScore() : lossMinScore;
            addPlayerToList(game.getWinner(), bullies);
        }
    }

    private void calculatePlayers() {
        int dWins = -100;
        int dLosses = 100;
        int closestToZero = 100;
        int closestToZeroMatches = 0;
        for (PingPongPlayer player : players) {
            int wins = safeGet(player, victims);
            int losses = safeGet(player, bullies);
            int difference = wins - losses;
            String score = String.format("%d v %d", wins, losses);
            if (difference > dWins) {
                dWins = difference;
                victim = player;
                victimScore = score;
            }

            if (difference < dLosses) {
                dLosses = difference;
                bully = player;
                bullyScore = score;
            }

            int abs = Math.abs(difference);
            if (abs < closestToZero || (abs == closestToZero && wins + losses > closestToZeroMatches)) {
                closestToZero = abs;
                nemesis = player;
                nemesisScore = score;
                closestToZeroMatches = wins + losses;
            }
        }
    }

    private int safeGet(PingPongPlayer player, Map<PingPongPlayer, Integer> map) {
        if (map.containsKey(player)) {
            return map.get(player);
        }
        return 0;
    }

    private void addPlayerToList(PingPongPlayer player, Map<PingPongPlayer, Integer> list) {
        players.add(player);
        if (list.containsKey(player)) {
            list.put(player, list.get(player) + 1);
        } else {
            list.put(player, 1);
        }
    }

    private boolean isTieBreak(PingPongGame game) {
        return game.getWinningScore() >= 10 & game.getLosingScore() >= 10;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getTieBreakWins() {
        return tieBreakWins;
    }

    public int getTieBreakLosses() {
        return tieBreakLosses;
    }

    public int getWinMaxScore() {
        return winMaxScore;
    }

    public int getLossMaxScore() {
        return lossMaxScore;
    }

    public int getWinMinScore() {
        return winMinScore;
    }

    public int getLossMinScore() {
        return lossMinScore;
    }

    public int getWinTotalScore() {
        return winTotalScore;
    }

    public int getLossTotalScore() {
        return lossTotalScore;
    }

    public PingPongPlayer getVictim() {
        return victim;
    }

    public PingPongPlayer getBully() {
        return bully;
    }

    public PingPongPlayer getNemesis() {
        return nemesis;
    }

    public String getVictimScore() {
        return victimScore;
    }

    public String getBullyScore() {
        return bullyScore;
    }

    public String getNemesisScore() {
        return nemesisScore;
    }
}
