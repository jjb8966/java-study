package chapter11;

public class ToStringMethod {

    public static void main(String[] args) {
        Banana banana = new Banana();
        Apple apple = new Apple();
        System.out.println(banana);
        System.out.println("HI " + apple);
        System.out.println("Hello " + apple.toString());
    }
}

