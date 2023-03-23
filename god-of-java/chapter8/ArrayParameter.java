package chapter8;

public class ArrayParameter {
    public static void main(String[] args){
        ArrayParameter arrp = new ArrayParameter();
        int[] arr = {1,2,3,4,5};
        arrp.fun1(new int[] {1,2,3,4,5});   //배열을 넘겨줘야함
        arrp.fun2(arr);          //1,2,3만 넘겨도 배열로 인식
    }
    public void fun1(int[] number) {
        for (int i = 0; i < number.length; i++) {
            System.out.print(number[i]+" ");
        }
        System.out.println();
    }
    public void fun2(int...number){
        for (int i = 0; i < number.length; i++) {
            System.out.print(number[i]+" ");
        }
        System.out.println();
    }
}
