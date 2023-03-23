package chapter13;

public class InterfaceClass {

    public static void main(String[] args) {
        ImplementClass implementObj = new ImplementClass("jjb", 29, 'A', 10000000000.0F);
        System.out.println(implementObj.returnName());
        System.out.println(implementObj.returnAge());
        System.out.println(implementObj.returnGrade());
        System.out.println(implementObj.returnMoney());
    }
}
