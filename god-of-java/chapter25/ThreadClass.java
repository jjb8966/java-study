package chapter25;

public class ThreadClass {

    public static void main(String[] args) {
        //1,2,3이 순서대로 호출되는게 아님. 쓰레드가 시작하면 run()이 끝나든 끝나지 않든
        //바로 다음 문장을 실행하고 다음 문장이 먼저 실행된 쓰레드보다 먼저 끝날 수 도 있음
        //클래스는 다중 상속이 안되기 때문에 Thread 클래스를 확장해야하는 2번 방법보다
        //인터페이스를 구현하는 1번 방법을 더 많이 씀
        RunnableSample runnable = new RunnableSample();
        //new Thread(runnable).start(); - 이렇게 한줄만 써도됨
        Thread runnableThread = new Thread(runnable);
        runnableThread.start();             //1

        ThreadSample thread = new ThreadSample();
        thread.start();                     //2

        System.out.println("end");          //3
    }
}


class RunnableSample implements Runnable{
    public void run(){
        System.out.println("RunnableSample run()");
    }
}

class ThreadSample extends Thread{
    public void run(){
        System.out.println("ThreadSample run()");
    }
}


