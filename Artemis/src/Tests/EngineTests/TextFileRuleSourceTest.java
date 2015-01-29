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
        FileReader fileReader = new DummyFile(fileLines, "test.txt");
        MoveSource moveSource = null;

        RuleSource ruleSource = new TextFileRuleSource(fileReader, moveSource);
    }
}
