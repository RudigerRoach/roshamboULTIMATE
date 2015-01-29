package Game.Engine;

public class Drawimpl implements GameResult
{
    private String resultMessage;
    
    public Drawimpl(String message)
    {
        this.resultMessage = "Drawimpl, " + message;
    }
    
    public String getResult()
    {
        return resultMessage;
    }
}
