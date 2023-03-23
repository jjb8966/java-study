# 2주차 : 자바 데이터 타입, 변수 그리고 배열

# 기본 자료형 (Primitive Type)

---

| 자료형 | 키워드 | 크기 | 기본값 | 범위 | 2^n 표현 |
| --- | --- | --- | --- | --- | --- |
| 정수 | byte | 1 byte | 0 | -128 ~ 127 | -2^7 ~ 2^7-1 |
| 정수 (문자) | char | 2 byte | \u0000 | 0 ~ 65,535(유니 코드)
’\u0000’ ~ ‘\uffff’ | 0 ~ 2^16-1 |
| 정수 | short | 2 byte | 0 | - 32,768 ~ 32,767  | -2^15 ~ 2^15-1 |
| 정수 | int | 4 byte | 0 | -21억 ~ 21억 | -2^31 ~ 2^31-1 |
| 정수 | long | 8 byte | 0 | 매우 큼 3rd | -2^63 ~ 2^63-1 |
| 실수 | float | 4 byte | 0.0 | 매우 큼 2nd |  |
| 실수 | double | 8 byte | 0.0 | 매우 큼 1st |  |
| 논리 | boolean | 1 byte | false | 1 (true) or 0 (false) |  |
- 초기화
    - 모든 자료형은 값을 지정하지 않으면 기본값이 저장됨
    - `지역 변수`로 `기본 자료형`을 사용할 때는 **반드시 초기화**를 해줘야 함
        
        ⇒ 초기화는 반드시 하는 것이 좋음
        

## 정수

- byte
    - 적은 메모리 공간에 많은 내용을 저장하기 위해 사용
- char
    - 양수만 존재
    - ASCII
        - 1byte 단위의 문자 - 알파벳, 숫자, 기호
        - 각 문자마다 고정된 번호가 할당됨 → 어떤 환경에서도 같은 값
        - 자바는 2byte의 Unicode를 사용함 → 한글을 표현할 수 있음
            - 1byte 아스키코드 + @
    - 초기화 방법
        1. ‘ ’
        2. \u + 16진수
        3. 유니코드 번호 지정
    - special escape character
        - \b : 백스페이스
        - \t : 탭
        - \n : new line
        - \f : form feed
        - \r : 캐리지 리턴
        - \" : 쌍따옴표
        - \' : 따옴표
        - \\ : 역슬래시
- short & int & long
    - 일반적으로 정수는 int를 사용
        1. 기본 연산 단위가 4byte
        2. 21억 넘어가는 수를 잘 쓰지 않음 → 넘는 경우 long
        3. byte, short는 int로 `암시적 형변환`이 발생
        
        ⇒ 21억보다 큰 수를 다뤄야 할 경우 long 사용함
        

## 실수 `보충 필요`

- 돈 계산 시스템같은 정확한 계산이 필요한 부분에서는 float, double을 사용하지 않음
    - 32bit, 64bit로 제공할 수 있는 범위를 넘어서면 값의 정확성을 보장하지 못하기 때문
    - 대신 java.math.BigDecimal 클래스를 사용

## boolean

- true or false

# 참조 자료형 (Reference Type)

---

> 기본 자료형을 제외한 나머지 자료형
> 
- 기본 자료형과의 차이점
    - `초기화`하는 방식이 다름
        - 기본 자료형 : 리터럴을 그대로 적어줌
        - 참조 자료형 : `new`를 통해 객체를 생성하여 초기화
            - String은 참조 자료형이지만 new를 사용하지 않고 바로 값을 입력하여 초기화 할 수 있음
    - 참조 자료형의 변수에는 값이 저장되어 있는게 아니라 `객체의 주소`가 저장되어 있음
        - 비교 연산자를 이용하여 비교하면 객체의 주소를 비교하기 때문에 같은 의미를 가진 객체라도 다르다고 판단
        - equals(), hashcode()를 오버라이딩하여 같은 의미의 객체를 비교할 수 있음
- 생성자
    - `new`를 통해 객체를 만들어 줌
    - `기본 생성자`는 클래스 내 어떤 생성자도 정의되어 있지 않으면 `컴파일 시 자동`으로 생성됨
    - 만약 클래스 내 매개변수를 갖는 생성자가 정의되어 있으면 기본 생성자는 자동 만들어지지 않음. 직접 선언해야 함
    - 생성자를 `여러 개` 정의할 수 있어서 알고 있는 정보가 다를 때 적절한 객체를 만들수 있음
        
        <aside>
        💡 DTO (Data Transfer Object)
        | 속성들로만 이루어진 클래스
        - 여러 속성들을 하나의 클래스에 담아 (다른 서버로) 전달하기 위해 사용
        - 여러 속성 중 일부만 알고 있을 경우 다양한 생성자를 통해 객체를 생성함
        - VO (Value Object)는 DTO와 거의 유사하지만 데이터를 담아 두기 위한 목적으로만 사용함 (DTO에 포함된 개념)
        
        </aside>
        

# 상수

---

> 변할 수 없는 수
> 

## 1.리터럴 (Literal)

- 종류
    1. 정수
        
        ex. 100
        
    2. 실수
        
        ex. 1.24
        
    3. 문자
        
        ex. ‘a’, ‘가’
        
    4. 문자열
        
        ex. “자바 스터디”
        
    5. 불리언
        - true, false
- 특징
    - 리터럴은 `operand stack`에 일시적으로 `적재`되었다가 그 값을 `변수에 저장`하고 `메모리를 해제`함
    1. 정수
        - 기본적으로 `4byte` 크기로 stack에 저장
        - byte, char, short는 4byte 이하의 메모리를 필요로 하므로 필요한 만큼만 저장
            - ex) short → 앞에 2byte를 떼고 뒤에 2byte만 변수에 저장
        - 8byte인 `long`을 저장하기 위해서 리터럴 뒤에 `접미사 L`을 붙여 8byte의 stack 공간을 할당해 달라고 명시해야 함
    2. 실수
        - 기본적으로 `8byte` 크기로 stack에 저장
        - 4byte인 `float`를 저장하기 위해서 리터럴 뒤에 `접미사 F`을 붙여 4byte의 stack 공간을 할당해 달라고 명시해야 함
            
            ![출처 : [https://www.codelatte.io/courses/java_programming_basic/U4QLQ40D1OO82S93](https://www.codelatte.io/courses/java_programming_basic/U4QLQ40D1OO82S93)](2%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8C%E1%85%A1%E1%84%87%E1%85%A1%20%E1%84%83%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%90%E1%85%A5%20%E1%84%90%E1%85%A1%E1%84%8B%E1%85%B5%E1%86%B8,%20%E1%84%87%E1%85%A7%E1%86%AB%E1%84%89%E1%85%AE%20%E1%84%80%E1%85%B3%E1%84%85%E1%85%B5%E1%84%80%E1%85%A9%20%E1%84%87%E1%85%A2%E1%84%8B%E1%85%A7%E1%86%AF%203dcdfe4c31ce4f83b131b438630075b6/Untitled.png)
            
            출처 : [https://www.codelatte.io/courses/java_programming_basic/U4QLQ40D1OO82S93](https://www.codelatte.io/courses/java_programming_basic/U4QLQ40D1OO82S93)
            

## 2.심볼릭 상수

- `final` 키워드로 선언한 변수
    
    ```java
    final NUMBER = 1;
    ```
    
- 참고 - [static, final, static final](https://www.notion.so/static-final-static-final-2b81416e30a944eeb00c4f4b798f272b)

# 변수

---

> 다양한 값이 대입될 수 있는 수
> 
- 변수도 메모리를 할당 받아 사용
- 사용자가 변수의 메모리를 몰라도 사용할 수 있는 이유는 JVM이 알아서 처리해주기 때문
- 저장되는 `값(데이터)의 종류`에 따라 다양한 변수 `자료형` 있음
    
    ![출처 : 자바의 신 1권](2%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8C%E1%85%A1%E1%84%87%E1%85%A1%20%E1%84%83%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%90%E1%85%A5%20%E1%84%90%E1%85%A1%E1%84%8B%E1%85%B5%E1%86%B8,%20%E1%84%87%E1%85%A7%E1%86%AB%E1%84%89%E1%85%AE%20%E1%84%80%E1%85%B3%E1%84%85%E1%85%B5%E1%84%80%E1%85%A9%20%E1%84%87%E1%85%A2%E1%84%8B%E1%85%A7%E1%86%AF%203dcdfe4c31ce4f83b131b438630075b6/IMG_77DA3F38AFBF-1.jpeg)
    
    출처 : 자바의 신 1권
    

## 선언 & 초기화 & 스코프(라이프 타임)

```java
public class VariableType {
	int 인스턴스_변수;              // 인스턴스 변수 선언
	static int 클래스_변수 = 100;  // 클래스 변수 선언 및 초기화
	
	voit method(int 매개변수) {
			int 지역변수 = 1;
	}
}
```

- 스코프(영역)
    
    > 변수를 사용할 수 있는 범위
    > 
- 라이프타임
    
    > 변수가 메모리에 남아있는 시간
    > 
- 변수의 종류
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

# 변수의 메모리 할당

[https://www.codelatte.io/courses/java_programming_basic/IGO4YNAECLV8MSVF](https://www.codelatte.io/courses/java_programming_basic/IGO4YNAECLV8MSVF)

![Untitled](2%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8C%E1%85%A1%E1%84%87%E1%85%A1%20%E1%84%83%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%90%E1%85%A5%20%E1%84%90%E1%85%A1%E1%84%8B%E1%85%B5%E1%86%B8,%20%E1%84%87%E1%85%A7%E1%86%AB%E1%84%89%E1%85%AE%20%E1%84%80%E1%85%B3%E1%84%85%E1%85%B5%E1%84%80%E1%85%A9%20%E1%84%87%E1%85%A2%E1%84%8B%E1%85%A7%E1%86%AF%203dcdfe4c31ce4f83b131b438630075b6/Untitled%201.png)

---

1. 기본 자료형 변수 (정적 변수 제외)
    1. 메소드 호출 시 stack frame이 stack memory로 push됨
    2. 메소드의 지역 변수의 리터럴은 operand stack에 일시적으로 저장되었다가 그 값이 local variables array에 저장됨
    3. 매개 변수와 리턴값이 저장된 변수도 local variables array에 저장됨
    4. 메소드의 실행이 끝나면 local variables array에 저장된 리턴값을  operand stack에 push한 후 pop하여 frame data에 저장하고 호출한 메소드에게 넘겨줌
    5. 메소드 실행이 종료되면 해당 메소드의 stack frame을 stack memory에서 pop함

![Untitled](2%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8C%E1%85%A1%E1%84%87%E1%85%A1%20%E1%84%83%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%90%E1%85%A5%20%E1%84%90%E1%85%A1%E1%84%8B%E1%85%B5%E1%86%B8,%20%E1%84%87%E1%85%A7%E1%86%AB%E1%84%89%E1%85%AE%20%E1%84%80%E1%85%B3%E1%84%85%E1%85%B5%E1%84%80%E1%85%A9%20%E1%84%87%E1%85%A2%E1%84%8B%E1%85%A7%E1%86%AF%203dcdfe4c31ce4f83b131b438630075b6/Untitled%202.png)

![Untitled](2%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8C%E1%85%A1%E1%84%87%E1%85%A1%20%E1%84%83%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%90%E1%85%A5%20%E1%84%90%E1%85%A1%E1%84%8B%E1%85%B5%E1%86%B8,%20%E1%84%87%E1%85%A7%E1%86%AB%E1%84%89%E1%85%AE%20%E1%84%80%E1%85%B3%E1%84%85%E1%85%B5%E1%84%80%E1%85%A9%20%E1%84%87%E1%85%A2%E1%84%8B%E1%85%A7%E1%86%AF%203dcdfe4c31ce4f83b131b438630075b6/Untitled%203.png)

1. 참조 자료형 변수
    - `인스턴스`(배열 포함) & `상수 문자열`은 힙에 저장됨
    - 참조되지 않는 인스턴스는 Garbage Collector에 의해 제거됨 (메모리 할당 해제 )
    - String
        - `리터럴`로 String 객체 생성
            - string constant pool에 저장
            - 같은 값을 가지는 String 객체는 string constant pool에서 재사용하기 때문에 같은 객체임
        - `new` 생성자를 통해 String 객체 생성
            - heap 영역에 저장됨
            - 같은 값을 가지는 객체라도 heap 영역의 서로 다른 주소에 저장되는 다른 객체임
        
        <aside>
        💡 그림에서
        String text → heap에 저장
        String name,dog → string constant pool에 저장
        
        </aside>
        
    
    ![Untitled](2%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8C%E1%85%A1%E1%84%87%E1%85%A1%20%E1%84%83%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%90%E1%85%A5%20%E1%84%90%E1%85%A1%E1%84%8B%E1%85%B5%E1%86%B8,%20%E1%84%87%E1%85%A7%E1%86%AB%E1%84%89%E1%85%AE%20%E1%84%80%E1%85%B3%E1%84%85%E1%85%B5%E1%84%80%E1%85%A9%20%E1%84%87%E1%85%A2%E1%84%8B%E1%85%A7%E1%86%AF%203dcdfe4c31ce4f83b131b438630075b6/Untitled%204.png)
    

> 출처 : [https://www.codelatte.io/courses/java_programming_basic/IGO4YNAECLV8MSVF](https://www.codelatte.io/courses/java_programming_basic/IGO4YNAECLV8MSVF)
> 

## static 메소드에서 인스턴스 변수를 참조하지 못하는 이유

- static 메소드가 메모리에 올라오는 시점 때문!

# 타입 변환 (형 변환)

> 기존의 자료형에서 다른 자료형으로 변환하는 것
> 

![출처 : [https://to-paz.tistory.com/275](https://to-paz.tistory.com/275)](2%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8C%E1%85%A1%E1%84%87%E1%85%A1%20%E1%84%83%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%90%E1%85%A5%20%E1%84%90%E1%85%A1%E1%84%8B%E1%85%B5%E1%86%B8,%20%E1%84%87%E1%85%A7%E1%86%AB%E1%84%89%E1%85%AE%20%E1%84%80%E1%85%B3%E1%84%85%E1%85%B5%E1%84%80%E1%85%A9%20%E1%84%87%E1%85%A2%E1%84%8B%E1%85%A7%E1%86%AF%203dcdfe4c31ce4f83b131b438630075b6/Untitled%205.png)

출처 : [https://to-paz.tistory.com/275](https://to-paz.tistory.com/275)

## Promotion (=암시적 형 변환)

> 변환할 타입을 써주지 않아도 자동으로 형 변환되는 것
> 

```java
int a = 10;
long b = a;  // 암시적 형 변환
float c = b; // float는 4byte지만 값의 표현범위가 더 크기 때문에 long-> float는 암시적 형 변환 가능
```

- `작은 데이터 타입 → 큰 데이터 타입`으로 형 변환 하는 경우
- 자동으로 형 변환되는 기준은 메모리 공간의 크기가 아니라 `값의 표현 범위`임
- `byte 패딩`을 `추가`하여 형 변환
    
    ![출처 : [https://www.codelatte.io/courses/java_programming_basic/24R2ILWI9ALTC0IX](https://www.codelatte.io/courses/java_programming_basic/24R2ILWI9ALTC0IX)](2%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8C%E1%85%A1%E1%84%87%E1%85%A1%20%E1%84%83%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%90%E1%85%A5%20%E1%84%90%E1%85%A1%E1%84%8B%E1%85%B5%E1%86%B8,%20%E1%84%87%E1%85%A7%E1%86%AB%E1%84%89%E1%85%AE%20%E1%84%80%E1%85%B3%E1%84%85%E1%85%B5%E1%84%80%E1%85%A9%20%E1%84%87%E1%85%A2%E1%84%8B%E1%85%A7%E1%86%AF%203dcdfe4c31ce4f83b131b438630075b6/Untitled%206.png)
    
    출처 : [https://www.codelatte.io/courses/java_programming_basic/24R2ILWI9ALTC0IX](https://www.codelatte.io/courses/java_programming_basic/24R2ILWI9ALTC0IX)
    

## Casting (=명시적 형 변환)

> 변환할 타입을 명시해 줘야하는 것
> 

```java
long a = 100000;
int b = (int) a;       // 10000은 int의 표현 범위 내에 있으므로 데이터 손실 x
short c = (short) b;   // short의 표현 범위를 넘어감으로 데이터 손실 o

// a = 100000
// b = 100000
// c = -31072

// 실수 -> 정수
float d = 12.42F;
int e = (int) d;   // 데이터 손실 x

float f = 10000000000.0F; // 100억
int g = (int) f;   // int의 표현 범위를 넘어감으로 데이터 손실 o

// e = 12
// g = [21억~~~] -> int 최대값
```

- `큰 데이터 타입 → 작은 데이터 타입`으로 형 변환 하는 경우
- `데이터의 손실`이 발생할 수 있다는 것을 인지한다는 의미로 명시
- `byte 패딩`을 `제거`하여 형 변환
    
    ![출처 : [https://www.codelatte.io/courses/java_programming_basic/24R2ILWI9ALTC0IX](https://www.codelatte.io/courses/java_programming_basic/24R2ILWI9ALTC0IX)](2%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8C%E1%85%A1%E1%84%87%E1%85%A1%20%E1%84%83%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%90%E1%85%A5%20%E1%84%90%E1%85%A1%E1%84%8B%E1%85%B5%E1%86%B8,%20%E1%84%87%E1%85%A7%E1%86%AB%E1%84%89%E1%85%AE%20%E1%84%80%E1%85%B3%E1%84%85%E1%85%B5%E1%84%80%E1%85%A9%20%E1%84%87%E1%85%A2%E1%84%8B%E1%85%A7%E1%86%AF%203dcdfe4c31ce4f83b131b438630075b6/Untitled%207.png)
    
    출처 : [https://www.codelatte.io/courses/java_programming_basic/24R2ILWI9ALTC0IX](https://www.codelatte.io/courses/java_programming_basic/24R2ILWI9ALTC0IX)
    

<aside>
💡 연산 시 형 변환

- 정수끼리 연산 시 `int`(4byte)로 암시적 형 변환

```java
byte a = 1;
byte b = 2;

// a + b를 하면 자동으로 int로 형 변환하여 계산 후 저장
int sumInt = a + b;

// byte 자료형으로 저장하려면 명시적 형 변환을 해줘야 함
byte sumByte = (byte) sum
```

- 정수와 실수 간 연산 시 `실수형`으로 암시적 형 변환

```java
int a = 1;
float b = 2.0F;

// a + b를 하면 자동으로 float로 형 변환하여 계산 후 저장
float sum = a + b;

```

</aside>

# 배열

---

> 한 가지 타입, 한 가지 변수에 여러 개의 데이터를 저장하는 방법
> 
- 선언
    
    ```java
    // 1차원 배열
    int[] oneDimension1 = {1, 2, 3, 4};
    
    int[] oneDimension2 = new int[]{1, 2, 3, 4};
            
    int[] oneDimension3 = new int[4];  // 일반적
    
    // oneDimension3 = {1, 2, 3, 4} -> 컴파일 에러. 중괄호를 이용한 초기화는 선언부에서만 가능
            
    for (int i = 0; i < 4; i++) {
        oneDimension3[i] = i + 1;
    }
    
    // 2차원 배열
    int[] twoDimension = new int[2][2];
    int[] twoDimension = new int[2][];
    // int[] towDimension = new int[][2]; -> 컴파일 에러
    ```
    
- 배열 변수(oneDimension)는 참조 자료형
    - new를 통해 초기화 할 수 있음
    - `주소값`을 저장
        - 배열의 첫 번째 원소가 저장된 주소값을 저장
- 배열은 지역 변수라도 배열의 크기만 정해주면 컴파일 에러가 나지 않음 ↔ 기본 자료형 지역변수
    - 기본 자료형 - 기본값으로 초기화
    - 참조 자료형 - `null`로 초기화 → 웬만하면 초기화 해주는게 좋음
- 배열을 그냥 출력하면?
    - 기본 자료형
        - `[` + `알파벳` + @고유번호
        - 알파벳은 기본 자료형의 앞 글자(대문자)
            
            ![출처 : 자바의 신 1권](2%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8C%E1%85%A1%E1%84%87%E1%85%A1%20%E1%84%83%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%90%E1%85%A5%20%E1%84%90%E1%85%A1%E1%84%8B%E1%85%B5%E1%86%B8,%20%E1%84%87%E1%85%A7%E1%86%AB%E1%84%89%E1%85%AE%20%E1%84%80%E1%85%B3%E1%84%85%E1%85%B5%E1%84%80%E1%85%A9%20%E1%84%87%E1%85%A2%E1%84%8B%E1%85%A7%E1%86%AF%203dcdfe4c31ce4f83b131b438630075b6/Untitled%208.png)
            
            출처 : 자바의 신 1권
            
    - 참조 자료형
        - `[L` + `패키지명.클래스명;` + @고유번호
        - [L : 해당 객체가 배열임을 알려줌
            
            ![출처 : 자바의 신 1권](2%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8C%E1%85%A1%E1%84%87%E1%85%A1%20%E1%84%83%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%90%E1%85%A5%20%E1%84%90%E1%85%A1%E1%84%8B%E1%85%B5%E1%86%B8,%20%E1%84%87%E1%85%A7%E1%86%AB%E1%84%89%E1%85%AE%20%E1%84%80%E1%85%B3%E1%84%85%E1%85%B5%E1%84%80%E1%85%A9%20%E1%84%87%E1%85%A2%E1%84%8B%E1%85%A7%E1%86%AF%203dcdfe4c31ce4f83b131b438630075b6/Untitled%209.png)
            
            출처 : 자바의 신 1권
            
- 배열의 단점
    - 무조건 배열 선언 시 크기를 지정해야 함
    - 이런 단점을 보완한 것이 `Collection`
- 배열의 메모리 할당
    
    > 배열 변수 + 배열 공간(배열 인스턴스)
    > 
    - `배열 변수` : 배열 공간의 `첫 번째 주소값`을 저장하는 변수
    - `배열 인스턴스` : 실제로 배열의 데이터를 저장하는 메모리 → `heap`에 저장
        
        ⇒ 배열의 첫 번째 주소값과 인덱스만 알면 배열 인스턴스에 접근할 수 있음
        

<aside>
💡 1차원 배열

![Untitled](2%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8C%E1%85%A1%E1%84%87%E1%85%A1%20%E1%84%83%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%90%E1%85%A5%20%E1%84%90%E1%85%A1%E1%84%8B%E1%85%B5%E1%86%B8,%20%E1%84%87%E1%85%A7%E1%86%AB%E1%84%89%E1%85%AE%20%E1%84%80%E1%85%B3%E1%84%85%E1%85%B5%E1%84%80%E1%85%A9%20%E1%84%87%E1%85%A2%E1%84%8B%E1%85%A7%E1%86%AF%203dcdfe4c31ce4f83b131b438630075b6/Untitled%2010.png)

</aside>

<aside>
💡 2차원 배열

![Untitled](2%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%8C%E1%85%A1%E1%84%87%E1%85%A1%20%E1%84%83%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%90%E1%85%A5%20%E1%84%90%E1%85%A1%E1%84%8B%E1%85%B5%E1%86%B8,%20%E1%84%87%E1%85%A7%E1%86%AB%E1%84%89%E1%85%AE%20%E1%84%80%E1%85%B3%E1%84%85%E1%85%B5%E1%84%80%E1%85%A9%20%E1%84%87%E1%85%A2%E1%84%8B%E1%85%A7%E1%86%AF%203dcdfe4c31ce4f83b131b438630075b6/Untitled%2011.png)

</aside>

> 출처 : [https://www.codelatte.io/courses/java_programming_basic/CO1EE061RIDJSPNL](https://www.codelatte.io/courses/java_programming_basic/CO1EE061RIDJSPNL)
> 

# 타입추론 (var)

---

> 변수의 자료형을 코드에 명시하지 않아도 컴파일러가 컴파일 시 자료형을 유추하여 컴파일 하는 것
> 
- 자바 1.5의 제네릭과 1.8의 람다에서 타입추론이 사용되기 시작
- 자바 10부터 `var`가 추가됨
    - `지역변수`로만 사용 가능
    - `반드시 초기화`를 해야하며 null이 될 수 없음
    
    ```java
    var a = "hi";  // String a = "hi";
    var b = 100;   // int b = 100;
    ```