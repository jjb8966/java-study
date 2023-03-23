package week9_exception.chained_exception;

public class ShutDownBusException extends RuntimeException{
    private String message = "버스가 끊겨서 집을 못감";

    @Override
    public String getMessage() {
        return message;
    }
}
