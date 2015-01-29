package Game.Player;

import Game.Moves.Move;

import java.util.Collection;

public class HumanPlayerimpl implements Player {
    private String playerName;
    private Move   playerMove;

    public HumanPlayerimpl(String playerName)
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
