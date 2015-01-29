package Game.Engine;

import Exceptions.InvalidResultException;

public class GameResultFactory
{
    private GameResultFactory()
    {}

    public static GameResult parseGameResult(String gameResultString, String message) throws InvalidResultException {
        if(gameResultString.toUpperCase().compareTo("WIN")==0)
            return new Winimpl(message);
        else if(gameResultString.toUpperCase().compareTo("LOSE")==0)
            return new Loseimpl(message);
        else if(gameResultString.toUpperCase().compareTo("DRAW")==0)
            return new Drawimpl(message);
        throw new InvalidResultException();
    }
}
