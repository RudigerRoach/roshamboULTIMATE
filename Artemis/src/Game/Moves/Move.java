package Game.Moves;

public class Move {
    private String moveName;
    public Move(String name){
        moveName = name;
    }

    public void setMoveName(String moveName) {
        this.moveName = moveName;
    }

    public String getMoveName(){
        return this.moveName;
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
