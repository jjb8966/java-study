package week9_exception.anti_pattern;

public class AntiPattern {

    int returnInFinally(boolean flag) {
        try {
            System.out.println("try");

            if (flag) {
                throw new RuntimeException();
            }

            return 1;
        } catch (RuntimeException e) {
            System.out.println("catch");
            return 2;
        } finally {
            System.out.println("finally");
            return 3;
        }
    }

    public static void main(String[] args) {
        AntiPattern anti = new AntiPattern();
        System.out.println(anti.returnInFinally(false));    // 예외가 발생하지 않았는데도 return 3
    }
}
