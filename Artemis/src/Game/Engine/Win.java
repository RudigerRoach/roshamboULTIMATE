package Game.Engine;

public class Win implements IGameResult
{
    String resultMessage;
    
    public Win(String message)
    {
        this.resultMessage = "Win, " + message;
    }
    
    public String getResult()
    {
        return resultMessage;
    }
}
