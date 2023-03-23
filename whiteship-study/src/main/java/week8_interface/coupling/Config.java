package week8_interface.coupling;

public class Config {

    public Accelerator accelerator() {
        return new OldAccel();
        // 만약 newAccel 로 바꾸고 싶다면?
        // return new NewAccel();
    }
}
