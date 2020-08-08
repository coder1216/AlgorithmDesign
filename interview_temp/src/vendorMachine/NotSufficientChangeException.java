package vendorMachine;

public class NotSufficientChangeException extends RuntimeException{
    private String message;

    public NotSufficientChangeException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
