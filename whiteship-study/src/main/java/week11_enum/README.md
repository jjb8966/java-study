# 11주차 : Enum

# 상수

> public static final로 선언한 변수
> 
- 선언 시 초기화되면 애플리케이션이 끝날 때까지 변경되지 않는 값
- type safety하지 않음
    
    ```java
    public class NotTypeSafety {
    
        public static final int MONDAY = 1;
        public static final int TUESDAY = 2;
        public static final int WEDNESDAY = 3;
    
        public static final int APPLE = 1;
        public static final int BANANA = 2;
        public static final int PEACH = 3;
    
        static void printDay(int day) {
            if (day == 1) {
                System.out.println("오늘은 월요일입니다.");
            }
    
            if (day == 2) {
                System.out.println("오늘은 화요일입니다.");
            }
    
            if (day == 3) {
                System.out.println("오늘은 수요일입니다.");
            }
        }
    
        static void printFruit(int fruit) {
            if (fruit == 1) {
                System.out.println("사과입니다.");
            }
    
            if (fruit == 2) {
                System.out.println("바나나입니다.");
            }
    
            if (fruit == 3) {
                System.out.println("복숭아입니다.");
            }
        }
    
        public static void main(String[] args) {
            int day = MONDAY;
            int fruit = APPLE;
    
            printDay(day);
            printDay(fruit);
    
            printFruit(day);
            printFruit(fruit);
    
            if (day == fruit) {
                System.out.println("날짜는 과일입니다.");
            } else {
                System.out.println("날짜는 과일이 아닙니다.");
            }
            // 출력 : 날짜는 과일입니다.
        }
    }
    ```
    

# enum

> 상수들의 모아놓은 클래스 = 열거형 클래스
> 
- 정확히는 `enum 객체`를 모아놓은 클래스
    - enum 객체 **public static final**
    
    ```java
    public enum BasicEnum {
        FIRST, SECOND, THIRD
    }
    ```
    
    ![Untitled](https://user-images.githubusercontent.com/87421893/173608376-9085c8a1-7fe1-4668-afc9-0bab9a5f3832.png)
    
    - enum 객체는 **필드와 메소드를 가질 수 있음**
        
        ⇒ enum 객체는 새로운 객체로 바뀔 수 없는 상수(static final)지만 필드는 final로 막지 않으면 바뀔 수도 있음
        
- type safety를 보장하기 위해 사용함
    
    ```java
    public class TypeSafety {
    
        enum Day {MONDAY, TUESDAY, WEDNESDAY}
    
        enum Fruit {APPLE, BANANA, PEACH}
    
        private static void printDay(Day day) {
            if (day == Day.MONDAY) {
                System.out.println("오늘은 월요일입니다.");
            }
    
            if (day == Day.TUESDAY) {
                System.out.println("오늘은 화요일입니다.");
            }
    
            if (day == Day.WEDNESDAY) {
                System.out.println("오늘은 수요일입니다.");
            }
        }
    
        private static void printFruit(Fruit fruit) {
            if (fruit == Fruit.APPLE) {
                System.out.println("사과입니다.");
            }
    
            if (fruit == Fruit.BANANA) {
                System.out.println("바나나입니다.");
            }
    
            if (fruit == Fruit.PEACH) {
                System.out.println("복숭아입니다.");
            }
        }
    
        public static void main(String[] args) {
            Day day = Day.MONDAY;
            Fruit fruit = Fruit.APPLE;
    
            printDay(day);
    //        printDay(fruit);  -> 타입 체크로 인한 컴파일 에러
    
    //        printFruit(day);  -> 타입 체크로 인한 컴파일 에러
            printFruit(fruit);
    
            if (day.equals(fruit)) {
                System.out.println("날짜는 과일입니다.");
            } else {
                System.out.println("날짜는 과일이 아닙니다.");
            }
            // 출력 : 날짜는 과일이 아닙니다.
        }
    }
    ```
    

## 1. 정의

- 상수의 타입이나 값을 지정하지 않고 선언만 해도 됨
    - 선언만으로 기본 생성자를 통해 enum 객체를 만듦
    
    ```java
    public enum BasicEnum {
        ONE, TWO, THREE;
    }
    ```
    
## 2. 사용
- 별도의 생성자 없이 `enum 클래스.상수 이름`으로 참조값을 가져올 수 있음
    
    ```java
    public class Test {
    
        public static void main(String[] args) {
            BasicEnum one = BasicEnum.ONE;
    
            if (one.equals(BasicEnum.ONE)) {
                System.out.println(true);
            }
    
            enumParamMethod(BasicEnum.TWO);
        }
    
        static void enumParamMethod(BasicEnum param) {
            System.out.println(param);
        }
    }
    ```
## 3. 장점

1. `타입 비교가 가능`하여 타입 세이프함
    1. 예를 들어 정수 상수인 경우 오타로 서로 다른 상수인데 같은 숫자가 들어가면 두 상수는 같은 상수가 되어버림. Enum은 이를 방지할 수 있음.
2. 관련있는 상수를 모아서 관리하기 때문에 `유지보수가 용이`함
3. 상수를 `순회`하기 편해짐

# enum 멤버

## 1. 필드

- enum 객체와 연관된 데이터를 상수 객체 자체에 포함시킴
- 일반적으로 private final로 선언
    - final로 선언하지 않아도 컴파일 에러는 나지 않으나 상수의 의미가 사라지므로 final로 사용할 것
- 생성자를 통해 값을 초기화할 수 있음
- 생성자
    - private만 가능 → 생성자를 enum 클래스 내부에서만 사용할 수 있음

        ![Untitled 1](https://user-images.githubusercontent.com/87421893/173608540-cf988ff2-e3b9-4890-921d-f592ae33457d.png)
        
        ![스크린샷_2022-06-12_오후_8 19 09](https://user-images.githubusercontent.com/87421893/173608581-9cfee3cc-bdc6-46cc-b281-e6a976ac74c8.png)
        
    - enum 객체 선언 시 생성자 사용해서 객체를 생성함

## 2. 메소드

- 메소드를 선언해서 enum 객체가 사용할 수 도 있음
    - 각 enum 객체가 각각 다른 동작을 하고 반드시 구현하도록 하려면 `추상 메소드`를 추가해서 구현하면 됨
    
    ```java
    public enum Operation {
        PLUS('+') {
            @Override
            int operate(int left, int right) {
                return left + right;
            }
        },
        MINUS('-') {
            @Override
            int operate(int left, int right) {
                return left - right;
            }
        },
        MULTIPLY('*') {
            @Override
            int operate(int left, int right) {
                return left * right;
            }
        },
        DIVIDE('/') {
            @Override
            int operate(int left, int right) {
                if (right == 0) {
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                }
                return left / right;
            }
        };
    
        private final char operationSign;
    
        Operation(char operationSign) {
            this.operationSign = operationSign;
        }
    
        public char getOperationSign() {
            return operationSign;
        }
    
        abstract int operate(int left, int right);
    }
    ```
    
- enum 클래스는 java.lang.Enum 클래스의 상속을 받고 `다른 클래스의 상속을 받을 수 없음`
    
    ![스크린샷_2022-06-14_오후_11 45 39](https://user-images.githubusercontent.com/87421893/173608616-bcf49232-e7fd-4c2e-9319-ec16374df7c0.png)

# enum 메소드

1. values()
    - enum 클래스의 `모든 enum 객체`를 저장한 `배열`을 생성하여 리턴
        - 이 메소드는 java.lang.Enum 클래스에 있는 메소드가 아니라 **컴파일 시 추가되는 메소드**
        
        ![스크린샷_2022-06-12_오후_11 57 29](https://user-images.githubusercontent.com/87421893/173608656-28e7c094-248d-49cf-b822-b8c3894ef3bb.png)
        
        ```java
        InitializeEnum[] values = InitializeEnum.values();
                
        for (InitializeEnum value : values) {
            System.out.println("value = " + value);
        }
        ```
        
        ```java
        [출력]
        value = ONE
        value = TWO
        value = THREE
        ```
        
2. valueof()
    - 매개변수로 전달받은 문자열과 일치하는 `enum 객체를 리턴`
        
        ```java
        InitializeEnum findEnum = InitializeEnum.valueOf("ONE");
                
        System.out.println("findEnum = " + findEnum);
        ```
        
        ```java
        [출력]
        findEnum = ONE
        ```
        
3. ordinal()
    - enum 객체의 `선언된 순서(int)를 리턴`
        
        ```java
        int ordinal = InitializeEnum.THREE.ordinal();  // 순서는 0부터 시작
        
        System.out.println("ordinal = " + ordinal);
        ```
        
        ```java
        [출력]
        ordinal = 2
        ```
        
4. compareTo()
    - enum 상수의 순서 차이를 리턴
        
        ```java
        int gap = InitializeEnum.THREE.compareTo(InitializeEnum.TWO);
        
        System.out.println("gap = " + gap);
        ```
        
        ```java
        [출력]
        gap = 1
        ```
        
    
    <aside>
    ❗ enum의 ordinal(), compareTo() 같이 enum이 선언된 순서를 사용하는 데이터는 사용하지 마라!!
    → enum에 데이터가 추가되거나 삭제되면 엄청난 side effect가 발생할 수 있다.
    
    </aside>
    
5. name() & toString()
    - 둘 다 enum 객체 선언 시 이름을 리턴
        
        ```java
        String nameMethod = InitializeEnum.ONE.name();
        String toStringMethod = InitializeEnum.ONE.toString();
        
        System.out.println("nameMethod = " + nameMethod);
        System.out.println("toStringMethod = " + toStringMethod);
        ```
        
        ```java
        [출력]
        nameMethod = ONE
        toStringMethod = ONE
        ```
        
    - toString() 메소드는 오버라이딩 할 수 있지만 name() 메소드는 오버라이딩 불가능함
        - 문자열로 출력 시 커스텀하고 싶으면 toString() 메소드를 오버라이딩 해야함
        
        ![Untitled 2](https://user-images.githubusercontent.com/87421893/173608689-afd3a40e-b58d-46b9-b95f-2ca398fdaf60.png)
        

# java.lang.Enum

> enum 클래스가 반드시 상속받아야 하는 클래스
> 
- java.lang.Enum 클래스를 상속받기 때문에 다른 클래스를 상속받을 수 없음

## 1. 생성자

```java
protected Enum(String name, int ordinal) {
    this.name = name;
    this.ordinal = ordinal;
}
```

- 컴파일러에서 자동으로 호출되는 생성자
    - 개발자가 직접 이 생성자를 호출할 수는 없음

## 2. 메소드

![스크린샷_2022-06-12_오후_9 43 50](https://user-images.githubusercontent.com/87421893/173608715-6c44c323-3d56-4728-9d3b-a854a40444c1.png)

- Object 클래스의 메소드
    - `오버라이딩 할 수 없는` 메소드
        1. clone() - `개발자가 사용하지 말 것`
        2. finalize() - `개발자가 사용하지 말 것`
        3. hashCod() - 사용 O
        4. equals() - 사용 O
            - clone()을 제외한 3개는 final
    - `오버라이딩 가능한 메소드`
        - **toString()** → 유일하게 가능
- Enum 메소드
    - valueOf()
    - ordinal()
    - name()
    - compareTo()
    - getDeclaringClass()
        - enum 객체가 선언된 enum 클래스를 리턴

# EnumSet

> Enum을 위해 고안된 틀별한 Set 인터페이스 구현체
> 
- 사용 목적
    - enum 클래스를 담을 Set를 쉽게 정의하기 위해 사용
        - enum 상수 객체를 추가하거나 삭제하면 자동으로 반영됨
- enum 관련 다양한 편의 메소드가 있음
    1. allOf()
        - enum 클래스의 모든 enum 객체를 저장하는 Set 생성
        - enum 에 새로운 값이 추가되거나 이름이 바뀌어도 Set 관련 코드를 수정할 필요가 없음
    2. of()
        - Set를 구성하는 enum 객체를 직접 지정해서 생성
            - enum 에 선언된 순서를 바꾸거나 일부만 저장하고 싶은 경우 사용함
    3. complemetOf()
        - 특정 EnumSet 을 제외한 나머지로 구성되는 EnumSet을 생성
    4. range()
        - 범위를 지정해 EnumSet 생성
            - 이 때 지정 범위가 잘못된 경우 IllegalArgumentException이 발생함
- +@ EnumMap이라는 것도 존재함
    
    ```java
    public class EnumSetExample {
    
        public static void main(String[] args) {
            Set<BasicEnum> realSet = new HashSet<>();
    
            realSet.add(BasicEnum.ONE);
            realSet.add(BasicEnum.TWO);
            realSet.add(BasicEnum.THREE);
    
            EnumSet enumSet1 = EnumSet.allOf(BasicEnum.class);
            System.out.println("enumSet1 = " + enumSet1);
    
            EnumSet enumSet2 = EnumSet.of(BasicEnum.THREE, BasicEnum.TWO);
            System.out.println("enumSet2 = " + enumSet2);
    
            EnumSet enumSet3 = EnumSet.complementOf(enumSet2); // BasicEnum.ONE
            System.out.println("enumSet3 = " + enumSet3);
    
            EnumSet enumSet4 = EnumSet.range(BasicEnum.TWO, BasicEnum.THREE);
            System.out.println("enumSet4 = " + enumSet4);
    
            // 범위가 잘못되면 IllegalArgumentException 발생
    //        EnumSet enumSet5 = EnumSet.range(BasicEnum.THREE, BasicEnum.ONE);
    //        System.out.println("enumSet5 = " + enumSet5);
    
            // EnumMap 이라는 것도 있음
            EnumMap enumMap = new EnumMap(BasicEnum.class);
            enumMap.put(BasicEnum.ONE, 1);
            enumMap.put(BasicEnum.THREE, "삼");
            System.out.println("enumMap = " + enumMap);
        }
    }
    ```
    
    ```java
    [출력]
    enumSet1 = [ONE, TWO, THREE]
    enumSet2 = [TWO, THREE]
    enumSet3 = [ONE]
    enumSet4 = [TWO, THREE]
    enumMap = {ONE=1, THREE=삼}
    ```
