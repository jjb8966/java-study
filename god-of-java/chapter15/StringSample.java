package chapter15;

public class StringSample {

    public static void main(String[] args) {
        StringSample sample = new StringSample();
        sample.convertBasic();
        sample.convertUTF16Wrong();
        sample.convertUTF16Correct();
    }

    void printByteArray(byte[] array) {
        for (byte data : array) {
            System.out.print(data + " ");
        }
        System.out.println();
    }

    void convertBasic() {
        try {
            String korean = "한글";
            byte[] array1 = korean.getBytes();       //getBytes() : 기본 캐릭터 셋(UTF-8)의 바이트 배열을 생성
            printByteArray(array1);
            String korean2 = new String(array1);     //String(byte[] bytes) 생성자 : 사용중인 플랫폼의 캐릭터 셋(UTF-8)을 사용해
            System.out.println(korean2);             //byte배열을 디코딩한 String 객체를 생성
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void convertUTF16Wrong() {
        try {
            String korean = "한글";
            byte[] array = korean.getBytes("UTF-16");   //UTF-16 캐릭터 셋으로 바이트 배열을 생성
            printByteArray(array);
            String korean2 = new String(array);                     //UTF-8을 사용해 byte 배열을 디코딩함
            System.out.println(korean2);                            //결과 -> 알아볼 수 없는 문자가 표시됨
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void convertUTF16Correct() {
        try {
            String korean = "한글";
            byte[] array = korean.getBytes("UTF-16");   //UTF-16 캐릭터 셋으로 바이트 배열을 생성
            printByteArray(array);
            String korean2 = new String(array, "UTF-16"); //UTF-16을 사용해 byte 배열을 디코딩함
            System.out.println(korean2);                            //결과 -> 제대로 표시됨
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
