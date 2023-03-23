# 9주차 : 예외 처리

# 예외 처리

> 프로그램 실행 시 발생할 수 있는 예외에 대비한 코드를 작성하는 것
>
- 프로그램의 비정상적인 종료를 막고 프로그램 흐름을 유지하기 위해 사용함
- 발생한 예외를 적절히 처리하지 못하고 main 메소드가 예외를 던지면, 해당 쓰레드는 종료됨

## 예외 처리 방법

### 1. 메소드 내부에서 try-catch로 처리

- try
    - 예외가 발생할 수 있는 코드를 작성
    - 예외 발생 시 뒤에 있는 코드들은 더 이상 실행되지 않고 catch로 흐름이 넘어감
- catch
    - 해당하는 예외가 try문에서 발생하면 실행되는 블록
        - 해당 예외의 자식 예외들도 모두 받을 수 있음
    - 여러 개의 catch문을 작성할 수 있음
        - 계층 구조로 예외가 잡힘
            - 부모가 먼저 잡히면 뒤에 자식 예외는 안잡힘
            1. Exception은 모든 예외의 부모 클래스
                - 만약 다른 예외 클래스보다 먼저 catch 한다면 뒤에 오는 자식 클래스가 예외를 잡을 수 없음 (쓰나마나)
            2. 만약 try문에서 발생한 예외를 catch 할 수 있는 클래스가 없는 경우
                - 컴파일 에러가 발생함
        - catch문은 try문에서 어떤 예외가 발생하느냐에 따라 결정됨
            - 일반적으로 Exception을 던지는 경우는 별로 없기 때문에 catch(Exception)할 일은 많지 않음

        ```java
        public class CatchExceptionLater {
        
            public static void main(String[] args) {
                CatchExceptionLater obj = new CatchExceptionLater();
                obj.catchException();
            }
        
            void catchException() {
                int[] Array = new int[3];
                try {
                    Array = null;                                 //null 예외 발생
                    Array[5] = 1;
                } catch (NullPointerException e) {
                    System.out.println("널 예외 발생");              //NullPointerException 예외 캐치함
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("인덱스 범위 벗어난 예외 발생");  //실행x
                } catch (Exception e) {
                    System.out.println("나머지 예외사항 발생");        //실행x
                }
                System.out.println("무조건 실행되는 문장");
            }
        }
        
        ```

    - catch문의 exception
        - try문에서 어떤 예외가 발생하느냐에 따라 결정됨
        - 일반적으로 Exception을 던지는 경우는 별로 없기 때문에 catch(Exception)할 일은 많지 않음
    - catch에서 사용하는 변수
        - 반드시 try 블록 앞에서 선언되어야 함
        - try 블록 내에서 선언된 변수는 catch 블록에서 사용하지 못함
        - 만약 try 블록 밖에서 선언된 변수가, try 블록 내에서 변경되는 경우

            ```java
            void printMonth(int number) {
                int a = 0;
            
                try {
                    a = 10;
            
                    if (number > 12) {
                        throw new Exception("1월에서 12월만 있음");
                    }
            
                    System.out.println(number + "월달 입니다.");
                } catch (Exception e) {
                    System.out.println(a);  // 10 출력
            
                    e.printStackTrace();
                }
            }
            
            ```

          → catch 블록에서도 변경된 값을 사용함

            - try 블록에서 사용되었다고 해서 catch 블록에 전혀 영향을 줄 수 없다는게 아님!!

### 2. 예외 떠넘기기 (throws)

- 메소드 선언 시
    - throws를 사용해 예외를 던지는 메소드임을 명시해야 함

    ```java
    public class MonthClass {
    
        void printMonth(int number) throws IllArgumentException {
            if (number > 12) {
                throw new IllArgumentException("1월에서 12월만 있음");
            }
    
            System.out.println(number + "월달 입니다.");
        }
    }
    
    ```

    - 예외 발생 시 printMonth()를 호출한 곳에서 예외를 처리해야함
        - try-catch로 잡거나
        - 또 throws를 쓰거나 → 좋은 습관이 아님

### 예외를 try-catch로 처리하지 않고 `떠넘기는 경우`

1. 해당 메소드를 사용했을 때 발생할 수 있는 **예외를 명시**하기 위해
2. 예외를 발생시키는 **메소드를 간결하게 작성**하기 위해
3. 현재 메소드 내에서 굳이 예외를 처리할 필요가 없을 때 경우

   = **해당 메소드를 사용하는 곳에서 처리하는게 더 좋은 경우**


> 처리하기 귀찮다고 떠넘기면 안된다!
>

### 3. finally

- 예외 발생 여부와 상관없이 **항상 실행되는 블록**
    - 예외 발생으로 쓰레드 종료 시 할당된 자원을 해제 해야함

      → 예외가 발생해도 실행되어야 할 코드가 있을 때 사용


    ```java
    void printMonth(int number) {
        try {
            if (number > 12) {
                throw new Exception("1월에서 12월만 있음");
            }
    
            System.out.println(number + "월달 입니다.");
        } catch (Exception e) {
            e.printStackTrace();
    				return;
        } finally {
            System.out.println("2022년");
        }
    }
    ```

- try-catch 블록 밖에 작성한 코드

    ```java
    void printMonth(int number) {
        try {
            if (number > 12) {
                throw new Exception("1월에서 12월만 있음");
            }
    
            System.out.println(number + "월달 입니다.");
        } catch (Exception e) {
            e.printStackTrace();
    				return;
        }
        
        System.out.println("2022년");
    }
    ```

    - catch 블록 실행 후 실행됨
- `finally 블록` vs `try-catch 블록 밖에 작성한 코드`
    - catch 블록 내부에 return으로 메소드를 끝내는 경우
        - finally 블록 → 실행 O
        - try-catch 블록 밖에 작성한 코드 → 실행 X
            - 메소드가 끝났으므로
- finally 블록에 return문이 있는 경우 → `Anti Pattern`
    - try문에서 예외가 발생하지 않아도 return문이 실행되지 않고 finally문의 return문이 실행됨

    ```java
    public class AntiPattern {
    
        int returnInFinally(boolean flag) {
            try {
                System.out.println("try");
    
                if (flag) {
                    throw new RuntimeException();
                }
    
                return 1;
            } catch (RuntimeException e) {
                System.out.println("catch");
                return 2;
            } finally {
                System.out.println("finally");
                return 3;
            }
        }
    
        public static void main(String[] args) {
            AntiPattern anti = new AntiPattern();
            System.out.println(anti.returnInFinally(false));    // 예외가 발생하지 않았는데도 return 3
        }
    }
    ```


# 자바가 제공하는 예외 계층

![Untitled](https://user-images.githubusercontent.com/87421893/172390626-6289b2f2-61af-41ce-a08a-0872804a0581.png)

출처 : 자바의 신 1권

## Throwable

- Error, Exception 클래스의 부모 클래스
- 다양한 메소드가 있고 Exception 클래스에서 여러 메소드를 오버라이딩 했음

## Error

> `프로그램 밖`에서 발생하는 예외
>
- **프로세스 자체를 멈춤**

  ex) 서버 디스크 고장, 메인보드 고장 등

- Throwable 클래스의 메소드를 하나도 오버라이딩 하지 않았음
- StackOverflowError, OutOfMemoryError …

## Exception

> `프로그램 안`에서 발생하는 예외
>
- (예외처리를 하지 않으면) 예외가 발생한 **쓰레드를 멈춤**
- CheckedException & UncheckedException으로 나뉨
- 오버라이딩한 메소드 - 자주 쓰는 것 3가지
    - 공통적으로 예외 메세지를 사용자에게 보여주기 위해 사용
    1. `getMessage()` - 간단히 // String 반환
    2. `toString()` - 자세히  // String 반환
    3. `printStackTrace()` - 더 자세히 // 예외 스택정보 출력

    ```java
    public class ExceptionOverridingMethod {
    
        public static void main(String[] args) {
            ExceptionOverridingMethod obj = new ExceptionOverridingMethod();
            obj.OverridingMethod3();
        }
    
        void OverridingMethod3(){
            int[] Array = new int[5];
            try{
                Array[6] = 1;
            } catch (Throwable e){      //exception 캐치함
                System.out.println("---------getMessage/간단히---------");
                System.out.println(e.getMessage()); //String 반환
                System.out.println("---------toString/자세히---------");
                System.out.println(e.toString());   //String 반환
                System.out.println("---------printStackTrace/더 자세히 에러 내용 출력---------");
                e.printStackTrace();                //예외 스택정보 출력
            }
        }
    }
    ```

  > <결과>
  --------getMessage/간단히---------
  Index 6 out of bounds for length 5
  ---------toString/자세히---------
  java.lang.ArrayIndexOutOfBoundsException: Index 6 out of bounds for length 5
  ---------printStackTrace/더 자세히 에러 내용 출력---------
  java.lang.ArrayIndexOutOfBoundsException: Index 6 out of bounds for length 5
  at chapter14.ExceptionOverridingMethod.OverridingMethod3(ExceptionOverridingMethod.java:14)
  at chapter14.ExceptionOverridingMethod.main(ExceptionOverridingMethod.java:8)
>

# CheckedException vs UncheckedException

## UncheckedException

- RuntimeException을 상속받은 예외
- 프로그래머의 실수에 의해 발생할 수 있는 예외
    - 클라이언트가 해결할 수 없는 예외
    - 복구가 어려운 예외
- 컴파일 시 예외를 체크하지 않고 런타임 시 체크함

  **→ 컴파일 에러를 발생시키지 않음**


## CheckedException

- UncheckedException을 제외한 나머지 예외
- 프로그램을 사용하는 사용자에 의해 발생할 수 있는 예외
    - 부가적인 작업으로 복구가 가능한 예외
- 컴파일 시 예외 체크를 함

  **→ 컴파일 에러를 발생시킬 수 있음**

- CheckedException을 발생시킬 수 있는 메소드
    - 반드시 예외 처리를 해줘야 함
        - try-catch로 처리하던가
        - throws로 던지던가

# 커스텀 예외를 만드는 방법

> JDK가 제공하는 예외가 있으면 기존것을 사용하는게 좋다. 정말 없어서 만들어야 할 경우에만 만들 것
>
- CheckedException을 만들고 싶은 경우
    - Exception을 상속
- UncheckedException을 만들고 싶은 경우
    - RuntimeException을 상속
- 기존 예외를 커스텀 예외로 바꿔서 전달 할 때
    - 커스텀 예외가 발생하게 된 cause를 같이 넘겨받아서 사용하기

    ```java
    public class MyException extends RuntimeException{
    
        public MyException(String message, Throwable cause) {
            super(message, cause);
        }
    }
    ```

    ```java
    public class ChangeException {
    
        public static void main(String[] args) {
            ChangeException ce = new ChangeException();
    
            try {
                ce.changeByMyException();
            } catch (MyException e) {
                System.out.println("내가 만든 예외로 던져짐");
                System.out.println("원인인 " + e.getCause());
            }
    
        }
    
        void throwIllegalArgumentException() {
            throw new IllegalArgumentException();
        }
    
        void changeByMyException() {
            try {
                throwIllegalArgumentException();
            } catch (IllegalArgumentException e) {
                throw new MyException("내가 만든 예외로 바꿔서 던지기", e);
            }
        }
    }
    ```


# JDK가 제공하는 기본 예외

## UncheckedException

- NullPointerException
    - 사용하려는 객체가 null인 경우 발생

    ```java
    String nullString = null;
    nullString.toString();
    ```

  <img width="662" alt="스크린샷_2022-06-06_오후_9 57 20" src="https://user-images.githubusercontent.com/87421893/172390744-b4c82f5f-32ec-4a6c-9b7c-f2cf94564dc6.png">

- ArrayIndexOutOfBoundsException
    - 배열의 인덱스를 잘못 접근했을 때 발생

    ```java
    int[] arr = new int[3];
    arr[4] = 1;
    ```

  <img width="1080" alt="스크린샷_2022-06-06_오후_9 56 59" src="https://user-images.githubusercontent.com/87421893/172390772-5d69d3ab-9f45-4177-9902-748aec61bec8.png">

- StringIndexOutOfBoundsException
    - string의 인덱스를 잘못 접근했을 때 발생

    ```java
    String a = "0123";
    a.charAt(4);
    ```

  <img width="1030" alt="스크린샷_2022-06-06_오후_9 58 47" src="https://user-images.githubusercontent.com/87421893/172390798-34184d6e-2844-4c28-9d47-6aeaaa934c44.png">

- ArithmeticException
    - 산술 연산 시 **잘못된 연산 조건**을 사용할 시 발생
        1. overflow
            - Math 클래스 메소드 사용 시 발생

            ```java
            int a = 2_100_000_000;  //21억
            int b = 2_100_000_000;  //21억
            Math.addExact(a, b);
            ```

           <img width="813" alt="스크린샷_2022-06-06_오후_10 08 29" src="https://user-images.githubusercontent.com/87421893/172390848-fc7a546a-42fe-4b3c-8663-41c2533fcd60.png">


        2. divide by zero

            ```java
            int a = 10;
            int b = 0;
            int c = a / b;
            ```

          <img width="751" alt="스크린샷_2022-06-06_오후_10 09 14" src="https://user-images.githubusercontent.com/87421893/172391035-63373c2c-3e2b-4e54-b985-7d378533e912.png">

- ClassCastException
    - 부모 클래스에서 자식 클래스로 다운 캐스팅 시
        - 해당 인스턴스가 캐스팅 될 수 없는 자식 타입으로 캐스팅 될 때 발생

    ```java
    class Parent {
    }
    
    class Child1 extends Parent {
    }
    
    class Child2 extends Parent {
    }
    
    public static void main(String args[]) {
    	Parent child = new Child1();
    	Child2 child2 = (Child2) child;  // 에러 발생
    }
    ```

  ![스크린샷_2022-06-07_오전_12 01 29](https://user-images.githubusercontent.com/87421893/172391068-8ab398a5-90e7-424c-8f50-ea3e8b7254d5.png)

- IllegalArgumentException
    - 메소드의 매개변수로 잘못된 값을 입력할 때 발생

    ```java
    ArrayList<Integer> numbers = new ArrayList<>(-1);
    ```

  ![스크린샷_2022-06-07_오전_12 12 22](https://user-images.githubusercontent.com/87421893/172391092-fb42c0fa-7fc6-43b7-9573-46d55db560da.png)

- IllegalStatementException
    - 메소드의 호출 시점이 잘못된 경우 발생
        - 적절한 예시를 찾지 못해 스프링에서 발생 예시를 찾음

    ```java
    @GetMapping("/add")
    public void method1() {}
    
    @GetMapping("/add")
    public void method2() {}
    ```

  ![스크린샷_2022-06-07_오전_12 22 16](https://user-images.githubusercontent.com/87421893/172391112-c38316d8-2620-4925-a4e0-3400bf02a119.png)


## CheckedException

- ClassNotFoundException
- IOException
- SQLException

# Multicatch Block

> 여러 개의 catch 블락을 하나로 합칠 수 있는 기능
>
- 서로 다른 예외지만 처리하는 내용이 같은 경우 (catch 블락 내용이 같은 경우) 사용
- java 7 이후로 제공하는 기능

    ```java
    public class MultiCatchBlock {
    
        void originBlock(int flag) {
            try {
                if (flag == 1) {
                    throw new IllegalArgumentException();
                }
    
                if (flag == 2) {
                    throw new ArithmeticException();
                }
    
                if (flag == 3) {
                    throw new NullPointerException();
                }
            } catch (IllegalArgumentException e) {
                System.out.println("예외 발생");
            } catch (ArithmeticException e) {
                System.out.println("예외 발생");
            } catch (NullPointerException e) {
                System.out.println("예외 발생");
            }
        }
    
        void useMultiCatch(int flag) {
            try {
                if (flag == 1) {
                    throw new IllegalArgumentException();
                }
    
                if (flag == 2) {
                    throw new ArithmeticException();
                }
    
                if (flag == 3) {
                    throw new NullPointerException();
                }
            } catch (IllegalArgumentException | ArithmeticException | NullPointerException e) {
                System.out.println("예외 발생");
            }
        }
    }
    ```

- 만약 multicatch로 묶을 때 상속 관계가 있으면?
    - 컴파일 에러 발생
        - 어차피 부모로 잡으면 자식 예외는 처리되지 않으므로 의미 없는 코드가 됨

          ex) NullPointerException → RuntimeException

          <img width="933" alt="스크린샷_2022-06-06_오후_8 43 11" src="https://user-images.githubusercontent.com/87421893/172391137-71823a8d-6c04-4cc8-8ebc-b4738b21861b.png">


# ⭐ try-with-resource

> 예외 처리 시 자원 해제를 자동으로 처리해주는 기능
>
- finally로 리소스를 직접 close하지 않아도 자동으로 close해주는 기능
    - finally 블록을 많이 줄일 수 있음
- closeable 인터페이스를 구현한 클래스만 가능
- java 7 이후로 제공하는 기능
    - 자원 할당을 해제해야하는 경우 반드시 사용하자!

```java
public class TryWithResource {

    void originMethod() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
        try {
            System.out.println("hi");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("반드시 실행되어야 하므로 finally에 작성");
            bw.close();
            br.close();
        }
    }

    void useTryWithResource() {
        try ( -> 소괄호
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
        ) { -> 중괄호
            System.out.println("hi");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

# Chained Exception

> 하나의 예외가 다른 예외를 발생시키는 경우
>
- 예외가 발생했을 때 바로 처리하지 않고 다른 예외를 발생시키는 이유는?
    1. 하나의 큰 분류의 예외를 두고 세부적인 예외로 처리하기 위해

        ```java
        public class LoseMoneyException extends RuntimeException {
            private String message = "돈을 잃어버려서 집을 못감";
        
            @Override
            public String getMessage() {
                return message;
            }
        }
        ```

        ```java
        public class ShutDownBusException extends RuntimeException{
            private String message = "버스가 끊겨서 집을 못감";
        
            @Override
            public String getMessage() {
                return message;
            }
        }
        ```

        ```java
        public class ChainedException {
        
            public static void main(String[] args) {
                ChainedException ce = new ChainedException();
                Scanner sc = new Scanner(System.in);
                int cause = sc.nextInt();
        
                try {
                    ce.goHome(cause);
                } catch (CantGoHomeException e) {
                    System.out.println(e.getCause().getMessage());
                }
            }
        
            void goHome(int flag) throws CantGoHomeException {
                try {
                    if (flag == 1) {
                        throw new LoseMoneyException();
                    }
        
                    if (flag == 2) {
                        throw new ShutDownBusException();
                    }
        
                    System.out.println("집에 잘 감");
                } catch (LoseMoneyException e) {
                    // 원인을 저장
                    throw new CantGoHomeException(e);
                } catch (ShutDownBusException e) {
                    throw new CantGoHomeException(e);
                }
            }
        }
        ```

    2. CheckedException → UncheckedException 변환
        - CheckedException인데 당장 처리할 수 없는 경우
            - RuntimeException으로 감싸서 UncheckedException으로 처리

        ```java
        if (flag == 3) {
            throw new RuntimeException(new Exception());
        }
        ```


# 예외 처리 비용

> 예외 처리로 비지니스 로직을 처리하지 마라!
>
- 예외는 stack trace를 메모리에 저장하기 때문에 처리 비용이 비쌈
    - Throwable의 fillInStackTrace()가 원인이라고 함

  → 입력값을 조절하거나 if문을 사용하는 등 로직으로 처리할 수 있으면 하는게 좋음


# Reference

[[Java Study 9주차] 예외 처리](https://wisdom-and-record.tistory.com/46)

multicatch block, try-with-resource, Chained Exception

[예외 처리](https://www.notion.so/3565a9689f714638af34125cbb8abbe8)

커스텀 예외 생성 시 주의 사항

[(9주차) 예외처리](https://www.notion.so/9-17a778bba6ed4436ac3d7b9415b6babb)

예외 처리 전략

[백기선님 온라인 스터디 9주차 - 예외 처리](https://velog.io/@dion/백기선님-온라인-스터디-9주차-예외-처리)

오라클 공식 문서 참고
