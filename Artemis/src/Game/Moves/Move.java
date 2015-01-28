package Game.Moves;

public class Move {
    String moveName;
    public Move(String name){
        moveName = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Move)) return false;

        Move move = (Move) o;

        if (!moveName.equals(move.moveName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return moveName.hashCode();
    }
}
