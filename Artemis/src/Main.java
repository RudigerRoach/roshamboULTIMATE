import Exceptions.EmptyFileException;
import Exceptions.InvalidResultException;
import Exceptions.InvalidRuleFormatException;
import Exceptions.MovePairUndefinedException;
import Game.Engine.GameManager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.logging.LogManager;
import java.util.logging.Handler;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

/**
 * Created by yashu.tanna on 2015-01-28.
 */
public class Main {
    public static void main(String[] args) throws MovePairUndefinedException, EmptyFileException, InvalidRuleFormatException, IOException, InvalidResultException
    {
        LogManager logManager = LogManager.getLogManager();

        FileInputStream logSettingsFile = new FileInputStream("log.properties");
        logManager.readConfiguration(logSettingsFile);

        Handler fileHandler = new FileHandler("log.txt");
        Logger logger = Logger.getLogger("Main");
        logger.addHandler(fileHandler);
        logger.info("test");
        
        GameManager gm = new GameManager();

        String rulesFilePath = "Rules.txt";
        String movesFilePath = "Moves.txt";
        if (args.length == 2)
        {
            movesFilePath = args[0];
            rulesFilePath = args[1];
        }

        try
        {
            gm.initialise(movesFilePath, rulesFilePath);
            gm.gatherInformation();
            gm.getMoves();
            gm.play();
        }
        catch (InvalidResultException e)
        {
            System.out.println("A game result is not correctly named in the rule file: " + e);
            logger.severe("A game result is not correctly named in the rule file: " + e);
        }
        catch (MovePairUndefinedException e)
        {
            System.out.println("Rule file is missinng rules: " + e);
            logger.severe("Rule file is missing rules: " + e);
        }
        catch (InvalidRuleFormatException e)
        {
            System.out.println("Invalid rule format in rule file: " + e);
            logger.severe("Invalid rule format in rule file: " + e);
        }
        catch (EmptyFileException e)
        {
            System.out.println("Empty file error: " + e);
            logger.severe("Error reading rule or move file -- empty file: " + e);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found error: " + e);
            logger.severe("Error reading rule or move file -- file not found: " + e);
        }
        catch (IOException e)
        {
            System.out.println("IO error: " + e);
            logger.severe("Error reading rule or move file: " + e);
        }
    }
}
