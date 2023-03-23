# 5주차 : 클래스

## 1. 객체 지향 프로그래밍 `보충 필요`

## 2. 클래스

### 1. 클래스 구조

1. 필드
    1. 인스턴스 변수
        
        > 메소드 밖, 클래스 안에 정의된 변수
        > 
        - 스코프 : `static 메소드를 제외`한 나머지 클래스 내부
        - 라이프타임 : 객체가 생성되고부터 GC에 의해 소멸될 때 까지
    2. 클래스 변수
        
        > 인스턴스 변수에 static이 붙은 변수
        > 
        - 스코프 : 클래스 내부
        - 라이프타임 : 클래스가 로드된 후 부터 프로그램이 종료될 때 까지
    3. 매개 변수
        
        > 메소드에 넘겨주는 변수
        > 
        - 스코프 : 호출한 메소드 내부
        - 라이프 타임 : 메소드가 호출될 때 부터 메소드가 끝날 때 까지
    4. 지역 변수
        
        > 중괄호 내에 선언된 변수
        > 
        - 스코프 : 선언된 중괄호 내부
        - 라이프 타임 : 중괄호가 닫힐 때 까지
        - 기본 자료형을 지역 변수로 사용할 경우 반드시 `초기화`를 해줘야 함
2. 메소드
    1. 클래스 메소드
        - static 메소드
        - 보통 **클래스 이름.메소드** 방식으로 사용
            - 인스턴스.메소드로 사용할 수도 있으나 이렇게 사용하면 클래스에 종속된 메소드를 인스턴스가 사용하는 꼴이기 때문에 경고 문장이 뜸
    2. 인스턴스 메소드
        - static이 없는 메소드
        - 인스턴스를 생성하고 인스턴스를 통해 접근해야 함
3. 생성자

### 2. modifier

- `접근 제어자`
    - 종류 4가지
        1. public → `누구나` 접근 가능
        2. protected → `같은 패키지`or `상속받은 경우` 접근 가능
        3. package-private (default) → `같은 패키지 내` 접근 가능
        4. private → `해당 클래스 내` 접근 가능
    - 클래스, 메소드, 인스턴스 변수, 클래스 변수 선언 시 사용
    - 하나의 자바(.java) 파일에는 최대 하나의 public class만 존재할 수 있고 그 이름이 같아야 함.
        - 존재하지 않을 수 도 있음
- `그 외`
    - static
    - final
    - abstract
    - transient
        - 변수 또는 메소드가 포함된 객체를 직렬화 할 때 해당 내용을 무시함
    - synchronized
        - Thread Safe를 위해 사용
        - 하나의 쓰레드만 접근 가능하도록 함
    - volatile
        - 변수 앞에 사용
        - 해당 변수는 CPU 캐시가 아니라 항상 메인 메모리로부터 읽힘

### 3. 필드 초기화

1. 변수 선언과 동시에 초기화
2. 생성자를 통한 초기화
3. static 블록을 통한 초기화
    - 클래스 변수를 초기화하는데 사용
    - private static 메소드를 사용해도 됨
4. 인스턴스 블록을 통한 초기화
    - 어떤 생성자를 호출하던 공통으로 초기화시키고 싶은 작업이 있을 시 사용
- static 블록, 인스턴스 블록을 사용하는 이유
    - 오버로딩된 생성자가 여러 개 있는 경우
        - 모든 생성자에서 공통으로 처리해야하는 작업이 있으면 코드를 줄일 수 있고 유지보수 하기가 쉬워짐

### 4. Nested Class

> 클래스 안에 클래스가 들어가 있는 것
> 
- 코드를 `간단하게 표현`하기 위해 사용
- UI 처리 시 `사용자의 입력`이나 `외부 이벤트에 대한 처리`를 하는 곳에 사용
- 별도로 컴파일 할 필요 없이 감싸고 있는 클래스가 컴파일 될 때 자동으로 컴파일됨
    - 내부 클래스가 1개라면 컴파일 시 2개의 .class 파일 생성됨
- 종류
    1. Static nested class
    2. Inner class
        1. (local) Inner class - 내부 클래스
            - Local Class - 특정 메소드 내부에 선언
        2. Anonymous inner class - 익명 클래스
- 사용 목적
    1. 한 곳에서만 사용되는 클래스를 묶어서 처리하기 위해 (static nested class)
    2. 캡슐화하기 위해 (inner class)
        - A 클래스의 private 변수를 B 클래스가 접근하고 싶은 경우
            
            → B를 inner class로 생성
            
    3. 가독성과 유지보수성을 높이기 위해
- Static nested class
    - 감싸고 있는 클래스의 static 변수만 접근 가능함
    - 객체 생성
        - `외부클래스.static내부클래스`
        
        ```java
        OuterOfStatic.StaticNested staticObject = new OuterOfStatic.StaticNested();
        ```
        
    - 사용 목적
        - 클래스를 묶어두기 위해
        - 겉으로 보기에는 유사하지만 내부적인 구현이 달라야 할 경우 사용
            
            ```java
            public class University {
            	static class Student{
            	}
            }
            ```
            
            ```java
            public class School {
            	static class Student{
            	}
            }
            ```
            
            - University.Student ≠ School.Student
                - Student의 내부 구현을 다르게 할 수 있음
                - University에서 School의 Student를 접근할 수 없음
- 내부 클래스 (Inner class) & 익명 클래스 (Anonymous inner class)
    
    > 다른 클래스에서 재사용할 일이 없을 때에만 사용
    > 
    
    ### 내부 클래스
    
    - 객체 생성
        
        ```java
        OuterOfInner outer = new OuterOfInner();      // 외부 클래스 객체 먼저 생성
        OuterOfInner.Inner inner = outer.new Inner(); // 외부 클래스 객체를 사용해 생성자 호출
        ```
        
    - 사용 목적
        - 캡슐화하기 위해
            - 하나의 클래스에서 공통적인 작업을 수행하는 클래스가 필요한데 외부에서는 그 클래스가 필요없을 경우
                
                ex) GUI Listener 처리
                
                - 어떤 버튼을 눌렀을 때 해야하는 작업을 정의할 때 내부 클래스로 만들어 사용
    
    ### 익명 클래스
    
    - `매개변수로 인터페이스를 받는 경우` **인터페이스를 구현한 클래스를 따로 만들지 않고** **익명의 클래스를 만들어 메소드를 구현**하는 것
    
    ```java
    interface A {
        void methodA();
    }
    
    public class Main {
    
        static void methodB(A a) {  // 매개변수로 인터페이스를 받는 메소드
            a.methodA();            // 인터페이스의 메소드를 사용
        }
    
        public static void main(String[] args) {
            methodB(new A() {       // 매개변수로 인터페이스를 구현한 익명클래스를 받음
                @Override
                public void methodA() {
                    System.out.println("hi");
                }
            });                     // ; 붙여줘야 함
        }
    }
    ```
    
    ```java
    public static void main(String[] args) {
        OneMethodInterface implObject = new ImplClass();
    
        OneMethodInterface implObject2 = new ImplClass2();
    
        OneMethodInterface implObject3 = new OneMethodInterface() {
            @Override
            public void hi() {
                System.out.println("hihihi");
            }
        };
    
        OneMethodInterface implObject4 = () -> System.out.println("hihihihi");
    
        implObject.hi();   // hi
        implObject2.hi();  // hihi
        implObject3.hi();  // hihihi
        implObject4.hi();  // hihihihi
    	
    }
    ```
    
    - 클래스의 이름도 객체의 이름도 없기 때문에 **외부에서 클래스나 메소드를 참조할 수 없음**
    - 인터페이스를 구현한 클래스를 만들어서 매개변수로 받는 것 보다 `메모리` 사용도 줄이고 `시간`도 줄일 수 있기 때문에 사용
- Nested class 특징
    
    > `참조 가능한 변수`가 다름
    > 
    - Static nested class → 외부 클래스의 static 변수만 접근 가능
    - Inner class & Anonymous class → 모든 변수 접근 가능
    - 외부 클래스 → Nested class의 모든 변수에 접근 가능

## 3. 객체 만드는 방법

### new

- 클래스에 선언된 생성자를 호출
- 하나의 클래스에 다양한 생성자가 오버로딩으로 선언되어 있을 수 있음
    
    → 다양한 매개변수 조합으로 인스턴스를 생성할 수 있음
    

## 4. 메소드 정의하는 방법

### 1. 메소드 구조

1. modifier
2. 리턴 타입
3. 메소드 이름
4. 매개변수
    - 가변 인수(Varargs)
        - 필요에 따라 매개변수를 가변적으로 조정할 수 있는 기술
        - 전달받은 매개변수를 배열로 만듦
        - 매개변수 리스트의 맨 마지막에 사용해야하며 한번만 사용 가능함
5. 메소드 바디

### 2. 메소드 시그니처

- 메소드 이름 + 매개변수의 조합 (매개변수 갯수, 순서, 타입)
    - modifier, 리턴타입은 메소드 시그니처에 포함되지 않음

### 3. 메소드 명명법 (자바 컨벤션)

- lowerCamelCase
- `동사/전치사`로 시작함
    
    ex) getUserName(), toString()
    
- `메소드 이름으로 자주 사용되는 동사`
    1. get/set
    2. init
        - 데이터를 초기화하는 메소드
            
            ex) initData(), initMember()
            
    3. is/has/can
        - 리턴타입으로 boolean을 리턴하는 메소드
        - is
            - 맞는지 틀린지 판단하는 메소드
                
                ex) isEmpty()
                
        - has
            - 데이터를 가지고 있는지 확인하는 메소드
                
                ex) hasData()
                
        - can
            - 할 수 있는지 없는지 확인하는 메소드
                
                ex) canOrder()
                
    4. create
        - 새로운 객체를 만든 후 리턴해주는 메소드
            
            ex) createOrder()
            
    5. find
        - 데이터를 찾는 메소드
            
            ex) findElement()
            
    6. to
        - 해당 객체를 다른 형태의 객체로 변환하는 메소드
            
            ex) toString()
            
    7. A-By-B
        - B를 기준으로 A를 하겠다는 메소드
            
            ex) getUserByName()
            

## 5. 생성자 정의하는 방법

### 1. 생성자

- 객체를 생성하고 heap 영역에 메모리 할당함

### 2. 기본 생성자

- 매개변수로 아무것도 받지 않는 생성자
- 클래스 내부에 생성자를 하나도 선언하지 않은 경우
    - 컴파일 단계에서 기본 생성자 자동으로 생성
- 클래스 내부에 선언된 생성자가 있는 경우
    - 자동으로 생성되지 않음
    - 기본 생성자를 사용하려면 추가로 선언해줘야함

### 3. 생성자 오버로딩

- 다양한 조합의 매개변수를 받아 객체를 생성하고자 할 때 사용

## Reference

[[java-live-study] 5주차-클래스](https://jeeneee.dev/java-live-study/week5-class/)

modifier

[study/java/whiteship-study/5week at main · ByungJun25/study](https://github.com/ByungJun25/study/tree/main/java/whiteship-study/5week)

Reference type parameter, nested class

[TIL/java/live-study/05. 클래스 at master · hypernova1/TIL](https://github.com/hypernova1/TIL/tree/master/java/live-study/05.%20%ED%81%B4%EB%9E%98%EC%8A%A4)

클래스 메소드의 사용

[[5주차] 클래스](https://forbeginnerdevs.tistory.com/22)

java 클래스 실행 순서

[좋은 코드를 위한 자바 메서드 네이밍](https://tecoble.techcourse.co.kr/post/2020-04-26-Method-Naming/)

메소드 명명법, getter/setter 주의사항

[[Java-25] 클래스 & 내부클래스 & 익명클래스](https://catch-me-java.tistory.com/37)

내부 클래스 사용 → 캡슐화!

## +@ 트리 자료구조

[[Java] 트리 자료구조의 개념과 구현](https://ahnyezi.github.io/java/javastudy-5-tree/)