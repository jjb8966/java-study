package week8_interface.coupling;

public class OldAccel implements Accelerator {

    @Override
    public void accelerate() {
        System.out.println("옛날 엑셀");
    }
}
