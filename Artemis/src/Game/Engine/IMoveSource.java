package Game.Engine;

import Game.Moves.Move;

import java.util.Collection;
import java.util.Set;

public interface IMoveSource {
    public Move getMoveFromName(String name);
    public Set<String> getPossibleMovesStrings();
    public Collection<Move> getPossibleMoves();

}
