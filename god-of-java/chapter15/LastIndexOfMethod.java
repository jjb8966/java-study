package chapter15;

public class LastIndexOfMethod {
    public static void main(String[] args){
        String str = "My name is Jow Jong Bum";     //Jow의 o 인덱스 : 12 , Jong의 o 인덱스 : 16 Bum의 m 인덱스 : 22
        System.out.println(str.lastIndexOf('M'));
        System.out.println(str.lastIndexOf('m'));
        System.out.println("-------Jow의 o------");
        System.out.println(str.lastIndexOf('o', 11));
        System.out.println(str.lastIndexOf('o', 12));
        System.out.println(str.lastIndexOf('o', 13));
        System.out.println("-------Jong의 o------");
        System.out.println(str.lastIndexOf('o', 15));
        System.out.println(str.lastIndexOf('o', 16));
        System.out.println(str.lastIndexOf('o', 17));
    }
}
