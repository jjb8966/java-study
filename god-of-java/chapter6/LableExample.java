package chapter6;

public class LableExample {

    public static void main(String[] args){
        LableExample obj = new LableExample();
        obj.lableTest();
    }

    public void lableTest(){
        except3:
        for(int i=1; i<10; i++){
            if(i==3){continue except3;}     //구구단 3단을 제외시키는 lable
            for(int j=1; j<10; j++){
                System.out.print(i + "x" + j + "=" + i*j + " ");
            }
            System.out.println("");
        }
    }
}
