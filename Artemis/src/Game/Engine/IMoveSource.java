package Game.Engine;


import Game.Moves.Move;

public interface IMoveSource {
    public Move getMoveFromName(String name);
}
