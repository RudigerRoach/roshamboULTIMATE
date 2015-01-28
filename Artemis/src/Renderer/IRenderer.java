package Renderer;

import Game.Engine.IGameResult;
import Game.Moves.Move;
import Game.Player.IPlayer;

import java.util.Set;

/**
 * Created by rudiger.roach on 2015-01-28.
 */
public interface IRenderer {
    void displayWelcomeScreen();

    Boolean confirmComputerPlayer();

    String requestPlayerName();

    Move requestMove(Set<String> possibleMovesStrings);

    void displayFinalResult(IPlayer player1, IPlayer player2, IGameResult result);
}
