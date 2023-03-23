package chapter14;

//Throwable 클래스의 메소드를 Exception 클래스에서 오버라이딩한 대표적 메소드 3개

public class ExceptionOverridingMethod {
    public static void main(String[] args) {
        ExceptionOverridingMethod obj = new ExceptionOverridingMethod();
        obj.OverridingMethod3();
    }

    void OverridingMethod3(){
        int[] Array = new int[5];
        try{
            Array[6] = 1;
        } catch (Throwable e){      //exception 캐치함
            System.out.println("---------getMessage/간단히---------");
            System.out.println(e.getMessage()); //String 반환
            System.out.println("---------toString/자세히---------");
            System.out.println(e.toString());   //String 반환
            System.out.println("---------printStackTrace/더 자세히 에러내용 출력---------");
            e.printStackTrace();                //에러 스택정보 출력
        }
    }
}