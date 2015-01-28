package Game.Player;

import Game.Moves.Move;

public class ComputerPlayer implements IPlayer {
    private Move move;
    private String name;

    @Override
    public Move getMove() {
        return move;
    }

    @Override
    public void setMove(Move move) {
        this.move = move;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
