package Tests.EngineTests;

import java.util.List;
import Game.Engine.IFile;
import Game.Logging.Log;
import org.junit.Test;

public class DummyFile implements IFile
{
    private List<String> fileLines;
    private int          filePosition;
    
    public DummyFile(List<String> fileLines)
    {
        this.fileLines = fileLines;
        filePosition = 0;
    }

    public String getLine()
    {
        if (filePosition >= fileLines.size())
        {
            return null;
        }

        return fileLines.get(filePosition++);
    }
}
