package chapter6;

public class Switchtest {

    public static void main(String[] args){
        Switchtest test = new Switchtest();
        test.Switchstatement(1);
    }

    public void Switchstatement(int num){
        switch(num){
            case 1:
                System.out.println("number1");
                //break;  -> break문이 없어서 다음 case문도 실행
            case 2:
                System.out.println("number2");
                //break;
            case 3:
                System.out.println("number3");
                break;      //break문이 나올때 까지 실행
            case 4:
                System.out.println("number4");
                break;
            default:
                System.out.println("no number");
                break;
        }
    }
}
