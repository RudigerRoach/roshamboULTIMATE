package Game.Player;

import Game.Moves.Move;

import java.util.Collection;
import java.util.Random;
import java.util.Set;

public class ComputerPlayer implements IPlayer
{
    private Random randomNumberGen;
    
    public ComputerPlayer()
    {
        randomNumberGen = new Random();
    }

    @Override
    public void setMove(Move computerMove)
    {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public Move getMove(Collection<Move> possibleMoves)
    {
        return ((Move[])(possibleMoves.toArray()))[randomNumberGen.nextInt(possibleMoves.size())];
    }

    @Override
    public String getName()
    {
        return "Computer";
    }
}
