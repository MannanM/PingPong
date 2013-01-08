////////////////////////////////////////////////////////////////////////////////
//
// Copyright (c) 2011, Suncorp Metway Limited. All rights reserved.
//
// This is unpublished proprietary source code of Suncorp Metway Limited.
// The copyright notice above does not evidence any actual or intended
// publication of such source code.
//
////////////////////////////////////////////////////////////////////////////////
package au.com.pingmate.service;

import java.util.Date;

import org.apache.openelo.Game;
import org.apache.openelo.GameResult;
import org.apache.openelo.Player;
import org.apache.openelo.RankingCalculator;

public class MatchService {
    
    private static final RankingCalculator rankingCalculator = new RankingCalculator();
    
    public PingPongGame createGame(PingPongPlayer player1, PingPongPlayer player2, int score1, int score2) {
        PingPongGame result = new PingPongGame();
        boolean player1IsWinner = score1 > score2;
        result.setWinner(player1IsWinner ? player1 : player2);
        result.setLoser(player1IsWinner ? player2 : player1);
        result.setWinningScore(player1IsWinner ? score1 : score2);
        result.setLosingScore(player1IsWinner ? score2 : score1);

        Game<Integer> game = new Game<Integer>(result.getWinner(), result.getLoser(), GameResult.WIN);
        rankingCalculator.updateRating(game);
        
        result.populateRankings();
        result.setPlayed(new Date());

        return result;
    }
}
