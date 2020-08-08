package HumanResource;

public class Teacher extends People{
    public static final String TAG = Teacher.class.getSimpleName();

    public Teacher(String id, String name) {
        super(id, name);
        position = Position.TEACHER;
    }

    @Override
    public void onSupervisorMessageReceived(String message) {
        sendReportersMessage(message);
    }

    @Override
    public void onReportersMessageReceived(String message) {
        sendSupervisorsMessage(message);
    }
}
