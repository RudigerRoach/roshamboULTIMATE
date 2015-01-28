package Game.Engine;

import java.io.IOException;

public interface IFileReader
{
    String readLine() throws IOException;

    String getFileName();
}
