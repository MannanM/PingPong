package au.com.pingmate.domain.leaderboard;

import au.com.pingmate.domain.PingPongPlayer;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Leaderboard {
    private List<PlayerAndGameCount> result = new LinkedList<PlayerAndGameCount>();

    public Leaderboard(List<Object[]> wins, List<Object[]> losses, int minimum) {
        addWins(wins);
        addLosses(losses);
        filterGamesBelowThreshold(minimum);
        descSortOnRanking();
    }

    private void addWins(List<Object[]> wins) {
        for(Object[] record : wins) {
            PlayerAndGameCount player = new PlayerAndGameCount((PingPongPlayer) record[0]);
            player.setWins((Integer) record[1]);
            result.add(player);
        }
    }

    private void addLosses(List<Object[]> losses) {
        for (Object[] record : losses) {
            PlayerAndGameCount player = new PlayerAndGameCount((PingPongPlayer) record[0]);
            PlayerAndGameCount output = findPlayer(player);
            if (output == null) { //the player has no wins
                result.add(player);
                output = player;
            }
            output.setLosses((Integer) record[1]);
        }
    }

    private PlayerAndGameCount findPlayer(PlayerAndGameCount player) {
        PlayerAndGameCount output = null;
        for (PlayerAndGameCount existing : result) {
            if (existing.getPlayer().getIdentifier().equals(player.getPlayer().getIdentifier())) {
                output = existing;
            }
        }
        return output;
    }

    private void filterGamesBelowThreshold(int minimum) {
        for (int i = result.size() - 1; i >= 0; i--) {
            int gamesPlayed = result.get(i).getWins() + result.get(i).getLosses();
            if (gamesPlayed < minimum) {
                result.remove(i);
            }
        }
    }

    private void descSortOnRanking() {
        Collections.sort(result, new Comparator<PlayerAndGameCount>() {
            @Override
            public int compare(PlayerAndGameCount o1, PlayerAndGameCount o2) {
                return o2.getPlayer().getRanking().compareTo(o1.getPlayer().getRanking());
            }
        });
    }

    public List<PlayerAndGameCount> getResult() {
        return result;
    }


}
