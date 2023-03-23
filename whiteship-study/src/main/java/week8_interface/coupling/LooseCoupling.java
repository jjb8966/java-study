package week8_interface.coupling;

public class LooseCoupling {

    public static void main(String[] args) {
        Car car = new Car();
        Config config = new Config();

        car.setAccel(config.accelerator());
        // 만약 newAccel 로 바꾸고 싶다면?
        // Accelerator 를 주입해주는 Config 클래스를 수정해주면 됨
    }
}
