package week6_inheritance.abstractClass.anonymous_class;

public class AnonyTest {

    public static void main(String[] args) {
        OneMethodInterface implObject = new ImplClass();

        OneMethodInterface implObject2 = new ImplClass2();

        Class<? extends OneMethodInterface> aClass = implObject.getClass();

        System.out.println(aClass);

        ImplClass implObject3 = new ImplClass() {
            @Override
            public void bye() {
                System.out.println("byebye");
            }
        };

        OneMethodInterface implObject4 = () -> System.out.println("hihihihi");

        implObject.hi();
        implObject2.hi();
        implObject3.hi();
        implObject4.hi();
        implObject3.bye();
    }
}
