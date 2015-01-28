package Game.Engine;

import Game.Moves.Move;

public class MovePairKey
{
    private Move move1;
    private Move move2;

    public MovePairKey(Move move1, Move move2)
    {
        this.move1 = move1;
        this.move2 = move2;
    }
}
