package week10_thread.basic;

public class ThreadEx extends Thread{

    int number;

    public ThreadEx(int param) {
        number = param;
    }

    // 모든 생성자 오버라이딩
    public ThreadEx() {
    }

    public ThreadEx(Runnable target) {
        super(target);
    }

    public ThreadEx(ThreadGroup group, Runnable target) {
        super(group, target);
    }

    public ThreadEx(String name) {
        super(name);
    }

    public ThreadEx(ThreadGroup group, String name) {
        super(group, name);
    }

    public ThreadEx(Runnable target, String name) {
        super(target, name);
    }

    public ThreadEx(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
    }

    public ThreadEx(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
    }

    public ThreadEx(ThreadGroup group, Runnable target, String name, long stackSize, boolean inheritThreadLocals) {
        super(group, target, name, stackSize, inheritThreadLocals);
    }

    @Override
    public void run() {
        System.out.println("hi Thread");
        System.out.println("aaaaaaa");
        // 쓰레드의 필드를 사용하는 부분을 만나면 이 부분은 가장 마지막에 실행하는듯... 뭐지
        System.out.println("use param : " + number);
        System.out.println("bbbbbbb");
        System.out.println("가가가가가가");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
