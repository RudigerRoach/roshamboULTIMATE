package Tests.EngineTests;

import Exceptions.InvalidResultException;
import Exceptions.InvalidRuleFormatException;
import Game.Engine.*;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class TextFileRuleSourceTest
{
    @Test(expected = InvalidRuleFormatException.class)
    public void GivenAFileReaderWithInvalidRules_WhenATextFileRuleSourceIsConstructedWithTheEmptyDummyFile_ThenAnExceptionShouldBeThrown() throws IOException, InvalidRuleFormatException, InvalidResultException {
        List<String> fileLines = new ArrayList<String>();
        fileLines.add("notehutn");
        IFileReader fileReader = new DummyFile(fileLines, "test.txt");
        IMoveSource moveSource = null;

        IRuleSource ruleSource = new TextFileRuleSource(fileReader, moveSource);
    }
}
