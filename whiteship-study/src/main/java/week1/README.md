# 1주차 : JVM은 무엇이며 자바 코드는 어떻게 실행하는 것인가?

# JAVA 프로그램

## 1.컴파일 방법

- `IDE` 사용
    - IDE의 문법 검사 그 자체가 컴파일이라고 볼 수 있음
    - 잘못된 코드 작성 -> 컴파일 에러
- 커맨드에서 `javac` 명령어 사용
    1. 커맨드 창에서 .java 파일이 있는 디렉터리로 이동
    2. javac (.java 파일명)
    - 결과로 .class 파일 (바이트코드) 만들어짐
- 커맨드에서 컴파일 할 시 다양한 [컴파일 옵션](https://dev.java/learn/javac---the-compiler/)을 사용할 수 있음

### 바이트코드

> 고급 언어(자바, 코틀린 등)와 기계어의 중간 언어
> 
- 1 byte 크기의 명령어 -> 최대 255개의 명령어를 쓸 수 있음
- JVM만 있으면 OS에 상관없이 실행할 수 있음 -> OS 독립적
- 어떤 프로그래밍 언어로 작성하든 바이트코드로 컴파일만 할 수 있으면 JVM을 통해 실행 할 수 있음
    - WORA (Write Once Run Anywhere)
    : 한번 작성해서 바이트코드로 컴파일하여 배포하면 어디서든지 실행할 수 있다.

## 2.실행 방법

- `IDE` 사용 - 빌드, 컴파일, 실행 한번에 할 수 있음
- 커맨드에서 `java` 명령어 사용
    1. 커맨드에서 .class 파일이 있는 디렉터리로 이동
    2. java (.class 파일명) -> 자바 프로그램 실행

## 1.JVM이란?

> 바이트코드를 (플랫폼에 맞는 기계어로) 컴파일하여 실행시켜주는 가상 머신
> 
- JVM은 플랫폼에 의존적임
    - 플랫폼 : OS + CPU 아키텍처

## 2.JVM 구성 요소

![https://images.velog.io/images/jjb8966/post/d655da64-fffb-4e90-896d-e8cbd92f5eaa/image.png](https://images.velog.io/images/jjb8966/post/d655da64-fffb-4e90-896d-e8cbd92f5eaa/image.png)

### Class Loader System `보충 필요`

> 런타임 시 바이트코드(.class) 파일을 JVM 내 Runtime Data Areas(memory)에 배치하는 시스템
> 
- 작동 과정
    1. 로딩
        - 클래스 파일을 JVM 메모리에 로드
    2. 링크
        1. Verify
            - 클래스 파일이 자바 및 JVM 명세에 명시된 대로 작성되었는지 검증
        2. Prepare
            - .class 파일의 static 키워드가 붙은 멤버들에 메모리만 할당하고 기본값으로 세팅
                - 정확한 값을 넣기 전
        3. Resolve
            - symbolic reference들을 메소드 영역에서 실제 주소값을 찾고 그 주소값으로 참조 객체들을 세팅함
    3. 초기화
        - static 변수를 초기화
        - static block 실행
- 계층 구조
    1. BootStrap class loader
        - 핵심 자바 API를 로드 (ex. Object Class)
        - `native code`로 구성
            - native code : CPU나 OS가 직접 실행할 수 있는 코드
    2. Extension class loader
        - 기본 API를 제외한 확장 클래스들을 로드함
    3. System class loader
        - 애플리케이션의 클래스들을 로드함

### Runtime Data Areas (Memory) `보충 필요`

> 자바 프로그램을 실행하기 위해 OS로부터 할당받은 메모리 공간
> 
- 구성
    1. Stack
        - 메소드가 호출될 때 마다 스택 프레임이 할당되는 공간
        - 쓰레드마다 1개씩 가지고 있음
        - 메소드 실행이 완료되면 할당 해제
    2. Heap
        - 모든 쓰레드가 공유하는 메모리 영역
        - 객체를 저장하는 공간
        - 메소드 영역에 로드된 클래스만 생성 가능함
        - 더 이상 참조되지 않는 객체는 GC가 제거
        - Heap 영역은 1개만 존재
    3. Method (Class)
        - 모든 쓰레드가 공유하는 메모리 영역
            
            ![스크린샷_2022-05-10_오전_8 43 20](https://user-images.githubusercontent.com/87421893/170994401-c8343558-24ae-4279-9b8c-506f06ef50a4.png)

            
            1. Field Information
                - 클래스 멤버 변수의 이름, 데이터타입, 접근 제어자에 대한 정보를 저장
            2. Method Information
                - 클래스 메소드의 이름, 리턴타입, 매개변수, 접근 제어자에 대한 정보를 저장
            3. Type Information
                - class인지 interface인지 여부, 패키지명, super class에 대한 정보를 저장
            4. Constant Pool
                - 클래스에서 사용된 상수를 저장 (public static final)
                - symbolic reference 객체도 여기에 저장
            5. Static Variable
                - static 변수들에 대한 정보를 저장
    4. PC registers
        - 쓰레드가 시작될 때 생성되는 공간
        - 쓰레드마다 1개씩 가지고 있음
        - 쓰레드가 어느 부분을 어떤 명령어로 실행해야 하는지 기록하는 공간
    5. Native Method Stack
        - 자바 외의 언어로 작성된 네이티브 코드를 위한 공간

### Execution Engine

> 바이트코드를 명령어 단위로 읽어서 실행하는 기능
> 
- `인터프리터`
    - 바이트코드를 한 줄 씩 번역하고 실행
    - 작은 크기의 코드는 빠르게 실행할 수 있으나 코드가 커질수록 느려짐
    - 컴파일된 바이트코드를 실행하는게 인터프리터로 한 줄 씩 실행하는것 보다 빠름
- `JIT 컴파일러`
    - 인터프리터의 단점을 보완하기 위해 사용
- `Garbage Collector(GC)`
    - Heap 메모리에서 더 이상 참조되지 않는 객체를 정리함
    - 자동으로 메모리를 관리해주는 도구

### Java Native Method Interface(JNI)

> C, C++, 어셈블리어로 작성된 Native 키워드를 사용하는 메소드를 사용할 수 있도록 해주는 인터페이스
> 

## 3.JIT(Just In Time) 컴파일러

> 런타임 시 반복적으로 사용되는 코드(바이트코드)를 컴파일 해주는 것
> 
- `반복적인 코드`를 미리 컴파일하여 `캐싱`함으로써 실행 속도를 향상시킴
- 인터프리터의 한 줄씩 읽어서 실행하는 느린 속도를 보완

![출처: <https://aboullaite.me/understanding-jit-compiler-just-in-time-compiler/>](https://images.velog.io/images/jjb8966/post/48387cde-1bd1-4715-b6c1-86e09b777269/image.png)

출처: <https://aboullaite.me/understanding-jit-compiler-just-in-time-compiler/>

# JRE vs JDK

## JRE

> JVM + 자바 라이브러리
> 

## JDK

> JRE + 개발 도구
> 

→ Java 9부터 2개의 구분없이 JDK만 배포 (JRE를 포함하고 있기 때문)

[JVM 메모리 구조란? (JAVA)](https://steady-coding.tistory.com/305)

[JVM( Java Virtual Machine )이란](https://honbabzone.com/java/java-jvm/)

[JVM 구조](https://velog.io/@litien/JVM-%EA%B5%AC%EC%A1%B0)

클래스 로더 동작 과정

[[Java-4] JVM의 구조](https://catch-me-java.tistory.com/12)

[[Java-3] JVM과 JIT 컴파일러란?](https://catch-me-java.tistory.com/11)
