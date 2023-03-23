package week8_interface.coupling;

public class TightCoupling {

    public static void main(String[] args) {
        Car car = new Car();
        Accelerator oldAccel = new OldAccel();

        car.setAccel(oldAccel);

        // 만약 newAccel 로 바꾸고 싶다면?
        Accelerator newAccel = new NewAccel();
        car.setAccel(newAccel);
    }
}
