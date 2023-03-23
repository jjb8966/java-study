package chapter8;

public class StaticResource {

    static int a = 10;

    StaticResource() {
        this.a++;
        System.out.println(a);
    }

    public static void main(String[] args) {
        System.out.println(a);                                  //객체를 생성하지 않고도 접근 가능
        StaticResource staticvariable1 = new StaticResource();
        StaticResource staticvariable2 = new StaticResource();  //서로 다른 객체가 공유해서 사용
    }
}
