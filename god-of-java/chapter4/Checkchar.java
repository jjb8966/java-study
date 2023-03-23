package chapter4;

public class Checkchar {

    public static void main(String[] args){
        Checkchar check = new Checkchar();
        check.checkChar();
    }
    public void checkChar(){
        char min = '\u0000';
        char max = '\uffff';    //?가 나와야하는데 왜 NULL이 나올까...
        char s = ' ';
        int charInt = 'a';
        String a=null;
        System.out.println("min="+min);
        System.out.println("max="+max);
        System.out.println("charInt="+charInt);
        System.out.println(s);
        System.out.println(a);
    }
}

