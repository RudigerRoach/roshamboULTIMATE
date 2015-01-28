package Game.Engine;

public class Draw implements IGameResult
{
    String message;
    
    public Draw(String message)
    {
        this.message = message;
    }
    
    public String getResult()
    {
        throw new UnsupportedOperationException();
    }
}
