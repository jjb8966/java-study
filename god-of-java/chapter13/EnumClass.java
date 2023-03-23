package chapter13;

public class EnumClass {

    public static void main(String[] args) {

        Season spring = Season.SPRING;      //생성자를 호출하지 않고 'enum클래스.상수이름' 만으로 객체가 생성됨

        String a = Season.SUMMER.getFirstWord();
        int b = Season.SUMMER.getNumber();
        int c = Season.SUMMER.multipleNumber();
        System.out.println(a + " " + b + " " + c);
        // S 2 4
    }
}

enum Season {
    SPRING("S", 1) {     // 생성자를 호출한 모양

        @Override
        int multipleNumber() {
            return number * 1;
        }
    },

    SUMMER("S", 2) {
        @Override
        int multipleNumber() {
            return number * 2;
        }
    },

    FALL("F", 3) {
        @Override
        int multipleNumber() {
            return number * 3;
        }
    },

    WINTER("W", 4) {
        @Override
        int multipleNumber() {
            return number * 4;
        }
    };

    private final String firstWord;
    protected final int number;         //private으로 선언하면 enum 상수에서 오러라이딩 할 수 없기 때문에 protected로 선언

    Season(String firstWord, int number) {
        this.firstWord = firstWord;
        this.number = number;
    }

    public String getFirstWord() {
        return firstWord;
    }

    public int getNumber() {
        return number;
    }

    abstract int multipleNumber();      //abstract로 선언하여 모든 enum 상수가 이 메소드를 구현하게 만듦
}