# 10주차 : 멀티쓰레드 프로그래밍

# Thread

> 프로세스 내의 실행 흐름(작업) 단위
>
- 자바 프로그램 시작 → 프로세스 시작 → 여러 개의 쓰레드가 실행됨
    - main 메소드가 시작하면서 하나의 쓰레드가 시작됨
    - 만약 많은 쓰레드가 필요하다면?
        - main 메소드에서 쓰레드를 생성해서 사용함
        - 톰캣 같은 WAS도 main 메소드에서 실행한 여러 쓰레드를 수행하는 것
- 사용 목적
    - 하나의 작업을 동시에 수행하기 위해서
    - 동시 작업을 위해 여러 프로세스를 실행하는 것은 비용이 매우 많이 들어감
    - 쓰레드는 프로세스에 비해 훨씬 적은 비용이 들어감
        - 쓰레드 = 경량 프로세스

# Runnable 인터페이스 & Thread 클래스

> 쓰레드를 생성 및 실행하기 위해 필요한 클래스와 인터페이스
>
- 둘 다 java.lang에 있음
- run() 메소드를 오버라이딩하여 쓰레드가 동작할 행동을 정의해야 함
- 쓰레드의 시작은 Thread의 start() 메소드

## Runnable 인터페이스

- run() 메소드 하나만 존재하는 인터페이스 (Functional Interface)

    ```java
    @FunctionalInterface
    public interface Runnable {
        
        public abstract void run();
    }
    ```

- Runnable 인터페이스를 구현한 클래스로 바로 쓰레드를 시작할 순 없음
    1. Thread 객체를 만들고 생성자 매개변수로 Runnable 구현체를 넣어줌
    2. start() 메소드 실행

    ```java
    public class RunnableImpl implements Runnable {
    
        @Override
        public void run() {
            System.out.println("hi Runnable");
        }
    }
    ```

    ```java
    public class Basic {
    
        public static void main(String[] args) {
            RunnableImpl runnable = new RunnableImpl();
    
            new Thread(runnable).start();
        }
    }
    
    ```


## Thread 클래스

- Runnable 인터페이스를 구현한 클래스
- run() 메소드를 오버라이딩하고 start() 메소드를 호출하여 쓰레드 시작

    ```java
    public class ThreadEx extends Thread{
    
        @Override
        public void run() {
            System.out.println("hi Thread");
        }
    }
    ```

    ```java
    package week10_thread.basic;
    
    public class Basic {
    
        public static void main(String[] args) {
            ThreadEx thread = new ThreadEx();
    
            thread.start();
        }
    }
    ```


## 왜 2가지 방법으로 쓰레드를 구현할까?

- 쓰레드로 사용하려는 클래스가 다른 클래스의 상속을 받아야 할 경우
    - 다중 상속을 받을 수 없으므로 Thread 클래스를 상속받을 수 없음

      → Runnable 인터페이스를 구현해서 사용

    - 그렇지 않은 경우에는 Thread 클래스를 바로 상속받아서 더 편하게 쓰레드를 사용할 수 있음

## 쓰레드 실행 결과

```java
package week10_thread.basic;

public class Basic {

    public static void main(String[] args) {
        RunnableImpl runnable = new RunnableImpl();
        ThreadEx thread = new ThreadEx();

        // 세 줄의 실행 결과가 순서가 보장되지 않음
        new Thread(runnable).start();   // hi Runnable
        thread.start();                 // hi Thread
        System.out.println("hi main");
    }
}
```

- 프로그램 실행 결과 위의 출력하는 코드 3줄의 실행 순서가 보장되지 않음
    - 쓰레드는 다른 쓰레드의 종료 시점까지 기다리지 않고 자기 차례가 되면 바로 시작함
- thread.start()
    - JVM에 쓰레드를 추가하여 실행한다는 의미
    - 각 쓰레드의 run() 메소드 시작 순서는 동일
        - but, 종료 순서는 다름!

          → 실행 결과의 순서가 보장되지 않는 이유


## Thread 생성자

- 매개변수

  ![Untitled](https://user-images.githubusercontent.com/87421893/172391283-533366d0-a141-4773-98d5-2a7c580e02fc.png)

    - ThreadGroup group
        - group에 속하는 쓰레드를 생성
            - 쓰레드 생성 시 지정한 그룹으로 묶는 것
        - ThreadGroup으로 묶어놓으면 여러 메소드를 통해 다양한 정보를 얻을 수 있음
    - Runnable target
        - target 객체가 구현한 run() 메소드를 실행하는 쓰레드를 생성
    - String name
        - 쓰레드의 이름을 지정
        - 모든 쓰레드에는 이름이 있음
            - 미지정 시 ‘Thread-n’
            - n은 생성된 순서에 따라 증가함
            - 쓰레드의 이름이 겹쳐도 에러나 예외가 발생하지 않음
    - long stackSize
        - 해당 쓰레드의 최대 스택 크기를 지정

## 쓰레드에서 매개변수를 받고 싶은 경우

- 쓰레드 생성 시 매개변수를 받아서 처리

    ```java
    public class ThreadEx extends Thread{
    
        int number;
    
        public ThreadEx(int param) {
            number = param;
        }
       
        @Override
        public void run() {
            System.out.println("hi Thread");
            System.out.println("파라미터로 넘겨받은 " + number + "을 run에서 사용");
        }
    }
    ```

    ```java
    public class Basic {
    
        public static void main(String[] args) {
    
            ThreadEx paramThread = new ThreadEx(10);
            paramThread.start();
    
            System.out.println("hi main");
        }
    }
    ```


## Sleep() 메소드

- Thread 클래스의 static 메소드
    - static 메소드이지만 메소드를 사용하는 각 쓰레드에 동작하는 메소드
    - 보통 쓰레드의 동작을 정의하는 run() 메소드 내부에서 사용
- 매개변수

  
![Untitled 1](https://user-images.githubusercontent.com/87421893/172391429-8302def2-2984-4589-a82f-b02d728ed535.png)


    - long millis
        - 밀리초 단위 숫자 입력

          ex) 1000(10^3) 밀리초 → 1초

    - int nanos
        - 나노초 단위 숫자 입력

          ex) 1000000000(10^9) 나노초 → 1초

- `InterruptedException` (CheckedException)을 발생시킬 수 있기 때문에 예외 처리를 해줘야 함

    ```java
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("hi Thread");
            System.out.println("파라미터로 넘겨받은 " + number + "을 run에서 사용");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    ```


# Thread 상태

![Untitled 2](https://user-images.githubusercontent.com/87421893/172391518-05538e39-8343-41ab-9f48-e0308d12f949.png)

출처 : [https://sujl95.tistory.com/63](https://sujl95.tistory.com/63)

### 1. NEW

> 쓰레드 객체가 생성되고 아직 시작되지 않은 상태
>

### 2. RUNNABLE

> 쓰레드가 실행중인 상태
>
- 쓰레드가 JVM에서 실행 중인 상태
    - 프로세서와 같은 운영 체제의 다른 리소스를 기다리고 있을 수 있음

### 3. BLOCKED

> 쓰레드 실행 중지 상태
>
- monitor lock을 기다리는 상태
    - synchronized 블록 또는 메소드에 들어가길(or reenter) 기다리는 상태

      = 사용하려고 하는 리소스의 락이 해제되길 기다리는 상태


### 4. WAITING

> 쓰레드 대기 상태
>
- wait(), join() 메서드 등을 통해 대기하고 있는 상태
    - 다른 쓰레드의 notify() 또는 notifyAll() 호출을 기다리고 있음

### 5. TIMED_WAITING

> 쓰레드가 특정 시간만큼 대기중인 상태
>
- sleep(), wait(), join() 메소드를 통해 정해진 시간만큼 대기하고 있는 상태

### 6. TERMINATED

> 쓰레드가 종료된 상태
>

---

- Thread 클래스에 내부 enum으로 선언되어 있음

    ```java
    public enum State {
            /**
             * Thread state for a thread which has not yet started.
             */
            NEW,
    
            /**
             * Thread state for a runnable thread.  A thread in the runnable
             * state is executing in the Java virtual machine but it may
             * be waiting for other resources from the operating system
             * such as processor.
             */
            RUNNABLE,
    
            /**
             * Thread state for a thread blocked waiting for a monitor lock.
             * A thread in the blocked state is waiting for a monitor lock
             * to enter a synchronized block/method or
             * reenter a synchronized block/method after calling
             * {@link Object#wait() Object.wait}.
             */
            BLOCKED,
    
            /**
             * Thread state for a waiting thread.
             * A thread is in the waiting state due to calling one of the
             * following methods:
             * <ul>
             *   <li>{@link Object#wait() Object.wait} with no timeout</li>
             *   <li>{@link #join() Thread.join} with no timeout</li>
             *   <li>{@link LockSupport#park() LockSupport.park}</li>
             * </ul>
             *
             * <p>A thread in the waiting state is waiting for another thread to
             * perform a particular action.
             *
             * For example, a thread that has called {@code Object.wait()}
             * on an object is waiting for another thread to call
             * {@code Object.notify()} or {@code Object.notifyAll()} on
             * that object. A thread that has called {@code Thread.join()}
             * is waiting for a specified thread to terminate.
             */
            WAITING,
    
            /**
             * Thread state for a waiting thread with a specified waiting time.
             * A thread is in the timed waiting state due to calling one of
             * the following methods with a specified positive waiting time:
             * <ul>
             *   <li>{@link #sleep Thread.sleep}</li>
             *   <li>{@link Object#wait(long) Object.wait} with timeout</li>
             *   <li>{@link #join(long) Thread.join} with timeout</li>
             *   <li>{@link LockSupport#parkNanos LockSupport.parkNanos}</li>
             *   <li>{@link LockSupport#parkUntil LockSupport.parkUntil}</li>
             * </ul>
             */
            TIMED_WAITING,
    
            /**
             * Thread state for a terminated thread.
             * The thread has completed execution.
             */
            TERMINATED;
        }
    ```

- getState() 메소드를 통해 쓰레드 상태 확인 가능

# Thread 우선순위

### 1. MAX_PRIORITY

> 쓰레드가 가질 수 있는 최대 우선순위
>

### 2. MIN_PRIORITY

> 쓰레드가 가질 수 있는 최소 우선순위
>

### 3. NORM_PRIORITY

> 쓰레드가 생성될 때 가지는 기본 우선순위
>
- Thread 클래스에 int 상수로 정의되어 있음

  ![스크린샷_2022-06-07_오전_11 31 04](https://user-images.githubusercontent.com/87421893/172391582-e7b19bdc-7525-4a4f-bce6-9047cee2e6bc.png)


## 언제 쓰는가? `보충필요`

# Main Thread

> 자바 프로세스를 시작하는 main() 메소드를 실행하는 쓰레드
>
- 메인 쓰레드만 사용하는 애플리케이션

  = 싱글 쓰레드 애플리케이션

- [멀티 쓰레드 애플리케이션](https://www.notion.so/1-b6641bc71c374340a852a9731ca1ef50)
    - 메인 쓰레드에서 여러 쓰레드를 생성해 실행하는 애플리케이션

# Demon Thread

> 메인 쓰레드의 작업을 보조하는 쓰레드
>
- 데몬 쓰레드로 설정한 쓰레드는 자신의 작업이 끝나지 않아도 다른 실행중인 일반 메소드가 없으면 멈춤
    - 메인 쓰레드가 종료되면 데몬 쓰레드도 종료됨
- 사용법
    - thread.setDaemon(true)
- 사용 목적
    - 메인 쓰레드 종료 전까지 실행하다가 메인 쓰레드 종료 시 프로세스가 종료되게 하고 싶을 때 사용

      ex) 모니터링 쓰레드

        - 모니터링을 위해 계속 실행중인 상태
        - 프로세스를 종료하기 위해 메인 쓰레드를 종료하면 같이 종료되어야 함
            - 이 때 모니터링 쓰레드를 데몬 쓰레드로 설정하지 않으면 프로세스가 종료되지 않음

# 동기화 (Synchronized)

> 여러 개의 쓰레드가 동일한 리소스에 접근하여 사용하려고 할 때 1개의 쓰레드만 사용하도록 하는 기능
>
- Thread-Safe를 보장하기 위해 사용함
    - 만약 Thread-Safe하지 않다면 하나의 쓰레드가 리소스를 변경하면 다른 쓰레드에서 예상치 못한 결과가 발생함
- 리소스의 lock을 얻어서 하나의 쓰레드만 사용할 수 있도록 함
    - 모든 객체는 1개의 lock을 가짐
    - 해당 객체의 lock을 가지고 있는 쓰레드만 객체를 사용할 수 있음
    - 객체의 lock을 가지고 있는 쓰레드는 `[임계 영역](https://www.notion.so/Thread-Critical-Section-Synchronized-acd11645491047dc98f798e3fadc5a6b)`의 코드를 수행함

## [monitor](https://www.notion.so/monitor-331f859f299a4bcbb7a54530e83d9cc1) - `정리필요`

## 동기화 방법 - `보충필요`

1. Synchronized
2. Atomic
3. Volatile

# Object 클래스의 쓰레드 관련 메소드

### wait()

> 다른 쓰레드가 해당 객체에 대해 notify() 또는 notifyAll()을 호출할 때까지 대기하도록 함
>

### notify()

> 소유한 모니터의 WaitSet에서 대기중인 쓰레드 하나를 깨워서 실행시킴
>
- WaitSet → EntrySet → lock 획득

### notifyAll()

> 소유한 모니터의 WaitSet에서 대기중인 모든 쓰레드를 깨워서 실행시킴
>

```java
/**
     * Wakes up a single thread that is waiting on this object's
     * monitor. If any threads are waiting on this object, one of them
     * is chosen to be awakened. The choice is arbitrary and occurs at
     * the discretion of the implementation. A thread waits on an object's
     * monitor by calling one of the {@code wait} methods.
     * <p>
     * The awakened thread will not be able to proceed until the current
     * thread relinquishes the lock on this object. The awakened thread will
     * compete in the usual manner with any other threads that might be
     * actively competing to synchronize on this object; for example, the
     * awakened thread enjoys no reliable privilege or disadvantage in being
     * the next thread to lock this object.
     * <p>
     * This method should only be called by a thread that is the owner
     * of this object's monitor. A thread becomes the owner of the
     * object's monitor in one of three ways:
     * <ul>
     * <li>By executing a synchronized instance method of that object.
     * <li>By executing the body of a {@code synchronized} statement
     *     that synchronizes on the object.
     * <li>For objects of type {@code Class,} by executing a
     *     synchronized static method of that class.
     * </ul>
     * <p>
     * Only one thread at a time can own an object's monitor.
     *
     * @throws  IllegalMonitorStateException  if the current thread is not
     *               the owner of this object's monitor.
     * @see        java.lang.Object#notifyAll()
     * @see        java.lang.Object#wait()
     */
    @HotSpotIntrinsicCandidate
    public final native void notify();

    /**
     * Wakes up all threads that are waiting on this object's monitor. A
     * thread waits on an object's monitor by calling one of the
     * {@code wait} methods.
     * <p>
     * The awakened threads will not be able to proceed until the current
     * thread relinquishes the lock on this object. The awakened threads
     * will compete in the usual manner with any other threads that might
     * be actively competing to synchronize on this object; for example,
     * the awakened threads enjoy no reliable privilege or disadvantage in
     * being the next thread to lock this object.
     * <p>
     * This method should only be called by a thread that is the owner
     * of this object's monitor. See the {@code notify} method for a
     * description of the ways in which a thread can become the owner of
     * a monitor.
     *
     * @throws  IllegalMonitorStateException  if the current thread is not
     *               the owner of this object's monitor.
     * @see        java.lang.Object#notify()
     * @see        java.lang.Object#wait()
     */
    @HotSpotIntrinsicCandidate
    public final native void notifyAll();

    /**
     * Causes the current thread to wait until it is awakened, typically
     * by being <em>notified</em> or <em>interrupted</em>.
     * <p>
     * In all respects, this method behaves as if {@code wait(0L, 0)}
     * had been called. See the specification of the {@link #wait(long, int)} method
     * for details.
     *
     * @throws IllegalMonitorStateException if the current thread is not
     *         the owner of the object's monitor
     * @throws InterruptedException if any thread interrupted the current thread before or
     *         while the current thread was waiting. The <em>interrupted status</em> of the
     *         current thread is cleared when this exception is thrown.
     * @see    #notify()
     * @see    #notifyAll()
     * @see    #wait(long)
     * @see    #wait(long, int)
     */
    public final void wait() throws InterruptedException {
        wait(0L);
    }

    /**
     * Causes the current thread to wait until it is awakened, typically
     * by being <em>notified</em> or <em>interrupted</em>, or until a
     * certain amount of real time has elapsed.
     * <p>
     * In all respects, this method behaves as if {@code wait(timeoutMillis, 0)}
     * had been called. See the specification of the {@link #wait(long, int)} method
     * for details.
     *
     * @param  timeoutMillis the maximum time to wait, in milliseconds
     * @throws IllegalArgumentException if {@code timeoutMillis} is negative
     * @throws IllegalMonitorStateException if the current thread is not
     *         the owner of the object's monitor
     * @throws InterruptedException if any thread interrupted the current thread before or
     *         while the current thread was waiting. The <em>interrupted status</em> of the
     *         current thread is cleared when this exception is thrown.
     * @see    #notify()
     * @see    #notifyAll()
     * @see    #wait()
     * @see    #wait(long, int)
     */
    public final native void wait(long timeoutMillis) throws InterruptedException;
```

# 교착 상태 (Deadlock)

> 프로세스가 다른 프로세스의 사용 자원을 무한정 대기하고 있는 상태
>

## 데드락 발생 조건

### 1. 상호 배제 (Mutual Exclusion)

- 하나의 리소스는 하나의 프로세스만 사용 가능해야 함

### 2. 점유 대기 (Hold and Wait)

- 최소 하나의 리소스를 사용하고 있으면서(Hold)
- 다른 프로세스가 사용하는 리소스를 대기하고 있는(Wait) 프로세스가 있어야 함

### 3. 비선점 (No Preemption)

- 다른 프로세스가 사용중인 리소스를 강제로 뺏을 수 없어야 함

### 4. 순환 대기 (Circular wait)

- 대기하고 있는 프로세스의 형태가 순환 형태(Circular)를 이루고 있어야 함

  ex) A → B → C → A


## 데드락 해결 방법

### 1. 예방

- 데드락 발생 조건 4가지 중 1개 이상을 막아서 데드락 자체가 발생하지 않도록 예방하는 것
    - 실효성이 떨어져 잘 사용하지 않는 방법

### 2. 회피

- 쓰레드에 리소스 할당 시 프로세스가 안정 상태를 유지할 경우에만 리소스를 할당해 데드락을 회피하는 방법

### 3. 탐지 & 회복

- 탐지
    - 데드락 발생 여부를 탐지함
- 회복
    - 데드락이 탐지된 경우 순환 대기를 벗어나 데드락을 해결함
        1. 프로세스 중단
            - 모든 프로세스 중단 → 부분적인 결과가 손실될 위험이 있음
            - 하나씩 중단 → 데드락이 해결될 때까지 하나씩 프로세스를 중단함
        2. 리소스 선점
            - 데드락이 해결될 때까지 다른 프로세스가 점유하고 있는 리소스를 강제로 뺏어옴

# Reference

[10주차 과제: 멀티쓰레드 프로그래밍](https://sujl95.tistory.com/63)

쓰레드 상태

[10주차 과제: 멀티쓰레드 프로그래밍](https://sujl95.tistory.com/63)

[[운영체제] 데드락(Deadlock, 교착 상태)이란?](https://chanhuiseok.github.io/posts/cs-2/)

데드락

[모니터란 무엇인가?](https://happy-coding-day.tistory.com/8)

java monitor
