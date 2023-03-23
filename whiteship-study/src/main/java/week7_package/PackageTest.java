package week7_package;

import week7_package.parent.child.ChildClass;
import week7_package.parent.child.baby.BabyClass;

public class PackageTest {

    public static void main(String[] args) {
        ChildClass childClass = new ChildClass();
        BabyClass babyClass = new BabyClass();

        System.out.println(ChildClass.staticValue);
        ChildClass.staticMethod();
    }
}
