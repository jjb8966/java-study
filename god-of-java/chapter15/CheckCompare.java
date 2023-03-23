package chapter15;

public class CheckCompare {

    public static void main(String[] args) {
        CheckCompare obj = new CheckCompare();
        String str1 = "hellow world";
        String str2 = "hellow world";
        String str3 = new String("hellow world");
        String str4 = "Hellow world";

        obj.compareMethod(str1, str2);
        obj.compareMethod(str1, str3);
        obj.compareMethod(str1, str4);

        //str2는 constant pool에서 재활용한 객체이므로 str1과 같은 객체임. / str1==str2 -> true
        //str3는 str1과 값은 같지만 constant pool에서 값을 재활용하지 않고 새로 생성한 객체. / str1==str3 -> false
    }

    void compareMethod(String txt1, String txt2) {
        System.out.println("-------------------------------");
        if (txt1 == txt2) {
            System.out.println(txt1 + "==" + txt2 + "의 결과는 true");
        } else {
            System.out.println(txt1 + "==" + txt2 + "의 결과는 false");
        }
        if (txt1.equals(txt2)) {              //대소문자 구분 o
            System.out.println(txt1 + ".equals(" + txt2 + ")의 결과는 true");
        } else {
            System.out.println(txt1 + ".equals(" + txt2 + ")의 결과는 false");
        }
        if (txt1.equalsIgnoreCase(txt2)) {    //대소문자 구분 x
            System.out.println(txt1 + ".equalsIgnoreCase(" + txt2 + ")의 결과는 true");
        } else {
            System.out.println(txt1 + ".equalsIgnoreCase(" + txt2 + ")의 결과는 false");
        }
    }
}
