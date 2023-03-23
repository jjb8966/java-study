package chapter11;

import java.util.Objects;

class Banana {

    int count;

    Banana() {
    }

    Banana(int number) {
        count = number;
    }
    //IDE에서 자동으로 오버라이딩 해줌
    @Override
    public String toString() {
        return "Banana{" +
                "count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Banana banana = (Banana) o;
        return count == banana.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}
