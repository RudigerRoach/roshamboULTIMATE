package Game.Player;

import Game.Moves.Move;

import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class ComputerPlayer implements IPlayer
{
    private Random randomNumberGen;
    public Move move;
    
    public ComputerPlayer()
    {
        randomNumberGen = new Random();
    }

    @Override
    public void setMove(Move computerMove)
    {
        move = computerMove;
    }
    
    @Override
    public Move getMove(Collection<Move> possibleMoves)
    {
        Random randomNumberGenerator = new Random(System.nanoTime());
        int randomNumber = randomNumberGenerator.nextInt(possibleMoves.size()-1);
        Iterator<Move> it = possibleMoves.iterator();
        int i =0;
        while(it.hasNext() && i<randomNumber)
        {
            it.next();
            i++;
        }
        return it.next();
    }

    @Override
    public String getMoveName()
    {
        return move.getMoveName();
    }
    @Override
    public String getName()
    {
        return "Computer";
    }
}
