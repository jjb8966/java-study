package week8_interface.functional_interface;

public class AnonymousTest {

    public static void main(String[] args) {
        FunctionalInterface anonymousObj = new FunctionalInterface() {
            @Override
            public void onlyOneMethod() {
                System.out.println("hi");
            }
        };

        FunctionalInterface anonymousObj2 = () -> System.out.println("hihi");
    }
}
