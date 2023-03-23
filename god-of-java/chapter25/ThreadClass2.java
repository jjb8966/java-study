package chapter25;

public class ThreadClass2 {

    public static void main(String[] args){
        //매개변수를 받는 쓰레드 -> start()나 run()은 매개변수를 받지 못하기 때문에 생성자를 통해 매개변수 넘겨줌
        ParameterThread parameterThread = new ParameterThread("jjb",010);
        parameterThread.start();

        //Thread.sleep() 사용
        UseSleepMethod useSleepMethod = new UseSleepMethod();
        useSleepMethod.run();
    }
}

class ParameterThread extends Thread{
    private int number;

    ParameterThread(String name, int number){
        super(name);
        this.number = number;
    }

    public void run(){
        number++;
        System.out.println(this.getName() + ","+this.number);
    }
}

class UseSleepMethod extends Thread{
    public void run(){
        while(true) {       //break문을 만나거나 예외가 발생하지 않으면 무한루프

            //Thread.sleep()은 무조건 try-catch문으로 묶어줘야 하고 적어도 InterruptedException으로 catch 해줘야함(Exception도 가능)
            try {
                System.out.println(System.currentTimeMillis());
                Thread.sleep(1000);     //1초 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}