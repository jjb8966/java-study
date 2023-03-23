package chapter8;

class Child extends Parent {
    public Child() {
        System.out.println("child constructor");
    }

    static {
        System.out.println("child static block");
    }
}
