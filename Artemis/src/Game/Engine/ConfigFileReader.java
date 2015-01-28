package Game.Engine;

import java.io.*;

public class ConfigFileReader implements IFileReader
{
    BufferedRedeader concreteReader;

    FileReader(String fileName)
    {
        File           ruleFile       = new File(fileName);
        FileReader     fileReader     = new FileReader(ruleFile);
        BufferedReader concreteReader = new BufferedReader(ruleFileReader);
    }

    String readLine()
    {
        return concreteReader.readLine();
    }
}
 
