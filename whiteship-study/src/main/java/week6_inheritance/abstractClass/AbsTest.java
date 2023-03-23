package week6_inheritance.abstractClass;

public class AbsTest {

    public static void main(String[] args) {

        /**
         * 1. 추상 클래스는 단독으로 인스턴스화 할 수 없음
         * -> 익명 클래스를 만들고 객체를 생성함
         * 2. 추상 클래스에 추상 메소드가 없어도 에러는 안남
         * but, 추상 메소드 유무와 상관없이 상속받은 클래스는 하나 이상의 메소드를 오버라이딩 해야함
         * 3. 추상 메소드가 있다면 그 메소드는 무조건 오버라이딩 해야함
         */
        AbsClass absClass = new AbsClass(10) {
            @Override
            public void printA() {
                super.printA();
            }
        };
    }
}
