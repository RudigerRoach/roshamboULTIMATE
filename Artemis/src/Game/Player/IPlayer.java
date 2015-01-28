package Game.Player;

import Game.Moves.Move;

import java.util.Set;

public interface IPlayer
{
    public void setMove(Move playerMove);
    public Move getMove(Set<Move> possibleMoves);
    public String getName();
}
