package week11_enum.basic;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Test2 {

    public static void main(String[] args) {
        InitializeEnum one = InitializeEnum.ONE;

        System.out.println(InitializeEnum.TWO.multipleFive());

        System.out.println(one.getNumber());
        System.out.println("i = " + one.multipleFive());

        System.out.println(InitializeEnum.TWO.individual());

        System.out.println(InitializeEnum.ONE.toString());
    }
}
