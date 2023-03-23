package week6_inheritance.dto_test;

public class DtoTest {

    public static void main(String[] args) {
        MemberDTO memberDTO = new MemberDTO("홍길동", 10);
        MemberDTO memberDTO2 = new MemberDTO("홍길동", 10);

        System.out.println("memberDTO = " + memberDTO.toString());

        if (memberDTO.equals(memberDTO2)) {
            System.out.println("같은 사람임");
        }
    }
}
