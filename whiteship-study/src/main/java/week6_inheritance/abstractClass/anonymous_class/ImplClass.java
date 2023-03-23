package week6_inheritance.abstractClass.anonymous_class;

public class ImplClass implements OneMethodInterface{

    @Override
    public void hi() {
        System.out.println("hi");
    }

    void bye() {
        System.out.println("bye");
    }
}
