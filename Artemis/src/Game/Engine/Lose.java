package Game.Engine;

public class Lose implements IGameResult
{
    private String resultMessage;
    
    public Lose(String message)
    {
        this.resultMessage = "Lose, " + message;
    }
    
    public String getResult()
    {
        return resultMessage;
    }
}
