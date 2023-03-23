package chapter15;

public class NullCheck {
    public static void main(String[] args) {
        NullCheck obj = new NullCheck();
        obj.nullCheckMethod("good");
        obj.nullCheckMethod(null);
    }

    boolean nullCheckMethod(String str) {
        //int a = str.length();
        //---> NullPointerException 예외를 발생시킴
        if (str == null) {
            System.out.println("this is null");
            return true;
        } else {
            System.out.println("this is not null");
            int textLength = str.length();
            System.out.println("length is " + textLength);
            return false;
        }
    }
}
