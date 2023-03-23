package week8_interface.default_staic_method;

public class HiAndBye implements UsedInterface{

    @Override
    public void hi() {
        System.out.println("hi");
    }

    @Override
    public void bye(int count) {
        System.out.print("good");
        UsedInterface.super.bye(count);
    }
}
