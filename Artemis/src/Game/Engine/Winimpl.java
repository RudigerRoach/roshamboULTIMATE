package Game.Engine;

public class Winimpl implements GameResult
{
    String resultMessage;
    
    public Winimpl(String message)
    {
        this.resultMessage = "Winimpl, " + message;
    }
    
    public String getResult()
    {
        return resultMessage;
    }
}
