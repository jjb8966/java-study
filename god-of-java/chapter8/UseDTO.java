package chapter8;

public class UseDTO {
    void printUserInformation(User user) {
        System.out.println("이름 : " + user.getName());
        System.out.println("주소 : " + user.getAddress());
        System.out.println("전화번호 : " + user.getPhoneNumber());
    }

    User changeName(User user, String newName) {
        User newUser = new User(newName, user.getAddress(), user.getPhoneNumber());
        return newUser;
    }

    public static void main(String[] args) {
        UseDTO useDTO = new UseDTO();
        User user = new User("홍길동", "상도동", 1234);

        useDTO.printUserInformation(user);
        System.out.println("---------------------");

        User userNameChanged = useDTO.changeName(user, "김길동");
        useDTO.printUserInformation(userNameChanged);
    }
}

class User {
    private String name;
    private String address;
    private int phoneNumber;

    public User() {
    }

    //알고있는 DTO 클래스의 멤버변수에 따라 다양한 생성자를 만들 수 있음
    public User(String name) {
        this.name = name;
    }

    public User(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public User(String name, String address, int phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    //Getter & Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}