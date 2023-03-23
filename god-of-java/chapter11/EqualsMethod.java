package chapter11;

public class EqualsMethod {

    public static void main(String[] args) {
        Banana banana1 = new Banana(1);
        Banana banana5 = new Banana(5);
        Banana banana10 = new Banana(1);

        System.out.println(banana1);
        System.out.println(banana5);
        System.out.println(banana10);

        if (banana1.equals(banana5)) {
            System.out.println("same fruit");
        } else {
            System.out.println("different fruit");
        }

        if (banana1.equals(banana10)) {
            System.out.println("same fruit");
        } else {
            System.out.println("different fruit");
        }
    }
}
