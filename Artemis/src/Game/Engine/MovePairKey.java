package Game.Engine;

import Game.Moves.Move;

public class MovePairKey
{
    private Move move1;
    private Move move2;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MovePairKey)) return false;

        MovePairKey that = (MovePairKey) o;
        if(!move1.equals(that.move1))
            return false;
        if(!move2.equals(that.move2))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = move1 != null ? move1.hashCode() : 0;
        result = 31 * result + (move2 != null ? move2.hashCode() : 0);
        return result;
    }

    public MovePairKey(Move move1, Move move2)
    {
        this.move1 = move1;
        this.move2 = move2;
    }


}
