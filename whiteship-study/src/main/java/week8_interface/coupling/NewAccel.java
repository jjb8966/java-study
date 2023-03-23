package week8_interface.coupling;

public class NewAccel implements Accelerator {

    @Override
    public void accelerate() {
        System.out.println("최신 엑셀");
    }
}
