package chapter33;

public class LambdaExpression {

    @FunctionalInterface
    interface Calculate {
        // 매개변수가 있는 메소드
        int operation(int a, int b);
    }

    @FunctionalInterface
    interface Hi {
        // 매개변수가 없는 메소드
        void hi();
    }

    public static void main(String[] args) {

        // 익명 클래스로 인터페이스를 구현한 경우 -> 코드가 길어지고 가독성이 떨어짐
        Calculate calculateAdd = new Calculate() {
            @Override
            public int operation(int a, int b) {
                return a+b;
            }
        };

        // 람다 표현식으로 인터페이스를 구현한 경우
        Calculate calculateSubtract = (a,b) -> a-b;

        Hi sayHi = ()->{
            System.out.println("hi");
            System.out.println("hello");
        };

        System.out.println(calculateAdd.operation(2,1));
        System.out.println(calculateSubtract.operation(2,1));
        sayHi.hi();
    }
}
