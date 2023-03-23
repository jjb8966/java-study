package week9_exception.checked_unchecked;

public class MyCheckedException extends Exception {
    public MyCheckedException() {
    }

    public MyCheckedException(String message) {
        super(message);
    }

    public MyCheckedException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyCheckedException(Throwable cause) {
        super(cause);
    }

    public MyCheckedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
