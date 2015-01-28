package Game.Engine;

import java.io.*;

public class ConfigFileReader implements IFileReader
{
    BufferedReader concreteConfigReader;

    ConfigFileReader(String fileName) throws FileNotFoundException
    {
        File           configFile           = new File(fileName);
        FileReader     configFileReader     = new FileReader(configFile);
        concreteConfigReader = new BufferedReader(configFileReader);
    }

    public String readLine() throws IOException
    {
        return concreteConfigReader.readLine();
    }
}
 
