package chapter14;

public class ThrowException {

    public static void main(String[] args) {
        ThrowException obj = new ThrowException();
        obj.ThrowMethod(14);
        //obj.ThrowMethod2(15);             //이렇게 사용하면 예외가 발생해도 잡아주는 곳이 없기 때문에 컴파일 에러남
        try {                                //ThrowMethod2에 의해 던져진 예외를 잡기위해 여기서 try-catch문 사용해야 함
            obj.ThrowMethod2(15);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void ThrowMethod(int number) {
        try {
            if (number > 12) {
                throw new Exception("number is over than 12");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    void ThrowMethod2(int number) throws Exception {    //이 메소드를 호출한 곳으로 예외를 던짐
        if (number > 12) {
            throw new Exception("overthan 12");
        }
    }
}
