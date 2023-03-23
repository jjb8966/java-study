package week11_enum.basic;

public class SameEnum {

    public static final int APPLE = 1;

    private int number;

    private static final SameEnum ONE = new SameEnum(1);
    private static final  SameEnum TWO = new SameEnum(2);
    private static final SameEnum THREE = new SameEnum(3);
    private static final SameEnum FOUR = new SameEnum(4);

    public SameEnum(int number) {
        this.number = number;
    }
}
