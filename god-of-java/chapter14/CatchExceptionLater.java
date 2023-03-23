package chapter14;

public class CatchExceptionLater {

    public static void main(String[] args) {
        CatchExceptionLater obj = new CatchExceptionLater();
        obj.catchException();
    }

    void catchException() {
        int[] Array = new int[3];
        try {
            Array = null;                                 //null 예외 발생
            Array[5] = 1;
        } catch (NullPointerException e) {
            System.out.println("널 예외 발생");              //NullPointerException 예외 캐치함
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("인덱스 범위 벗어난 예외 발생");  //실행x
        } catch (Exception e) {
            System.out.println("나머지 예외사항 발생");        //실행x
        }
        System.out.println("무조건 실행되는 문장");
    }
}
