package week9_exception.checked_unchecked;

public class CheckedOrUnchecked {

    public static void main(String[] args) throws MyCheckedException {
        String nulls = null;
        System.out.println(nulls);
    }

    static void forCheckedExceptionV2(int number) throws MyCheckedException {
        if (number > 12) {
            throw new MyCheckedException();
        }
    }

    static void forUncheckedException(int number) {
        if (number > 12) {
            throw new MyUncheckedException();
        }
    }
}
