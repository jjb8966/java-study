package week8_interface.default_staic_method;

public class UseInterfaceImpl {

    public static void main(String[] args) {
        OnlyHi impl1 = new OnlyHi();
        HiAndBye impl2 = new HiAndBye();

        impl1.hi();

        impl2.hi();
        impl2.bye(9);

        //impl1.staticMethod(); -> 구현 객체를 통해 static method를 호출할 수 없음
        UsedInterface.staticMethod();
    }
}
