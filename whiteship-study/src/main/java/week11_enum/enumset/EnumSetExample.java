package week11_enum.enumset;

import week11_enum.BasicEnum;

import java.util.*;

public class EnumSetExample {

    public static void main(String[] args) {
        Set<BasicEnum> realSet = new HashSet<>();
        realSet.add(BasicEnum.ONE);
        realSet.add(BasicEnum.TWO);
        realSet.add(BasicEnum.THREE);

        // enum 에 선언된 모든 상수 객체를 한번에 Set 으로 저장하고 싶은 경우
        // enum 에 새로운 값이 추가되거나 이름이 바뀌어도 Set 관련 코드를 수정할 필요가 없음
        EnumSet enumSet1 = EnumSet.allOf(BasicEnum.class);
        System.out.println("enumSet1 = " + enumSet1);
        System.out.println(enumSet1.contains(BasicEnum.ONE));

        // enum 에 선언된 순서를 바꾸거나 일부만 저장하고 싶은 경우
        EnumSet enumSet2 = EnumSet.of(BasicEnum.THREE, BasicEnum.TWO);
        System.out.println("enumSet2 = " + enumSet2);

        // 특정 EnumSet 을 제외한 나머지로 구성되는 EnumSet
        EnumSet enumSet3 = EnumSet.complementOf(enumSet2); // BasicEnum.ONE
        System.out.println("enumSet3 = " + enumSet3);

        // 범위로 지정한 EnumSet
        EnumSet enumSet4 = EnumSet.range(BasicEnum.TWO, BasicEnum.THREE);
        System.out.println("enumSet4 = " + enumSet4);

        // 범위가 잘못되면 IllegalArgumentException 발생
//        EnumSet enumSet5 = EnumSet.range(BasicEnum.THREE, BasicEnum.ONE);
//        System.out.println("enumSet5 = " + enumSet5);

        // EnumMap 이라는 것도 있음
        EnumMap enumMap = new EnumMap(BasicEnum.class);
        enumMap.put(BasicEnum.ONE, 1);
        enumMap.put(BasicEnum.THREE, "삼");
        System.out.println("enumMap = " + enumMap);
    }
}
