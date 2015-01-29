package Tests.EngineTests;

import Game.Engine.FileReader;

import java.util.List;

public class DummyFile implements FileReader
{
    private List<String> fileLines;
    private int          filePosition;
    private String       fileName;
    
    public DummyFile(List<String> fileLines, String fileName)
    {
        this.fileLines = fileLines;
        this.fileName  = fileName;
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

    public String getFileName()
    {
        return fileName;
    }
}
