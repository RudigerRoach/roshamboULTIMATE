package Game.Engine;

import Exceptions.EmptyFileException;
import Exceptions.InvalidRuleFormatException;
import Exceptions.MovePairUndefinedException;
import Game.Moves.Move;
import Game.Player.ComputerPlayer;
import Game.Player.HumanPlayer;
import Game.Player.IPlayer;
import GameState.GameState;
import Renderer.CLIRenderer;
import Renderer.IRenderer;
import org.junit.Rule;

import java.io.IOException;

public class GameManager {
    private GameState gamestate;
    IRenderer renderer;

    IFileReader MoveFileReader;
    IMoveSource moveSource;

    IFileReader RulefileReader;
    IRuleSource ruleSource;

    public void initialise(String moveFileName, String ruleFilename) throws IOException, EmptyFileException, InvalidRuleFormatException, MovePairUndefinedException {
        gamestate = new GameState();
        renderer = new CLIRenderer();

        MoveFileReader = new ConfigFileReader(moveFileName);
        RulefileReader = new ConfigFileReader(ruleFilename);

        moveSource = new TextFileMoveSource(MoveFileReader);
        ruleSource = new TextFileRuleSource(RulefileReader, moveSource);

        renderer.displayWelcomeScreen();
        Boolean computer = renderer.confirmComputerPlayer();
        String PlayerName = renderer.requestPlayerName();
        IPlayer player1 = new HumanPlayer(PlayerName);
        IPlayer player2;
        if(computer)
            player2 = new ComputerPlayer();
        else {
            String player2Name = renderer.requestPlayerName();
            player2 = new HumanPlayer(player2Name);
        }
        Move move1 = renderer.requestMove(moveSource.getPossibleMovesStrings());
        player1.setMove(move1);
        Move move2;
        if(computer)
            move2 = player2.getMove(moveSource.getPossibleMoves());
        else
            move2 = renderer.requestMove(moveSource.getPossibleMoves());
        player2.setMove(move2);
        IGameResult result = ruleSource.applyRule(player1.getMove(), player2.getMove());
        renderer.displayFinalResult(player1, player2, result);
    }
}
