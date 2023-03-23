# 8주차 : 인터페이스

# 1. 인터페이스

> 실제 코드는 작성하지 않더라도 `어떤 메소드들이 있어야 하는지를 정의해 놓은 것`
> 
- .java 파일이며 컴파일하면 .class가 됨. 하지만 단독으로 쓸 수는 없음
- 클래스는 인터페이스를 구현(implements)할 수 있음
    - `여러 개의 인터페이스를 구현`할 수도 있음

## 사용 목적

1. 설계 시 선언해 두면 인터페이스 사용으로 `로직을 먼저 구성`하고 개발할 때 `기능 구현에만 집중`할 수 있음
    
    -> 개발 시간 단축
    
2. 클래스에 정형화된 틀을 제공하여 `표준화`가 가능함
3. `다형성을 극대화`하여 **코드의 수정을 줄이고** **유지보수성**을 높일 수 있음

## 정의하는 법

- class 예약어 대신  interface 사용
- 접근 제어자는 public 또는 default
    - 메소드의 접근 제어자도 public 또는 default만 가능
- 필드와 추상 메소드로 구성
    - 인터페이스의 모든 필드는 `public static final`
        - 굳이 안써도 자동으로 적용됨
    - Java 8 이후부터 default method, static method가 추가되어 바디가 있는 메소드도 포함될 수 있음

```java
public interface BasicInterface {
    // public static final 가 자동으로 적용됨
    // + final 키워드가 붙으므로 반드시 선언 시 초기화 되어야 함
    public static final int a = 10;

    // public abstract 가 자동으로 적용됨
    public abstract void basicMethod();
}
```

## 구현하는 법

- implements 키워드를 사용하여 구현
- 클래스와 다르게 다중 구현이 가능함

```java
public class BasicClass implements BasicInterface, BasicInterface2 {

    @Override
    public void basicMethod() {
        System.out.println("hi");
    }

    @Override
    public void basic2() {
        System.out.println("hihi");
    }
}
```

# 2. 추상 클래스 & 인터페이스

## 추상 클래스 → is-a 관계

- 일반 메소드와 추상 메소드를 모두 가질 수 있음
    - Java 8부터는 인터페이스도 구현된 메소드(default, static method)를 가질 수 있음
- 클래스(A) ↔ 추상 클래스(B) 관계
    - is-a : A는 B이다.

## 인터페이스→ has-a 관계

- 추상 메소드만 가질 수 있음 (Java 8 이전까지는)
- 클래스(A) ↔ 인터페이스(B) 관계
    - has-a : A는 B를 할 수 있다.

## 많은 추상 클래스가 인터페이스로 바뀌고 있다.

- 추상 클래스는 사용하려면 상속을 받아야 하는데 클래스는 다중 상속이 불가능함
    - 만약 A라는 클래스가 B의 상속을 받는데 별도로 C를 상속받고 싶다면?
        
        → 추상 클래스는 불가능함
        
- 추상 클래스를 인터페이스로 바꾸면 개발자가 자유롭게 인터페이스를 구현해서 사용할 수 있음
    - A가 B클래스의 상속을 받고 C를 구현할 수 있음

# 3. ⭐인터페이스 레퍼런스를 통해 구현체를 사용하는 방법

> 인터페이스를 사용하면 인터페이스 레퍼런스를 써라!
> 

## 클래스 레퍼런스 vs 인터페이스 레퍼런스

- 클래스 레퍼런스
    - 클래스 타입의 변수
- 인터페이스 레퍼런스
    - 인터페이스 타입의 변수
    - 구현체에 다른 메소드가 추가로 선언되어 있어도 인터페이스 자신에게 선언된 메소드(+ 상속받은 메소드)만 사용 가능함

## 인터페이스 상속

- 인터페이스가 다른 인터페이스를 상속받을 수 있음 (extends)
- 구현하는 것이 아니기 때문에 상속받는 메소드를 반드시 오버라이딩 할 필요는 없음
- 인터페이스의 상속은 다중 상속이 가능함
    - default method, static method가 아닌 추상 메소드는 오버라이딩의 의미가 없음

```java
public interface FirstInterface {

    void firstMethod();
}
```

```java
// 인터페이스의 상속은 다중 상속이 가능함
public interface SecondInterface extends FirstInterface {

//    @Override
//    void firstMethod();

    // 인터페이스끼리 상속은 상속받았다고 꼭 오버라이딩 해야하는 것은 아님
    void secondMethod();
}
```

```java
public class MultipleImpl implements SecondInterface, FirstInterface{

    // 상속받은 인터페이스를 구현하는 클래스는 구현하는 인터페이스의 부모 인터페이스도 구현해야 함
    @Override
    public void firstMethod() {
        System.out.println("hi");
    }

    @Override
    public void secondMethod() {
        System.out.println("hihi");
    }

    void myMethod() {
        System.out.println("hihihi");
    }

    public static void main(String[] args) {
        System.out.println("----------클래스 레퍼런스----------");
        MultipleImpl multiple = new MultipleImpl();
        multiple.firstMethod();
        multiple.secondMethod();
        multiple.myMethod();

        System.out.println("----------인터페이스 레퍼런스----------");
        SecondInterface useInterface = new MultipleImpl();
        useInterface.firstMethod();
        useInterface.secondMethod();
        //useInterface.myMethod(); -> useInterface 변수는 SecondInterface 타입이므로 myMethod가 없음
    }
}
```

> [출력]
---------클래스 레퍼런스----------
hi
hihi
hihihi
----------인터페이스 레퍼런스----------
hi
hihi
> 

## 인터페이스 레퍼런스 사용 목적

- 한 클래스가 여러 인터페이스를 구현한 경우
    - 각 인터페이스 별로 해당 클래스 객체를 생성해 사용할 수 있음
    
    ```java
    FirstInterface firstObj = new MultipleImpl(); // firstMethod()만 사용 가능
    
    SecondInterface secondObj = new MultipleImpl(); // firstMethod(), secondMethod() 사용 가능 
    ```
    

# 4. 다중 인터페이스 구현

## 메소드 시그니처는 같은데 리턴 타입이 다른 경우

> 어떤 인터페이스의 메소드를 구현해야할지 구현 클래스에서 알 수 없으므로 에러 발생 (다중 상속 불가능)
> 

```java
public interface InterfaceA {

    String sayHi();
}
```

```java
public interface InterfaceB {

    void sayHi();
}
```

```java
public class  ImplAB implements InterfaceA, InterfaceB{

    @Override
    public String sayHi() {  // 컴파일 에러 발생
        return null;
    }
}
```

![Untitled](8%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8B%E1%85%B5%E1%86%AB%E1%84%90%E1%85%A5%E1%84%91%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%89%E1%85%B3%20b99d6d37ee6a4ccc9047c9dfd7467196/Untitled.png)

## 메소드 시그니처와 리턴 타입이 모두 같은 경우

> 중복되는 메소드를 구현할 수 있음
> 
- 두 인터페이스가 하나의 구현 메소드를 바라봄

```java
public interface InterfaceA {

    String sayHi();
}
```

```java
public interface InterfaceC {

    String sayHi();
}
```

```java
public class ImplAC implements InterfaceA, InterfaceC{
    @Override
    public String sayHi() {
        return "hi";
    }

    public static void main(String[] args) {
        ImplAC classReference = new ImplAC();
        InterfaceA interfaceAReference = new ImplAC();
        InterfaceC interfaceCReference = new ImplAC();

        System.out.println(classReference.sayHi());
        System.out.println(interfaceAReference.sayHi());
        System.out.println(interfaceCReference.sayHi());
    }
}
```

# 5. 인터페이스 & 결합

```java
public interface Accelerator {
    void accelerate();
}
```

```java
public class Car {

    private Accelerator accel;

    public void setAccel(Accelerator accel) {
        this.accel = accel;
    }
}
```

```java
public class OldAccel implements Accelerator {

    @Override
    public void accelerate() {
        System.out.println("옛날 엑셀");
    }
}
```

```java
public class NewAccel implements Accelerator {

    @Override
    public void accelerate() {
        System.out.println("최신 엑셀");
    }
}
```

## 1. 강한 결합 (Tight Coupling)

- 코드가 **구현체를 의존**하고 있는 경우
    - 구현체를 변경하고 싶은 경우 구현체가 들어간 부분의 코드를 수정해야함
        - 만약 oldAccel이 100번 사용되었다면?
            
            → 직접 찾아서 일일이 수정해야함
            

```java
public class TightCoupling {

    public static void main(String[] args) {
        Car car = new Car();
        Accelerator oldAccel = new OldAccel();

        car.setAccel(oldAccel);

        // 만약 newAccel 로 바꾸고 싶다면?
        Accelerator newAccel = new NewAccel();
        car.setAccel(newAccel);
    }
}

```

## 2. 느슨한 결합 (Loose Coupling)

- 코드가 **인터페이스를 의존**하고 있는 경우
    - 구현체를 변경하고 싶은 경우 **설정 정보만 바꿔주면 됨**
        - Config 클래스를 통해 엑셀을 주입받는 형태 → 의존관계 주입(DI)

```java
public class LooseCoupling {

    public static void main(String[] args) {
        Car car = new Car();
        Config config = new Config();

        car.setAccel(config.accelerator());
        // 만약 newAccel 로 바꾸고 싶다면?
        // Accelerator 를 주입해주는 Config 클래스를 수정해주면 됨
    }
}
```

```java
public class Config {

    public Accelerator accelerator() {
        return new OldAccel();
        // 만약 newAccel 로 바꾸고 싶다면?
        // return new NewAccel();
    }
}

```

⇒ 느슨한 결합을 사용하라!

# 6. 자바 8

> 인터페이스에서 추상 메소드 뿐만 아니라 구현된 메소드도 가질 수 있게 됨
> 

## 1. 기본 메소드 (Default Method)

- 오버라이딩하지 않아도 됨
- 구현체에서 오버라이딩 할 수도 있음
- 사용 목적
    1. **인터페이스를 구현한 클래스에 영향을 주지 않으면서** `기능을 추가`하고 싶을 때 경우
        - 엄청나게 많은 곳에서 인터페이스 구현체를 사용하고 있는 경우
            - 인터페이스를 보완하는 과정에서 필수 기능이 추가될 수도 있음
            - 이 때 인터페이스에 추상 메소드를 추가하면?
                - 인터페이스를 구현한 구현체 부분이 전부 에러가 남
            - 이럴 때 default method를 추가하여 호환성은 유지하면서 인터페이스에 기능을 추가할 수 있음
    2. 인터페이스를 구현하는데 모든 추상 메소드를 구현할 필요는 없는 경우

## 2. static 메소드

- 인스턴스 없이 (사용해야만 하는) 사용할 수 있는 메소드
    - 인스턴스로 메소드를 호출할 수 없음
    - 반드시 **인터페이스.메소드명()**으로 호출해야 함
- 구현체에서 오버라이딩 할 수 없음
- 사용 목적
    - 해당 인터페이스를 구현한 모든 클래스에서 동일한 메소드를 사용하고 싶은 경우

```java
public interface UsedInterface {

    void hi();

    // bye 기능을 추가해야함
    //void bye(); -> 인터페이스를 구현한 구현체에서 에러가 남 (추가된 추상 메소드가 구현되지 않았으므로)
    default void bye() {    // 구현체에서 에러가 안남 -> default method 오버라이딩하지 않아도 되므로
        System.out.println("bye");
    }
}
```

```java
public class OnlyHi implements UsedInterface{

    @Override
    public void hi() {
        System.out.println("hi");
    }
}
```

```java
public class HiAndBye implements UsedInterface{

    @Override
    public void hi() {
        System.out.println("hi");
    }

    @Override
    public void bye() {
        System.out.print("good");
        UsedInterface.super.bye();
    }
}

```

- 인터페이스의 default 메소드 사용
    - `인터페이스명.super.메소드명()`
        - 인터페이스명.메소드명() 아님!

```java
public class UseInterfaceClass {

    public static void main(String[] args) {
        OnlyHi impl1 = new OnlyHi();
        HiAndBye impl2 = new HiAndBye();

        impl1.hi();

        impl2.hi();
        impl2.bye();

//        impl1.staticMethod(); -> 구현 객체를 통해 static method 를 호출할 수 없음
        UsedInterface.staticMethod();
    }
}
```

## 3. 그럼 추상 클래스를 왜 쓰는가?

- 이제 인터페이스에서 구현된 메소드도 제공할 수 있는데…
- Java 8 이상에서만 가능하기 때문에 이전 버전의 자바 코드에서는 호환되지 않을 수 있음
- **인터페이스는 필드를 상수로만 가질 수 있기 때문에** 구현체에서 같은 이름의 다른 값을 갖는 필드를 제공해 줄 수 없음

> 필드는 상수만 가지면서 메소드(행동) 위주의 상속을 원하는 경우 인터페이스를 쓰는게 좋겠다.
클래스마다 같은 이름, 다른 값을 갖는 필드가 존재해야 한다면 여전히 추상 클래스를 사용해야 한다.
> 

# 7. 자바9

## private 메소드

- 인터페이스 내부에서만 사용될 메소드가 외부로 공개되는 것을 막기위해 사용
    - 구현 클래스나 상속 인터페이스에서 접근하거나 오버라이딩하지 못하도록 막고싶은 경우

> default method, static method 코드가 복잡해질 경우 내부에서만 사용될 메소드를 private으로 만들어 쓸 수 있음
> 

```java
public interface UsedInterface {

    void hi();

    // bye 기능을 추가해야함
    // void bye(); -> 인터페이스를 구현한 구현체에서 에러가 남 (추가된 추상 메소드가 구현되지 않았으므로)

    default void bye(int count) {    // 구현체에서 에러가 안남 -> default method 오버라이딩하지 않아도 되므로
        System.out.println("start bye");

        validCheckAndRepeat(count);      // 내부에 복잡한 로직이 있다면 private 메소드를 만들어서 분리할 수 있음

        System.out.println("end bye");
    }

    private void validCheckAndRepeat(int count) {
        if (count < 10) {
            for (int i = 0; i < count; i++) {
                System.out.println("bye");
            }
        }
    }

    static void staticMethod() {
        System.out.println("모든 구현체에서 이 메소드를 사용해라");
    }
}
```

# Reference

[인터페이스](https://www.notion.so/4b0cf3f6ff7549adb2951e27519fc0e6)

[온라인 자바 스터디 #8 - 인터페이스](https://dev-coco.tistory.com/13)

[[java] class, interface 상속](https://joont92.github.io/java/class-interface-%EC%83%81%EC%86%8D/)

인터페이스 상속