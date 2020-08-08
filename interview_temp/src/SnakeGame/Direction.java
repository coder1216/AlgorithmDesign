package SnakeGame;

public enum Direction {
    /*
     *      !->[0,0]
     *      e e e e e
     *      e e e e e
     *      e e e e e
     *      e e e e e
     *
     * */
    Up("Up", new int[]{-1, 0}),
    Down("Down", new int[]{1, 0}),
    Right("Right", new int[]{0, 1}),
    Left("Left", new int[]{0, -1});

    final String direction;
    final int[] value;

    Direction(final String direction, final int[] value){
        this.direction = direction;
        this.value = value;
    }

    public String getDirection() {
        return direction;
    }

    public int[] getValue() {
        return new int[0];
    }
}
