package Game.Engine;

import Exceptions.EmptyFileException;
import Exceptions.InvalidResultException;
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

    Boolean computer;
    IPlayer player1, player2;
    Move move1,move2;
    public void initialise(String moveFileName, String ruleFilename) throws IOException, EmptyFileException, InvalidRuleFormatException, MovePairUndefinedException, InvalidResultException {
        gamestate = new GameState();
        renderer = new CLIRenderer();

        MoveFileReader = new ConfigFileReader(moveFileName);
        RulefileReader = new ConfigFileReader(ruleFilename);

        moveSource = new TextFileMoveSource(MoveFileReader);
        ruleSource = new TextFileRuleSource(RulefileReader, moveSource);

        renderer.displayWelcomeScreen();
    }

    public void play() throws MovePairUndefinedException {
        IGameResult result = ruleSource.applyRule(move1, move2);
        renderer.displayFinalResult(player1, player2, result);
    }

    public void getMoves()
    {
        move1 = renderer.requestMove(moveSource.getPossibleMovesStrings());
        player1.setMove(move1);
        if(computer)
            move2 = player2.getMove(moveSource.getPossibleMoves());
        else
            move2 = renderer.requestMove(moveSource.getPossibleMovesStrings());
        player2.setMove(move2);
    }


    public void gatherInformation() throws IOException {
        computer = renderer.confirmComputerPlayer();
        String PlayerName = renderer.requestPlayerName();
        player1 = new HumanPlayer(PlayerName);
        if(computer)
            player2 = new ComputerPlayer();
        else {
            String player2Name = renderer.requestPlayerName();
            player2 = new HumanPlayer(player2Name);
        }
    }
}
