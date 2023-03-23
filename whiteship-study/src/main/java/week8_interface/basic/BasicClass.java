package week8_interface.basic;

public class BasicClass implements BasicInterface, BasicInterface2 {

    @Override
    public void basicMethod() {
        System.out.println("hi");
    }

    @Override
    public void basic2() {
        System.out.println("hihi");
    }
}
