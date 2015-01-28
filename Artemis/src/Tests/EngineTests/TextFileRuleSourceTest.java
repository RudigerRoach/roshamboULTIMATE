package Tests.EngineTests;

import Game.Engine.*;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class TextFileRuleSourceTest
{
    @Test(expected = InvalidRuleFormatException.class)
    public void GivenAFileReaderWithInvalidRules_WhenATextFileRuleSourceIsConstructedWithTheEmptyDummyFile_ThenAnExceptionShouldBeThrown() throws IOException, InvalidRuleFormatException
    {
        List<String> fileLines = new ArrayList<String>();
        fileLines.add("notehutn");
        IFileReader fileReader = new DummyFile(fileLines);
        IMoveSource moveSource = null;

        IRuleSource ruleSource = new TextFileRuleSource(fileReader, moveSource);
    }
}
