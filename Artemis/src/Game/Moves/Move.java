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
    public boolean equals(Object other)
    {
        if(other.getClass() != this.getClass())
            return false;
        Move o = (Move) other;
        if(o.moveName != this.moveName)
            return false;
        return true;
    }
}
