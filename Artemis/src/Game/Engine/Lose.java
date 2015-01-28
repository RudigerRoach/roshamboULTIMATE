package Game.Engine;

public class Lose implements IGameResult
{
    String message;
    
    public Lose(String message)
    {
        this.message = message;
    }
    
    public String getResult()
    {
        throw new UnsupportedOperationException();
    }
}
