package week9_exception.throw_change_exception;

public class ChangeException {

    public static void main(String[] args) {
        ChangeException ce = new ChangeException();

        try {
            ce.changeByMyException();
        } catch (MyException e) {
            System.out.println("내가 만든 예외로 던져짐");
            System.out.println("원인인 " + e.getCause());
        }

    }

    void throwIllegalArgumentException() {
        throw new IllegalArgumentException();
    }

    void changeByMyException() {
        try {
            throwIllegalArgumentException();
        } catch (IllegalArgumentException e) {
            throw new MyException("내가 만든 예외로 바꿔서 던지기", e);
        }
    }
}
