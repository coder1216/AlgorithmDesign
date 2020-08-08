package Elevator;

public class ExternalRequest extends Request{
    private final Direction direction;

    public ExternalRequest(final int levelNumber, final Direction direction) {
        super(levelNumber);
        this.direction = direction;
    }

    public Direction getDirection(){
        return this.getDirection();
    }
}
