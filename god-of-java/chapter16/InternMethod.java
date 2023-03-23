package chapter16;

public class InternMethod {
    public static void main(String[] args) {
        String a = "apple";
        String b = new String("apple");
        String c = "apple";
        String d = new String("apple");
        String e = d.intern();      //string pool에 있던 apple을 반환

        String g = new String("banana");
        String h = g.intern();      //string pool에 banana 저장
        String i = "banana";        //string pool에 있던 banana 재사용

        InternMethod obj = new InternMethod();

        System.out.println("a,b");
        obj.equalCheck(a, b);
        System.out.println("a,c");
        obj.equalCheck(a, c);
        System.out.println("b,d");
        obj.equalCheck(b, d);
        System.out.println("a,e");
        obj.equalCheck(a, e);
        System.out.println("a,g");
        obj.equalCheck(a, g);
        System.out.println("h,i");
        obj.equalCheck(h, i);

    }

    void equalCheck(String a, String b) {
        if (a == b) {
            System.out.println("== 결과 : true");
        } else {
            System.out.println("== 결과 : false");
        }

        if (a.equals(b)) {
            System.out.println("equals() 결과 : true");
        } else {
            System.out.println("equals() 결과 : false");
        }
    }
}
