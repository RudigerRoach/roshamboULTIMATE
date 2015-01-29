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
import java.util.logging.Logger;

public class GameManager
{
    Renderer renderer;
    Logger logger;

    FileReader MoveFileReader;
    MoveSource moveSource;

    FileReader RulefileReader;
    RuleSource ruleSource;

    Boolean computer;
    Player player1, player2;
    Move move1,move2;
    
    public void initialise(String moveFileName, String ruleFilename) throws IOException, EmptyFileException, InvalidRuleFormatException, MovePairUndefinedException, InvalidResultException
    {
        logger = Logger.getLogger("GameManager");
        renderer = new CLIRendererimpl();

        MoveFileReader = new ConfigFileReaderimpl(moveFileName);
        RulefileReader = new ConfigFileReaderimpl(ruleFilename);

        logger.info("Reading move file");        
        moveSource = new TextFileMoveSource(MoveFileReader);
        logger.info("Reading rule file");
        ruleSource = new TextFileRuleSource(RulefileReader, moveSource);

        logger.info("Rules and moves read successfully");

        renderer.displayWelcomeScreen();
    }

    public void play() throws MovePairUndefinedException
    {
        logger.info(player1.getName() + " playing " + move1.getMoveName() + " against " + player2.getName() + " playing " + move2.getMoveName());
        GameResult result = ruleSource.applyRule(move1, move2);
        renderer.displayFinalResult(player1, player2, result);
    }

    public void getMoves()
    {
        logger.info("Retrieving player 1 move");
        move1 = renderer.requestMove(moveSource.getPossibleMovesStrings());
        player1.setMove(move1);
        logger.info("Retrieving player 2 move");
        if(computer)
            move2 = player2.getMove(moveSource.getPossibleMoves());
        else
            move2 = renderer.requestMove(moveSource.getPossibleMovesStrings());
        player2.setMove(move2);
    }


    public void gatherInformation() throws IOException
    {
        logger.info("Retrieving game information");
        computer = renderer.confirmComputerPlayer();
        String PlayerName = renderer.requestPlayerName();
        player1 = new HumanPlayerimpl(PlayerName);
        if(computer)
            player2 = new ComputerPlayerimpl();
        else
        {
            String player2Name = renderer.requestPlayerName();
            player2 = new HumanPlayerimpl(player2Name);
        }
    }
}
