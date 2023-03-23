package chapter10;

public class InheritanceClass {

    public static void main(String[] args) {
        ChildClass child = new ChildClass();
    }
}

class ParentClass {

    //    public ParentClass() {
//        System.out.println("ParentClass constructor");
//    }
    public ParentClass(String name) {
        System.out.println("Parent name is " + name);
    }
}

class ChildClass extends ParentClass {

    ChildClass() {
        super("HI");        //부모 클래스의 생성자를 명시적으로 지정
        System.out.println("ChildClass constructor");
    }
}

