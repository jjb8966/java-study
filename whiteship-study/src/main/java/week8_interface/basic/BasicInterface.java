package week8_interface.basic;

public interface BasicInterface {
    // public static final 가 자동으로 적용됨
    // + final 키워드가 붙으므로 반드시 선언 시 초기화 되어야 함
    public static final int a = 10;

    // public abstract 가 자동으로 적용됨
    public abstract void basicMethod();
}
