package Tests.EngineTests;

import Exceptions.EmptyFileException;
import Game.Engine.TextFileMoveSource;
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
        assertSame(textFileMoveSource.getFileName(),filename);
    }

    @Test
    public void givenAMoveName_whenIGetMoveFromName_IShouldGetMoveWithThatName() throws Exception, EmptyFileException {
        String filename = "testMoveFile.txt";
        textFileMoveSource = new TextFileMoveSource(filename);
        Move move = textFileMoveSource.getMoveFromName("Rock");
        Move expected = new Move("Rock");
        assertEquals(move, expected);
    }

    @Test
    public void givenAnEmptyFile__whenIInitialiseMoves_IShouldGetAnEmptyFileException() throws Exception, EmptyFileException {
        String filename = "testMoveEmptyFile.txt";
        try {
            TextFileMoveSource t = new TextFileMoveSource(filename);
        } catch (EmptyFileException e) {
            assertEquals(e.getClass(), EmptyFileException.class);
        }
    }

    @Test
    public void givenAMoveFileWithDuplicates_WhenIInitialiseMoves_IShouldNotGetAnyDuplicateMoves()
    {

    }

}