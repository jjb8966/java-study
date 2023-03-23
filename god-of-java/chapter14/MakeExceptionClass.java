package chapter14;

class NewException extends Exception {
    NewException() {
        super();
    }

    NewException(String str) {
        super(str);
    }
}

public class MakeExceptionClass {

    public static void main(String[] args) {
        MakeExceptionClass obj = new MakeExceptionClass();
        try {
            obj.newThrowException(14);
        } catch (Exception e) {                //여기서 NewException으로 받아도 되고 Exception으로 받아도 됨
            System.out.println(e.toString());
        }
    }

    void newThrowException(int number) throws NewException {
        if (number > 12) {
            throw new NewException("12 초과");
        }
    }
}