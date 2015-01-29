package Renderer;

import Game.Engine.GameResult;
import Game.Moves.Move;
import Game.Player.Player;

import java.io.IOException;
import java.util.Set;

/**
 * Created by rudiger.roach on 2015-01-28.
 */
public interface Renderer {
    void displayWelcomeScreen();

    Boolean confirmComputerPlayer() throws IOException;

    String requestPlayerName() throws IOException;

    Move requestMove(Set<String> possibleMovesStrings);

    void displayFinalResult(Player player1, Player player2, GameResult result);
}
