package week8_interface.inheritance;

public class InterfaceInheritance implements SecondInterface{

    // 상속받은 인터페이스를 구현하는 클래스는 구현하는 인터페이스의 부모 인터페이스도 구현해야 함
    @Override
    public void firstMethod() {
        System.out.println("hi");
    }

    @Override
    public void secondMethod() {
        System.out.println("hihi");
    }

    void myMethod() {
        System.out.println("hihihi");
    }

    public static void main(String[] args) {
        System.out.println("----------클래스 레퍼런스----------");
        InterfaceInheritance multiple = new InterfaceInheritance();
        multiple.firstMethod();
        multiple.secondMethod();
        multiple.myMethod();

        System.out.println("----------인터페이스 레퍼런스----------");
        SecondInterface useInterface = new InterfaceInheritance();
        useInterface.firstMethod();
        useInterface.secondMethod();
        //useInterface.myMethod(); -> useInterface 변수는 SecondInterface 타입이므로 myMethod 가 없음
    }
}
