package chapter8;
//질문
//we are really dealing with object-handles called references which are passed-by-value as well.
//->이 말은 자바의 reference라고 불리는 object-handles은 pass by value라는거임?? 뭔말이지 이게

//fun1에서는 객체에 새로운 객체를 저장했는데 dog가 안바뀜 -> pass by value
//fun2에서는 매개변수로 받은 객체의 멤버변수를 직접 바꿨더니 dog가 바뀜 -> pass by reference??



public class PassByValue {

    public static void main(String[] args) {
        Dog dog = new Dog("cute dog");
        Dog otherDog = dog;
        fun1(dog);                                              //전달한 dog에 새로운 Dog 객체[ugly dog] 저장함
        System.out.println("-----fun1------");
        System.out.println(dog.getName());
        System.out.println(dog.getName().equals("cute dog"));
        System.out.println(dog.getName().equals("ugly dog"));   //위에 3문장을 통해 dog가 바뀌지 않았음을 알 수 있음
        System.out.println(dog.equals(otherDog));
        System.out.println(otherDog.getName());                 //otherDog도 바뀌지 않음
        fun2(dog);
        System.out.println("-----fun2------");                  //전달한 dog의 멤버변수를 직접 수정함
        System.out.println(dog.getName());
        System.out.println(dog.getName().equals("cute dog"));
        System.out.println(dog.getName().equals("ugly dog"));   //위에 3문장을 통해 dog의 이름이 바뀌었음을 알 수 있음
        System.out.println(dog.equals(otherDog));
        System.out.println(otherDog.getName());                 //otherDog도 바뀜
    }

    static void fun1(Dog dog) {
        dog = new Dog("ugly dog");
    }

    static void fun2(Dog dog) {
        dog.name = "ugly dog";
    }
}

class Dog {
    String name;

    Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
