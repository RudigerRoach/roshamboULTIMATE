package Game.Engine;

import Exceptions.EmptyFileException;
import Game.Moves.Move;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sun.invoke.empty.Empty;

import static org.junit.Assert.*;

public class TextFileMoveSourceTest {

    TextFileMoveSource textFileMoveSource;
    @Before
    public void setUp() throws Exception, EmptyFileException {
        String filename = "testMoveFile.txt";
        textFileMoveSource = new TextFileMoveSource(filename);
        assertSame(textFileMoveSource.MoveFile.getName(),filename);
    }

    @Test
    public void givenAMoveName_whenIGetMoveFromName_IShouldGetMoveWithThatName() throws Exception {
        Move move = textFileMoveSource.getMoveFromName("Rock");
        Move expected = new Move("Rock");
        assertSame(move, expected);
    }

    @Test
    public void givenAnEmptyFile__whenIInitialiseMoves_IShouldGetAnEmptyFileException() throws Exception, EmptyFileException {
        String filename = "testMoveEmptyFile.txt";
        textFileMoveSource = new TextFileMoveSource(filename);
        try {
            TextFileMoveSource t = new TextFileMoveSource(filename);
        }
        catch(EmptyFileException e)
        {
            assertSame(e.getClass(), EmptyFileException.class);
        }
    }

}