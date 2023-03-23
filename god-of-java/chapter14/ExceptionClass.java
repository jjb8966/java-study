package chapter14;

//왜 System.err.println은 맨 마지막에 실행되는가??

public class ExceptionClass {

    public static void main(String[] args) {
        ExceptionClass obj = new ExceptionClass();
        obj.exceptionMethod();
    }

    void exceptionMethod() {
        int[] exceptionArray = new int[3];          //exceptionArray[0],[1],[2] 존재
        try {
            exceptionArray[0] = 1;
            System.out.println(exceptionArray[0]);  //여기까진 정상실행
            exceptionArray[3] = 5;                  //예외 발생 -> catch 블록으로 넘어감
            System.out.println(exceptionArray[3]);  //실행x
        } catch (Exception e) {
            System.out.println("catch error(out)"); //하얀 글씨로 출력
            System.err.println("catch error(err)"); //빨간 글씨로 출력
        } finally {
            System.out.println("finally block");    //예외 발생과 무관하게 항상 실행
        }
    }
}
