package Elevator;

public class Request {

    protected final int levelNumber;

    public Request(final int levelNumber){
        this.levelNumber = levelNumber;
    }

    public int getLevelNumber(){
        return levelNumber;
    }
}
