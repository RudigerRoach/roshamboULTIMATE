package Tests.EngineTests;

import Exceptions.EmptyFileException;
import Game.Engine.FileReader;
import Game.Engine.TextFileMoveSource;
import Game.Moves.Move;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TextFileMoveSourceTest {

    TextFileMoveSource textFileMoveSource;
    @Before
    public void setUp() throws Exception, EmptyFileException {
        ArrayList<String> testLines = new ArrayList<String>();
        testLines.add("Rock");
        FileReader reader = new DummyFile(testLines, "dummy.txt");
        textFileMoveSource = new TextFileMoveSource(reader);
        assertSame(textFileMoveSource.getFileName(), reader.getFileName());
    }

    @Test
    public void givenAMoveName_whenIGetMoveFromName_IShouldGetMoveWithThatName() throws Exception, EmptyFileException {
        ArrayList<String> testLines = new ArrayList<String>();
        testLines.add("Rock");
        FileReader reader = new DummyFile(testLines, "dummy.txt");
        textFileMoveSource = new TextFileMoveSource(reader);
        Move move = textFileMoveSource.getMoveFromName("Rock");
        Move expected = new Move("Rock");
        assertEquals(move, expected);
    }

    @Test
    public void givenAnEmptyFile__whenIInitialiseMoves_IShouldGetAnEmptyFileException() throws Exception, EmptyFileException {
        String filename = "testMoveEmptyFile.txt";
        try {

            ArrayList<String> testLines = new ArrayList<String>();
            FileReader reader = new DummyFile(testLines, "dummy.txt");
            textFileMoveSource = new TextFileMoveSource(reader);
        } catch (EmptyFileException e) {
            assertEquals(e.getClass(), EmptyFileException.class);
        }
    }

}