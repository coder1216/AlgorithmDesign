package HumanResource;

public class CEO extends People {
    public static final String TAG = CEO.class.getSimpleName();

    public static final String GOOD_NEWS = "I get an offer";
    public static final String BAD_NEWS = "I xx";

    public CEO(final String id, final String name) {
        super(id, name);
        position = Position.CEO;
    }

    @Override
    public void onSupervisorMessageReceived(String message) {

    }

    @Override
    public void onReportersMessageReceived(String message) {
        if (GOOD_NEWS.equals((message))) {
            // TODO
        } else if (BAD_NEWS.equals(message)) {
            // TODO
        } else {
            // TODO
        }
    }
}

