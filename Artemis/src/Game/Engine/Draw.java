package Game.Engine;

public class Draw implements IGameResult
{
    private String resultMessage;
    
    public Draw(String message)
    {
        this.resultMessage = "Draw, " + message;
    }
    
    public String getResult()
    {
        return resultMessage;
    }
}
