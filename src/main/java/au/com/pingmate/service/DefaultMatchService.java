package au.com.pingmate.service;

import au.com.pingmate.domain.PingPongGame;
import au.com.pingmate.domain.PingPongPlayer;
import org.apache.openelo.Game;
import org.apache.openelo.GameResult;
import org.apache.openelo.RankingCalculator;

import java.util.Date;

public class DefaultMatchService {
    
    private static final RankingCalculator rankingCalculator = new RankingCalculator();
    
    public PingPongGame createGame(PingPongPlayer player1, PingPongPlayer player2, int score1, int score2, Date played) {
        PingPongGame result = new PingPongGame();
        boolean player1IsWinner = score1 > score2;
        result.setWinner(player1IsWinner ? player1 : player2);
        result.setLoser(player1IsWinner ? player2 : player1);
        result.setWinningScore(player1IsWinner ? score1 : score2);
        result.setLosingScore(player1IsWinner ? score2 : score1);

        Game<Integer> game = new Game<Integer>(result.getWinner(), result.getLoser(), GameResult.WIN);
        rankingCalculator.updateRating(game);
        result.setWinningPlayerRanking(result.getWinner().getRanking());
        result.setLosingPlayerRanking(result.getLoser().getRanking());

        result.setPlayed(played);
        return result;
    }
}
