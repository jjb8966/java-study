# 6주차 : 상속

## 1. 상속

> 부모 클래스에서 사용하던 변수와 메소드(public, protected)를 자식 클래스에서 `재사용`하기 위해 사용
> 
- `자식 클래스의 객체를 생성`하면 **자동으로 부모의 생성자가 먼저 호출**되고 **자식의 생성자가 호출됨**
    - 모든 클래스의 부모 클래스는 Object 클래스
    - 어떤 클래스의 객체를 생성하든 Object 클래스의 생성자가 호출된다. (순서는 다를 수 있음)
        - Child class → Parent class → Object class
- 목적
    - **코드를 재사용**하여 중복된 코드를 작성하지 않아도 됨
    - **클래스 간 계층 구조**를 분류할 수 있음
    - **유지보수**가 쉬워짐
        - 부모 클래스에 필드를 추가하면 모든 자식 클래스에서도 필드가 추가됨
- 단일 상속만 가능
    - **다중 상속 불가능**

## 2. super 키워드

- 자식 클래스에서 **부모 클래스에 접근할 때 사용하는 키워드**
    - 부모 클래스의 참조 변수
- super.필드
    - 부모 클래스의 필드에 접근함
- super.메소드
    - 부모 클래스의 메소드를 사용함
- super()
    - 부모 클래스의 생성자를 명시적으로 지정
    - **자식 클래스를 컴파일** 할 때 **자동으로 자식 클래스의 생성자 가장 첫 줄에 'super()'**가 만들어짐
    - 따라서 **부모 클래스에 기본 생성자가 없다면 에러**가 남
        - 부모 클래스에 기본 생성자가 없는 경우
            1. 부모 클래스 기본 생성자를 만듦
            2. super(...)를 이용해 부모 클래스 생성자를 만듦
            
            ```java
            public class InheritanceClass {
                
                public static void main(String[] args) {
                    ChildClass child = new ChildClass();
                }
            }
            
            class ParentClass {
                
            //  public ParentClass() {
            //      System.out.println("ParentClass constructor");
            //  }
                public ParentClass(String name) {
                    System.out.println("Parent name is " + name);
                }
            }
            
            class ChildClass extends ParentClass {
                
                ChildClass() {
                    super("HI");        //부모 클래스의 생성자를 명시적으로 지정
                    System.out.println("ChildClass constructor");
                }
            }
            ```
            
            > 결과
            > 
            > 
            > Parent name is HI
            > ChildClass constructor
            > 

## 3. 메소드 오버라이딩

> 부모 클래스의 메소드와 `동일한 메소드 시그니처, 리턴 타입`을 갖는 메소드를 자식 클래스에서 재정의하는 것
> 
- 접근 제어자는 달라도 되지만 `자식의 접근 제어자 범위가 더 커야함`
    - 부모 - default
    - 자식 - default 이상 (public, protected, default)
        - 부모가 공개한다는데 자식이 더 좁은 범위만 보여준다고? 안됨!
    
    cf) 부모 클래스의 메소드가 private
    
    - 자식 클래스의 메소드는 어떤 접근 제어자를 써도 상관 없음
    - private이 가장 작은 범위의 접근 제어자이기 때문
- 부모 클래스의 메소드보다 더 큰 범위의 예외를 선언할 수 없음 - `보충 필요`

```java
public class Overriding {

    public static void main(String[] args) {
        Child child = new Child();
        child.func();
    }
}

class Parent {

    private void func() {
        System.out.println("parent function");
    }
}

class Child {

    public void func() {
        System.out.println("child function");
    }
}
```

<aside>
💡 Overloading - 확장 
→ 메소드 시그니처가 다른 서로 다른 메소드들을 만들어 확장함 (자식>부모)
Overriding - 덮어 씀 
→ 메소드 시그니처가 같은 메소드를 만들어 부모 클래스의 기능은 무시하고 덮어 씀

</aside>

## 4. 메소드 디스패치

- 확실치 않으니 참고만... 메소드의 클래스 타입을 결정하는 것

### 정적 메소드 디스패치

> `컴파일 시` 오버라이딩 된 메소드가 어떤 클래스 타입의 메소드인지 결정됨
> 

```java
class Human {

		int a;

    public void printA() {
        System.out.println("사람 메소드 : " + a);
    }

}

class Parent extends Human {

    @Override
    public void printA() {
        System.out.println("부모 메소드 : " + a);
    }
}

class Child extends Human {

    @Override
    public void printA() {
        System.out.println("자식 메소드 : " + a);
    }
}

public class InheritanceTest {
    public static void main(String[] args) {
        Parent parent = new Parent();
        Child child1 = new Child();

        parent.printA(); // 부모 클래스 타입의 printA() 메소드
        child1.printA(); // 자식 클래스 타입의 printA() 메소드
    }
}
```

### 동적 메소드 디스패치

> `런타임 시` 오버라이딩 된 메소드가 어떤 클래스의 메소드인지 결정됨
컴파일 단계에서는 해당 메소드가 어떤 클래스 타입의 메소드인지 모름
> 
- 인터페이스, 추상 클래스, 메소드 오버라이딩
    - 컴파일 단계에서는 어떤 클래스, 구현체의 메소드인지 모름
    - `런타임 시` **메소드의 클래스 타입이 정해져 호출되는 것**을 다이나믹 메소드 디스패치라고 함
- 메소드의 클래스 타입 결정은 **참조 변수 타입이 아니라** **참조할 객체의 타입에 따름**

```java
public class InheritanceTest {
    public static void main(String[] args) {
        Human whoIsIt = new Child();

        whoIsIt.printA(); // 컴파일 시 (눈으로 보기에) 어떤 클래스 타입의 메소드인지 알 수 없음
				// 실행해보면 자식 클래스 타입의 printA() 메소드가 호출됨
    }
}
```

### 더블 디스패치 - 방문자 패턴 `보충 필요`

## 5. 인터페이스

> 실제 코드는 작성하지 않더라도 `어떤 메소드들이 있어야 하는지를 정의해 놓은 것`
> 
- 내용(몸통, 중괄호)이 없는 메소드만으로 구성
- .java 파일이며 컴파일하면 .class가 됨. 하지만 단독으로 쓸 수는 없음
- 인터페이스에 정의된 필드는 모두 `public static final` 필드
- **static**이나 **final** 메소드가 선언되있으면 안 됨
- 사용 목적
    1. 설계 시 선언해 두면 개발할 때 `기능 구현에만 집중`할 수 있음
    2. `외부에 노출되는 것을 정의해 놓음`
- 클래스는 인터페이스를 구현(implements)할 수 있음
    - `여러 개의 인터페이스를 구현`할 수도 있음
- 인터페이스가 다른 인터페이스를 상속받을 수 있음 (extends)

## 6. 추상 클래스 (abstract class)

> `일부 완성`되어 있는 클래스
> 
- **abstract라고 선언한 메소드가 0개 이상 있어야 함**
    - abstract 메소드가 없어도 컴파일 에러가 나진 않음
        - but, 무조건 1개 이상의 메소드를 오버라이딩 해야함 (Object 클래스의 메소드라도)
    - 추상 클래스를 상속받은 클래스는 **반드시 추상 메소드를 구현**해야 함
- 추상 클래스를 인스턴스화, 즉 **단독으로 객체를 만들 수 없음**
    - **추상 클래스를 상속받고 추상 메소드를 구현한 클래스**를 인스턴스화 해야함
        - **익명 클래스**를 만들어서 객체를 생성할 수도 있음
- 구현되어 있는 메소드가 있어도 상관 없음
- **static**이나 **final** 메소드 있어도 됨

```java
public abstract class AbsClass {
    int a;

    public AbsClass(int a) {
        this.a = a;
    }

    public void printA() {
        System.out.println(a);
    }
}

public static void main(String[] args) {

    /**
     * 1. 추상 클래스는 단독으로 인스턴스화 할 수 없음
     * -> 익명 클래스를 만들고 객체를 생성함
     * 2. 추상 클래스에 추상 메소드가 없어도 에러는 안남
     * but, 추상 메소드 유무와 상관없이 상속받은 클래스는 하나 이상의 메소드를 오버라이딩 해야함
     * 3. 추상 메소드가 있다면 그 메소드는 무조건 오버라이딩 해야함
     */
    AbsClass absClass = new AbsClass(10) {
        @Override
        public void printA() {
            super.printA();
        }
    };
}
```

- 사용 목적
    1. 인터페이스를 만들다보니 `어떤 메소드는 미리 만들어 놓아도 전혀 문제가 없을 때`
    2. 아주 공통적인 기능들을 만들어 놓을 때

### 인터페이스 & 추상 클래스 사용 목적

- 개발자의 역량에 따른 변수, 메소드 선언의 격차를 줄일 수 있음
- 공통적인 인터페이스와 추상 클래스를 선언해 놓으면 선언과 구현을 구분할 수 있음

[비교](6%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%89%E1%85%A1%E1%86%BC%E1%84%89%E1%85%A9%E1%86%A8%20e297e962ff7e4aea965381d2d68d2dfd/%E1%84%87%E1%85%B5%E1%84%80%E1%85%AD%20bcd3f3e76cdb4f1ba6d1976dd1e65caf.csv)

## 7. final 키워드

- class
    - public **final** class FinalClass
    - final 클래스는 `더 이상 상속해 줄 수 없음`
    - 더 이상 확장하면 안되는 클래스에 사용 (ex. String)
- method
    - public **final** void finalMethod
    - `더 이상 오버라이딩 할 수 없음` → 누군가 메소드의 기능을 바꿀 수 없음
- 변수
    - `바꿀 수 없는 변수`
    - 선언과 함께 초기화를 해야함
    - `매개 변수 & 지역 변수`는 반드시 **선언할 때 초기화 할 필요 없음**
        - 매개 변수
            - 이미 넘어올 때 초기화 되어서 넘어옴
        - 지역 변수
            - 선언된 중괄호 내에서만 참조되므로
        
        → 단, 둘 다 메소드 내부에서 다시 값을 할당하면 안 됨
        
    - `참조 자료형 변수`
        - 마찬가지로 final로 선언하면 **두 번 이상 값을 할당하거나 생성자를 사용해 초기화할 수 없음**
        - **객체의 인스턴스 변수**나 **클래스 변수**는 **바꿀 수 있음**
            - 객체는 final이지만 객체의 필드는 final이 아니기 때문에

## 8. Object 클래스

### 1. java.lang.Object 클래스

- 모든 자바 클래스의 부모 클래스
- 클래스의 기본적인 행동을 정의해 놓은 클래스
- 필드는 가지지 않으며 11개의 메소드로만 구성
- 메소드 종류
    
    ![자주 쓰는 것 : toString(), equals(), hashCode(), getClass(), clone()](6%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%89%E1%85%A1%E1%86%BC%E1%84%89%E1%85%A9%E1%86%A8%20e297e962ff7e4aea965381d2d68d2dfd/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2021-09-04_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_7.21.27.png)
    
    자주 쓰는 것 : toString(), equals(), hashCode(), getClass(), clone()
    
    - 객체를 처리하기 위한 메소드
        - equals()
            - 메소드를 호출한 객체와 매개변수로 넘겨받은 객체가 같은지 비교
        - getClass()
            - Class 클래스의 객체를 리턴 - 리플렉션, 20장
        - hashCode()
            - 객체의 해시코드 값을 리턴
                - 해시코드
                    - 객체의 메모리 주소를 16진수로 표현한 것
        - toString()
            - 객체를 문자열로 표현한 것
    - 쓰레드를 처리하기 위한 메소드
        - notify()
            - 객체의 모니터에 대기하고 있는 단일 쓰레드를 깨움
        - notifyAll()
            - 객체의 모니터에 대기하고 있는 모든 쓰레드를 깨움
        - wait()
            - 다른 쓰레드가 현재 객체에 대한 notify(), notifyAll()을 호출할 때까지 현재 쓰레드가 대기함
            - 매개변수로 밀리초 시간을 받을 수 있음 (1/1000초)

### 2. toString()

- 객체를 출력하는 메소드
- '`패키지.클래스@해시코드값`' 리턴함
    - `getClass().getName() + ‘@’ + Integer.toHexString(hashCode())`
- 오버라이딩을 해서 **객체를 쉽게 확인할 목적**으로 사용
- 자동 호출되는 경우
    - **println()** 메소드에 **매개변수**로 들어가는 경우
    - **객체에 더하기 연산**을 하는 경우
    
    ```java
    public class ToStringMethod {
    
        public static void main(String[] args) {
            Banana banana = new Banana();
            Apple apple = new Apple();
            System.out.println(banana);
            System.out.println("HI "+apple);
            System.out.println("Hello "+apple.toString());
        }
    }
    
    class Banana {}
    
    class Apple {
    
        public String toString() {
            return "I am Apple";
        }
    }
    ```
    
    > 결과
    > 
    > 
    > chapter11.Banana@36baf30c
    > HI I am Apple
    > Hello I am Apple
    > 
- 보통 DTO 클래스를 사용할 때 toString() 메소드를 오버라이딩 해놓는게 좋음
    - 그래야 객체의 내용을 확인하기 쉽기 때문

### 3. equals()

- 객체가 같은지 다른지 비교하는 메소드
- == & !=
    - 위 연산자는 기본 자료형에서만 사용해야함
    - 정확히는 참조자료형에 ==, != 사용할 순 있으나 이것은 **두 객체의 주소값을 비교하는 것**
- 객체를 비교할 때는 **equals() 메소드를 오버라이딩**하여 사용해야 함
    - 그냥 사용하면 두 객체의 해시코드값을 리턴하므로 == 비교와 똑같음
    - equals() 메소드를 오버라이딩할 때 hashCode() 메소드도 같이 오버라이딩 해야함
        - equals() 메소드의 결과는 true인데 hashCode() 메소드의 결과값은 다름
            
            → hashCode() 메소드도 같은 결과를 갖도록 오버라이딩 해야함
            
            cf) 보통 IDE가 equals() & hashCode()를 자동으로 오버라이딩 해줌
            
- 기능 위주 클래스에서는 굳이 오버라이딩할 필요 없음

```java
import java.util.Objects;

class Banana {

    int count;

    Banana() {
    }

    Banana(int number) {
        count = number;
    }

		//cmd+N 단축키를 이용해 자동으로 만듦
    @Override
    public String toString() {
        return "Banana{" +
                "count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Banana banana = (Banana) o;
        return count == banana.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}
```

```java
public class EqualsMethod {

    public static void main(String[] args) {
        Banana banana1 = new Banana(1);
        Banana banana5 = new Banana(5);
        Banana banana10 = new Banana(1);

        System.out.println(banana1);
        System.out.println(banana5);
        System.out.println(banana10);

        if (banana1.equals(banana5)) {
            System.out.println("same fruit");
        } else {
            System.out.println("different fruit");
        }

        if (banana1.equals(banana10)) {
            System.out.println("same fruit");
        } else {
            System.out.println("different fruit");
        }
    }
}
```

> 결과
> 
> 
> Banana{count=1}
> Banana{count=5}
> Banana{count=1}
> different fruit
> same fruit
> 

### 4. hashCode()

> `객체의 메모리 주소`를 **16진수로 변환하여 리턴**하는 메소드
> 
- `두 객체가 동일`하면 `hashCode() 값이 똑같아야 함`
- 오버라이딩 규칙
    1. 자바 애플리케이션이 실행되는 동안 항상 동일한 int 값을 리턴해야 함
    2. equals() 메소드 결과가 true인 경우 두 객체의 hashCode() 결과값은 항상 동일해야 함
        - equals() 메소드 오버라이딩 시 hashCode() 메소드도 같이 오버라이딩 해야하는 이유
    3. 두 객체의 equals() 결과가 false라고 해서 무조건 hashCode() 결과값이 달라야 하는 것은 아님
    
    > 직접 오버라이딩 하는것은 권장하지 않음. IDE가 알아서 잘 해준다.
    > 

## Reference

[[Java] 상속](https://leemoono.tistory.com/20)

방문자 패턴

[자바 상속](https://velog.io/@youngerjesus/%EC%9E%90%EB%B0%94-%EC%83%81%EC%86%8D#abstract-classes-compared-to-interfaces)

casting object

[Seung's Story : 네이버 블로그](https://blog.naver.com/swoh1227/222181505425)

더블 디스패치