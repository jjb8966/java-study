package chapter33;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * 1. static method reference
 * 2. instance method reference
 * 3. constructor reference
 */
public class MethodReference {

    interface Executable {      // 매번 이런 인터페이스를 만들기 번거로우므로 Consumer 인터페이스 사용
        void doSomething(String text);
    }

    public static class Printer {
        private String name;

        public Printer(String name) {
            this.name = name;
        }

        static void staticMethod(String text) {
            System.out.println(text);
        }

        void instanceMethod() {
            System.out.println(name);
        }
    }

    private static void staticMethodReference() {
        String[] fruits = {"사과", "바나나", "복숭아"};

        System.out.println("<정적 메소드 참조>");
        // String stream의 각 string들이 Printer 클래스의 staticMethod의 매개변수로 넘겨져 정적 메소드 실행
        Arrays.stream(fruits).forEach(Printer::staticMethod);
    }

    private static void staticMethodReferenceByInstance() {
        // Executable 인터페이스의 doSomething 메소드를 Printer 클래스의 staticMethod 메소드를 참조하여 구현
        Executable print1 = text -> Printer.staticMethod(text);
        Executable print2 = Printer::staticMethod;
        // Executable 인터페이스 대신 이미 정의된 Consumer 인터페이스를 이용해 간단하게 구현
        Consumer<String> print3 = Printer::staticMethod;

        System.out.println("<정적 메소드를 참조해 구현한 인터페이스 인스턴스의 메소드>");
        print1.doSomething("hi");
        print2.doSomething("hello");
        print3.accept("bye");
    }

    private static void instanceMethodReference() {
        List<Printer> printers = Arrays.asList(new Printer("Samsung"), new Printer("LG"), new Printer("Apple"));

        System.out.println("<인스턴스 메소드 참조>");
        // 각 인스턴스의 메소드 실행
        printers.stream().forEach(Printer::instanceMethod);
        //= printers.stream().forEach(printer -> printer.instanceMethod());
    }

    private static void constructorReference() {
        List<String> printerNames = Arrays.asList("Google", "Xiaomi");

        System.out.println("<생성자 참조>");
        printerNames.stream()
                .map(Printer::new)
                .forEach(Printer::instanceMethod);

// 아래 코드와 동일
//                .map(printerName -> new Printer(printerName))
//                .forEach(printer -> printer.instanceMethod());
    }

    public static void main(String[] args) {
        staticMethodReference();
        staticMethodReferenceByInstance();

        instanceMethodReference();

        constructorReference();
    }

}
