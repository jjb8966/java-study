package week9_exception.multicatch_block;

public class MultiCatchBlock {

    void originBlock(int flag) {
        try {
            if (flag == 1) {
                throw new IllegalArgumentException();
            }

            if (flag == 2) {
                throw new ArithmeticException();
            }

            if (flag == 3) {
                throw new NullPointerException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("예외 발생");
        } catch (ArithmeticException e) {
            System.out.println("예외 발생");
        } catch (NullPointerException e) {
            System.out.println("예외 발생");
        }
    }

    void useMultiCatch(int flag) {
        try {
            if (flag == 1) {
                throw new IllegalArgumentException();
            }

            if (flag == 2) {
                throw new ArithmeticException();
            }

            if (flag == 3) {
                throw new NullPointerException();
            }
        } catch (IllegalArgumentException | ArithmeticException | NullPointerException e) {
            System.out.println("예외 발생");
        }
    }
}
