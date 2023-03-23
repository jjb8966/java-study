package week9_exception.chained_exception;

public class LoseMoneyException extends RuntimeException {
    private String message = "돈을 잃어버려서 집을 못감";

    @Override
    public String getMessage() {
        return message;
    }
}
