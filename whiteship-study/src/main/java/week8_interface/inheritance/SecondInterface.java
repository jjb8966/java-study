package week8_interface.inheritance;

public interface SecondInterface extends FirstInterface {

//    인터페이스끼리 상속은 상속받았다고 꼭 오버라이딩 해야하는 것은 아님
//    @Override
//    void firstMethod();

    void secondMethod();

//    @Override
//    default void overMethod() {
//        FirstInterface.super.overMethod();
//    }
}
