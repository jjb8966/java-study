package chapter8;

public class Constructor {
    public static void main(String[] args) {
        MemberDTO mem1 = new MemberDTO("hong");
        MemberDTO mem2 = new MemberDTO("joo", "naver");
        MemberDTO mem3 = new MemberDTO();
        System.out.println(mem1.name);
        System.out.println(mem2.name + " " + mem2.email);
        System.out.println(mem3.name + " " + mem3.email + " " + mem3.phone);
    }
}

class MemberDTO {
    public String name;
    public String email;
    public String phone;

    MemberDTO() {
        this("jjb", "google", "010");
    }

    public MemberDTO(String name) {
        this.name = name;
    }

//이건 안됨
//  public MemberDTO(String email){
//      this.email=email;
//    }

    public MemberDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public MemberDTO(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
}