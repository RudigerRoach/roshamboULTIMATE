package Game.Player;

import Game.Moves.Move;

import java.util.Collection;
import java.util.Set;

public interface Player
{
    public void setMove(Move playerMove);
    public Move getMove(Collection<Move> possibleMoves);
    public String getName();
    public String getMoveName();
}
