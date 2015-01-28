package Game.Engine;

import Game.Moves.Move;

public interface IMoveSource {
    public Move getMove();
    public Move getMoveFromName(String name);
}
