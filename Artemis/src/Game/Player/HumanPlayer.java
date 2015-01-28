package Game.Player;

import Game.Moves.Move;

import java.util.Collection;
import java.util.Set;

public class HumanPlayer implements IPlayer {
    private String playerName;
    private Move   playerMove;

    public HumanPlayer(String playerName)
    {
        this.playerName = playerName;
    }
    
    @Override
    public void setMove(Move playerMove)
    {
        this.playerMove = playerMove;
    }
    
    @Override
    public Move getMove(Collection<Move> possibleMoves)
    {
        return playerMove;
    }

    @Override
    public String getName()
    {
        return playerName;
    }

    @Override
    public String getMoveName() {
        return playerMove.getMoveName();
    }
}
