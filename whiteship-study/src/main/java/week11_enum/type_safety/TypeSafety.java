package week11_enum.type_safety;

public class TypeSafety {

    enum Day {MONDAY, TUESDAY, WEDNESDAY}

    enum Fruit {APPLE, BANANA, PEACH}

    public static void main(String[] args) {
        Day day = Day.MONDAY;
        Fruit fruit = Fruit.APPLE;

        printDay(day);
//        printDay(fruit);  -> 타입 체크로 인한 컴파일 에러

//        printFruit(day);  -> 타입 체크로 인한 컴파일 에러
        printFruit(fruit);

        if (day.equals(fruit)) {
            System.out.println("날짜는 과일입니다.");
        } else {
            System.out.println("날짜는 과일이 아닙니다.");
        }
    }

    private static void printDay(Day day) {
        if (day == Day.MONDAY) {
            System.out.println("오늘은 월요일입니다.");
        }

        if (day == Day.TUESDAY) {
            System.out.println("오늘은 화요일입니다.");
        }

        if (day == Day.WEDNESDAY) {
            System.out.println("오늘은 수요일입니다.");
        }
    }

    private static void printFruit(Fruit fruit) {
        if (fruit == Fruit.APPLE) {
            System.out.println("사과입니다.");
        }

        if (fruit == Fruit.BANANA) {
            System.out.println("바나나입니다.");
        }

        if (fruit == Fruit.PEACH) {
            System.out.println("복숭아입니다.");
        }
    }
}
