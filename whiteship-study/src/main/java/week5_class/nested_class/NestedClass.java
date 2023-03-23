package week5_class.nested_class;

public class NestedClass {

    static class StaticInnerClass {
        int a;
    }

    class InnerClass {
        int a;
    }

    void useLocalClass() {
        class LocalClass {
            int a;
        }

        LocalClass localClass = new LocalClass();

    }
    public static void main(String[] args) {

    }
}