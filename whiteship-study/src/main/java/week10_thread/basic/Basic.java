package week10_thread.basic;

public class Basic {

    public static void main(String[] args) {
        RunnableImpl runnable = new RunnableImpl();
        ThreadEx thread = new ThreadEx();

//        // 세 줄의 실행 결과가 순서가 보장되지 않음
//        new Thread(runnable).start();   // hi Runnable
//        thread.start();                 // hi Thread
//        System.out.println("hi main");

        // 뒤죽박죽 호출
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 5; i++) {
                RunnableImpl newRunnable = new RunnableImpl();
                ThreadEx newThread = new ThreadEx(new ThreadGroup(String.valueOf(j)), newRunnable, "Thread " + i);

                new Thread(new ThreadGroup(String.valueOf(j)), newRunnable, "Runnable " + i).start();
                newThread.start();
            }
        }
//
//        ThreadEx paramThread = new ThreadEx(10);
//        paramThread.start();

        System.out.println("hi main");

    }
}
