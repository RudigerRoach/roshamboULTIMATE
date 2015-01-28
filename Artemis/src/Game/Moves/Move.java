package Game.Moves;

public class Move {
    String moveName;
    public Move(String name){
        moveName = name;
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
