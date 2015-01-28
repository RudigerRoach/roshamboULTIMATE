package Tests.EngineTests;

import Game.Engine.IFileReader;

import java.util.List;

public class DummyFile implements IFileReader
{
    private List<String> fileLines;
    private int          filePosition;
    
    public DummyFile(List<String> fileLines)
    {
        this.fileLines = fileLines;
        filePosition = 0;
    }

    public String readLine()
    {
        if (filePosition >= fileLines.size())
        {
            return null;
        }

        return fileLines.get(filePosition++);
    }
}
