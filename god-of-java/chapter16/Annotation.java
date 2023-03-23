package chapter16;

public class Annotation {
    @SuppressWarnings("deprecation")    //메소드 밖에 선언해야됨
    public static void main(String[] args) {
        Parent obj = new Parent();
        obj.noMoreUse();
    }
}

class Parent{
    Parent(){
        System.out.println("Parent Constructor");
    }
    Parent(String name){
        System.out.println("Parent(String) Constructor");
    }

    public void printName(){
        System.out.println("printName() - Parent");
    }
    @Deprecated
    void noMoreUse(){
    }
}

class AnnotationOverride extends Parent{
    @Override
    public void printName(){
        System.out.println("AnnotationOverride");
    }
//    @Override
//    public void printName(String name){
//        System.out.println("AnnotationOverride");
//    }
//      ---> 에러 발생 : java: method does not override or implement a method from a supertype
//      ---> 부모 클래스에 printName(String name) 이라는 메소드가 없기 때문
}
