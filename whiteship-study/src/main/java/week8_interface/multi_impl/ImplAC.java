package week8_interface.multi_impl;

public class ImplAC implements InterfaceA, InterfaceC{
    
    @Override
    public String sayHi() {
        return "hi";
    }

    public static void main(String[] args) {
        ImplAC classReference = new ImplAC();
        InterfaceA interfaceAReference = new ImplAC();
        InterfaceC interfaceCReference = new ImplAC();

        System.out.println(classReference.sayHi());
        System.out.println(interfaceAReference.sayHi());
        System.out.println(interfaceCReference.sayHi());
    }
}
