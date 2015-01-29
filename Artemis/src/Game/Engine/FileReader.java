package Game.Engine;

import java.io.IOException;

public interface FileReader
{
    String readLine() throws IOException;

    String getFileName();
}
