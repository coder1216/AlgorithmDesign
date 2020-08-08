package AnimalSwim;

public abstract class Bird {
    final String id;
    final int size;


    protected Bird(String id, int size) {
        this.id = id;
        this.size = size;
    }

    public abstract void fly();
}
