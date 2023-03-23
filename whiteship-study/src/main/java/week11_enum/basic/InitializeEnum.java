package week11_enum.basic;

public enum InitializeEnum {
    ONE(1) {
        @Override
        int individual() {
            return this.getNumber() * 1;
        }
    },
    TWO(2) {
        @Override
        int individual() {
            return this.getNumber() * 2;

        }
    },
    THREE(3) {
        @Override
        int individual() {
            return this.getNumber() * 3;
        }
    };

    //    private int number;
    private final int number;

    InitializeEnum(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public int multipleFive() {
        return number * 5;
    }

    abstract int individual();

    @Override
    public String toString() {
        return "안녕하세요. " + this.name() + "입니다.";
    }
}
