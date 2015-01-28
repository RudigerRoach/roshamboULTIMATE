package Game.Engine;

import Exceptions.InvalidResultException;

public class GameResultFactory
{
    private GameResultFactory()
    {}

    public static IGameResult parseGameResult(String gameResultString, String message) throws InvalidResultException {
        if(gameResultString.toUpperCase().compareTo("WIN")==0)
            return new Win(message);
        else if(gameResultString.toUpperCase().compareTo("LOSE")==0)
            return new Lose(message);
        else if(gameResultString.toUpperCase().compareTo("DRAW")==0)
            return new Draw(message);
        throw new InvalidResultException();
    }
}
