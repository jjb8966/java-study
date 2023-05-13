package week14_generic;

import java.util.ArrayList;
import java.util.List;

public class GenericTypeCheck {

    public static void main(String[] args) {
        List<String> list = new ArrayList();

        list.add("hi");
        list.add("good");
//        list.add(1); 컴파일 에러 발생 -> 1. 타입 안정성 제공

        /**
         * 제네릭을 사용하지 않는 경우
         * -> 형변환 후 사용해야 함
         */
        for (Object o : list) {
            String exp = (String) o;

            System.out.println("exp = " + exp);
        }

        /**
         * 제네릭을 사용하는 경우
         * -> 2. 형변환 없이 사용 가능
         */
        for (String s : list) {
            System.out.println("s = " + s);
        }
    }
}
