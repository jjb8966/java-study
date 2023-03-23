package week8_interface.default_staic_method;

public interface UsedInterface {

    void hi();

    // bye 기능을 추가해야함
    //void bye(); -> 인터페이스를 구현한 구현체에서 에러가 남 (추가된 추상 메소드가 구현되지 않았으므로)

    default void bye(int count) {    // 구현체에서 에러가 안남 -> default method 오버라이딩하지 않아도 되므로
        System.out.println("start bye");

        validCheckAndRepeat(count);      // 내부에 복잡한 로직이 있다면 private 메소드를 만들어서 분리할 수 있음

        System.out.println("end bye");
    }

    private void validCheckAndRepeat(int count) {
        if (count < 10) {
            for (int i = 0; i < count; i++) {
                System.out.println("bye");
            }
        }
    }

    static void staticMethod() {
        System.out.println("모든 구현체에서 이 메소드를 사용해라");
    }
}
