package chapter13;

public class ImplementClass implements FirstInterface, SecondInterface {

    String name;
    int age;
    char grade;
    float money;

    ImplementClass(String name, int age, char grade, float money) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.money = money;
    }

    public String returnName() {
        return this.name;
    }

    public int returnAge() {
        return this.age;
    }

    public char returnGrade() {
        return this.grade;
    }

    public float returnMoney() {
        return this.money;
    }
}
