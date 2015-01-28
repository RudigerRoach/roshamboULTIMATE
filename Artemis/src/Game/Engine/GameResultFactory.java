package Game.Engine;

import Exceptions.InvalidResultException;

public class GameResultFactory
{
    private GameResultFactory()
    {}

    public static IGameResult parseGameResult(String gameResultString, String message) throws InvalidResultException {
        if(gameResultString.toUpperCase() == "WIN")
            return new Win(message);
        else if(gameResultString.toUpperCase() == "LOSE")
            return new Lose(message);
        else if(gameResultString.toUpperCase() == "DRAW")
            return new Draw(message);
        throw new InvalidResultException();
    }
}
