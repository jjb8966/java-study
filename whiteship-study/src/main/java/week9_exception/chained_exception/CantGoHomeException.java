package week9_exception.chained_exception;

public class CantGoHomeException extends Exception {

    public CantGoHomeException(Throwable cause) {
        super(cause);
    }
}
