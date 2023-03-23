package chapter25;

public class ThreadClass3 {
    public static void main(String[] args) {
        ThreadClass3 threadClass3 = new ThreadClass3();
        threadClass3.calc();
    }
    void calc(){
        Calculate cal = new Calculate();
        ThreadSynchronized thread1 = new ThreadSynchronized(cal, true);
        ThreadSynchronized thread2 = new ThreadSynchronized(cal, true);

        thread1.start();
        thread2.start();
        try {
            //thread.join() -> 쓰레드가 종료될 때까지 기다리는 메소드
            //이게 없으면 두 쓰레드가 종료되기 전에 sout을 실행하므로 제대로된 결과를 얻을 수 없음
            thread1.join();
            thread2.join();
            System.out.println(cal.getAmount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Calculate{
    private int amount;
    /**
     * synchronized에 사용할 lock 객체 생성
     * 블록에 먼저 들어간 쓰레드의 처리가 끝나면 대기하고 있던 다른 쓰레드에게 기회를 주는 문지기 역할
     * amount 외 다른 변수를 이용한다면 다른 lock 객체를 생성해서 사용하는게 좋음 (ex. amount1-lock1 / amount2-lock2)
     */
    Object lock = new Object();

    void zero(){
        amount=0;
    }
    /**
     * 동일한 객체의 plus()와 minus() 메소드는 한 순간에 하나의 쓰레드만 사용할 수 있음
     * 먼저 온 쓰레드의 메소드 연산이 끝나면 기다리고 있던 다른 쓰레드가 이용할 수 있음
     * synchronized void plus(int i) -> 메소드 선언에 synchronized를 추가할 수도 있지만
     * 그렇게 되면 synchronized가 필요 없는 부분에서 대기시간이 발생해 성능에 좋지 않음.
     * 따라서 필요한 부분만 synchronized(lock)으로 처리함
    */
     void plus(int i){
        synchronized (lock) {
            amount += i;
        }
    }
    void minus(int i){
        synchronized (lock) {
            amount -= i;
        }
    }
    int getAmount(){
        return amount;
    }
}

class ThreadSynchronized extends Thread{
    private Calculate cal;
    private boolean flag;

    ThreadSynchronized(Calculate cal, boolean flag){
        this.cal = cal;
        this.flag = flag;
    }

    public void run() {
        for (int i = 0; i < 10000; i++) {
            if (flag) {
                cal.plus(1);
            } else {
                cal.minus(1);
            }
        }
    }
}

