package Game.Engine;

import java.io.*;

public class ConfigFileReaderimpl implements FileReader
{
    BufferedReader concreteConfigReader;
    String         fileName;

    ConfigFileReaderimpl(String fileName) throws FileNotFoundException
    {
        this.fileName = fileName;
        File           configFile           = new File(fileName);
        java.io.FileReader configFileReader     = new java.io.FileReader(configFile);
        concreteConfigReader = new BufferedReader(configFileReader);
    }

    public String readLine() throws IOException
    {
        return concreteConfigReader.readLine();
    }

    public String getFileName()
    {
        return this.fileName;
    }
}
 
