package week11_enum.type_safety;

public class NotTypeSafety {

    public static final int MONDAY = 1;
    public static final int TUESDAY = 2;
    public static final int WEDNESDAY = 3;

    public static final int APPLE = 1;
    public static final int BANANA = 2;
    public static final int PEACH = 3;

    public static void main(String[] args) {
        int day = MONDAY;
        int fruit = APPLE;

        printDay(day);
        printDay(fruit);

        printFruit(day);
        printFruit(fruit);

        if (day == fruit) {
            System.out.println("날짜는 과일입니다");
        } else {
            System.out.println("날짜는 과일이 아닙니다.");
        }
    }

    static void printDay(int day) {
        if (day == 1) {
            System.out.println("오늘은 월요일입니다.");
        }

        if (day == 2) {
            System.out.println("오늘은 화요일입니다.");
        }

        if (day == 3) {
            System.out.println("오늘은 수요일입니다.");
        }
    }

    static void printFruit(int fruit) {
        if (fruit == 1) {
            System.out.println("사과입니다.");
        }

        if (fruit == 2) {
            System.out.println("바나나입니다.");
        }

        if (fruit == 3) {
            System.out.println("복숭아입니다.");
        }
    }
}
