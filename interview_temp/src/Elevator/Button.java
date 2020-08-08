package Elevator;

public abstract class Button {
    private final String id;

    protected final int levelNumber;

    public Button(final String id, final int levelNumber){
        this.id = id;
        this.levelNumber = levelNumber;
    }

    public String getId() {
        return id;
    }

    public void calLevelNumber() {

    }
}
