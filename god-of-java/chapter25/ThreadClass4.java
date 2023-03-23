package chapter25;

public class ThreadClass4 {

    public static void main(String[] args) {
        ThreadClass4 obj = new ThreadClass4();
        obj.checkThreadState();
        obj.checkJoin();
    }

    //thread state : NEW -> 특정 state(RUNNABLE, BLOCKED, WAITING, TIMED_WAITING) -> TERMINATED
    void checkThreadState(){
        SleepThread thread = new SleepThread(2000);
        try {
            System.out.println("thread state=" + thread.getState());
            thread.start();
            System.out.println("thread state(after start)=" + thread.getState());

            Thread.sleep(1000);
            System.out.println("thread state(after 1 second)=" + thread.getState());

            thread.join();
            thread.interrupt();
            System.out.println("thread state(after join)=" + thread.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void checkJoin(){
        SleepThread thread = new SleepThread(2000);
        try{
            thread.start();
            thread.join(500);       //쓰레드가 sleep중 (TIMED_WAITING)
            thread.interrupt();           //중간에 interrupt -> InterruptedException 발생
            System.out.println("thread state(after join)="+thread.getState());
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class SleepThread extends Thread {
    long sleepTime;

    SleepThread(long sleepTime) {
        this.sleepTime = sleepTime;
    }

    public void run() {
        try {
            System.out.println("sleeping " + getName());
            Thread.sleep(sleepTime);
            System.out.println("stopping " + getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
