package Game.Engine;

public class GameResultFactory
{
    private GameResultFactory()
    {}

    public static IGameResult parseGameResult(String gameResultString, String message)
    {
        return new Win(message); // TODO
    }
}
