package week9_exception.basic;

public class TestClass {

    public static void main(String[] args) throws Exception {
        MonthClass obj = new MonthClass();
        obj.printMonth(12);
        System.out.println("-----------------------");
        obj.printMonth(13);
    }
}
