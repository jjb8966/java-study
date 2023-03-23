package week12_annotation.basic;

import java.lang.reflect.Method;

public class UseMyAnnotation {

    @MyAnnotation(text = "asd")
    void defaultMethod() {

    }

    @MyAnnotation(number = 3, text = "hi")
    void sampleMethod() {
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = UseMyAnnotation.class.getDeclaredMethod("sampleMethod");

        MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
        int number = annotation.number();
        String text = annotation.text();

        System.out.println("입력받은 text를 number만큼 반복시키는 어노테이션");
        for (int i = 0; i < number; i++) {
            System.out.print(text);
        }
    }
}
