package Game.Engine;

public class Win implements IGameResult
{
    String message;
    
    public Win(String message)
    {
        this.message = message;
    }
    
    public String getResult()
    {
        throw new NotImplementedException();
    }
}
