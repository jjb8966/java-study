package chapter5;

public class OperatorInc {

    public static void main(String[] args){
        OperatorInc op = new OperatorInc();
        op.increment();
    }

    public void increment(){
        int value = 1;
        System.out.println(value++);
        System.out.println(value);
        System.out.println(++value);
    }
}
