package Game.Engine;

import Exceptions.EmptyFileException;
import Exceptions.InvalidResultException;
import Exceptions.InvalidRuleFormatException;
import Exceptions.MovePairUndefinedException;
import Game.Moves.Move;
import Game.Player.ComputerPlayerimpl;
import Game.Player.HumanPlayerimpl;
import Game.Player.Player;
import Renderer.CLIRendererimpl;
import Renderer.Renderer;

import java.io.IOException;

public class GameManager {
    Renderer.Renderer renderer;

    FileReader MoveFileReader;
    MoveSource moveSource;

    FileReader RulefileReader;
    RuleSource ruleSource;

    Boolean computer;
    Player player1, player2;
    Move move1,move2;
    public void initialise(String moveFileName, String ruleFilename) throws IOException, EmptyFileException, InvalidRuleFormatException, MovePairUndefinedException, InvalidResultException {
        renderer = new CLIRendererimpl();

        MoveFileReader = new ConfigFileReaderimpl(moveFileName);
        RulefileReader = new ConfigFileReaderimpl(ruleFilename);

        moveSource = new TextFileMoveSource(MoveFileReader);
        ruleSource = new TextFileRuleSource(RulefileReader, moveSource);

        renderer.displayWelcomeScreen();
    }

    public void play() throws MovePairUndefinedException {
        GameResult result = ruleSource.applyRule(move1, move2);
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
        player1 = new HumanPlayerimpl(PlayerName);
        if(computer)
            player2 = new ComputerPlayerimpl();
        else {
            String player2Name = renderer.requestPlayerName();
            player2 = new HumanPlayerimpl(player2Name);
        }
    }
}
