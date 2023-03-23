package week9_exception.throw_change_exception;

public class MyException extends RuntimeException{

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }
}
