package Elevator;

public enum Direction {
    //The Enum class that represent 3 status of a elevator
    UP("UP",1),
    STOP("STOP",0),
    DOWN("DOWN", -1);

    private final String direction;

    private final int value;

    Direction(final String direction, final int value){
        this.direction = direction;
        this.value = value;
    }

    public String toString(){
        return direction;
    }

    public int getValue(){
        return value;
    }
}
