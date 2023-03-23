package week8_interface.default_staic_method;

public class UseInterfaceClass {

    public static void main(String[] args) {
        OnlyHi impl1 = new OnlyHi();
        HiAndBye impl2 = new HiAndBye();

        impl1.hi();

        impl2.hi();
        impl2.bye(9);

        //impl1.staticMethod();
        UsedInterface.staticMethod();
    }
}
