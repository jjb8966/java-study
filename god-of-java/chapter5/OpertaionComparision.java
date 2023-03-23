package chapter5;

public class OpertaionComparision {

    public static void main(String[] args){
        OpertaionComparision opc = new OpertaionComparision();
        opc.comparison();
    }

    public void comparison(){
        char charValue = 'a';
        System.out.println(charValue==97);
        int intValue = 1;
        double doubleValue = 1.0;
        System.out.println(intValue==doubleValue);  //타입이 달라도 숫자끼리는 비교 가능
    }
}
