package Game.Engine;

public class Loseimpl implements GameResult
{
    private String resultMessage;
    
    public Loseimpl(String message)
    {
        this.resultMessage = "Lose, " + message;
    }
    
    public String getResult()
    {
        return resultMessage;
    }
}
