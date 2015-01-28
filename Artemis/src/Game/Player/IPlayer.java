package Game.Player;

import Game.Moves.Move;

public interface IPlayer {
        public Move getMove();
        public void setMove(Move move);
        public void setName(String name);
        public String getName();
}
