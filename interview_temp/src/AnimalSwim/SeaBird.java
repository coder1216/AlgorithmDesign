package AnimalSwim;

public class SeaBird extends Bird implements Swimmable {
    public static final String TAG = SeaBird.class.getSimpleName();

    public SeaBird(String id, int size) {
        super(id, size);
    }

    @Override
    public void fly() {

    }

    @Override
    public void swim() {

    }
}
