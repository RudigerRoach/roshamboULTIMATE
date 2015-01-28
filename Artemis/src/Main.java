import Exceptions.EmptyFileException;
import Exceptions.InvalidRuleFormatException;
import Exceptions.MovePairUndefinedException;
import Game.Engine.GameManager;

import java.io.IOException;

/**
 * Created by yashu.tanna on 2015-01-28.
 */
public class Main {
    public static void main(String[] args) throws MovePairUndefinedException, EmptyFileException, InvalidRuleFormatException, IOException {
        GameManager gm = new GameManager();
        gm.initialise("Moves.txt", "Rules.txt");
        gm.gatherInformation();
        gm.getMoves();
        gm.play();
    }
}
