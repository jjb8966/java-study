package chapter10;

public class Polymorphism {

    public static void main(String[] args) {
        Polymorphism obj = new Polymorphism();
        Parent[] humanArray = new Parent[3];
        humanArray[0] = new Parent();
        humanArray[1] = new Child1();
        humanArray[2] = new Child2();
        obj.polymorphismFunction(humanArray);

    }

    void polymorphismFunction(Parent[] human) {
        for (int i = 0; i < 3; i++) {
            if (human[i] instanceof Child1) {
                human[i].func();
            } else if (human[i] instanceof Child2) {
                human[i].func();
            } else if (human[i] instanceof Parent) {
                human[i].func();
            }
        }
    }
}
