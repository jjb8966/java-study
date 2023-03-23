package chapter8;

public class Parent {

    public Parent() {
        System.out.println("parent constructor");
    }

    static {                                 // static 블록은 객체 생성 시 생성자보다 먼저 실행되며 한번만 실행됨
        System.out.println("parent static block1");
    }

    static {
        System.out.println("parent static block2");
    }
}
