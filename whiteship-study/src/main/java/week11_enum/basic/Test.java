package week11_enum.basic;

import week11_enum.BasicEnum;

public class Test {

    static void enumParamMethod(Enum param) {
        System.out.println(param);
    }

    public static void main(String[] args) {
        BasicEnum one = BasicEnum.ONE;

        if (one.equals(BasicEnum.ONE)) {
            System.out.println(true);
        }

        enumParamMethod(BasicEnum.TWO);

        // enum 의 필드값을 final 로 선언하지 않은 경우
        // -> 값이 변경될 수 있음
//        System.out.println(InitializeEnum.ONE.getNumber());
//        InitializeEnum.ONE.setNumber(10);
//        System.out.println(InitializeEnum.ONE.getNumber());

        int num = InitializeEnum.THREE.multipleFive();
        System.out.println("num = " + num);

        InitializeEnum[] values = InitializeEnum.values();

        for (InitializeEnum value : values) {
            System.out.println("value = " + value);
        }

        InitializeEnum findEnum = InitializeEnum.valueOf("ONE");

        System.out.println("findEnum = " + findEnum);

        int ordinal = InitializeEnum.THREE.ordinal();

        System.out.println("ordinal = " + ordinal);

        int gap = InitializeEnum.THREE.compareTo(InitializeEnum.TWO);

        System.out.println("gap = " + gap);

        String nameMethod = InitializeEnum.ONE.name();
        String toStringMethod = InitializeEnum.ONE.toString();

        System.out.println("nameMethod = " + nameMethod);
        System.out.println("toStringMethod = " + toStringMethod);
        Class<InitializeEnum> declaringClass = InitializeEnum.THREE.getDeclaringClass();
        System.out.println("declaringClass = " + declaringClass);
    }
}
