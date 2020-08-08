package HumanResource;

public class Student extends People{
    public static final String TAG = Student.class.getSimpleName();

    public Student(String id, String name) {
        super(id, name);
        position = Position.STUDENT;
    }

    @Override
    public void onSupervisorMessageReceived(String message) {

    }

    @Override
    public void onReportersMessageReceived(String message) {

    }
}
