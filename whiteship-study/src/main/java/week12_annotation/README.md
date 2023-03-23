# 12주차 : 어노테이션

# JavaDoc

> Java에서 API 문서를 HTML 형식으로 생성해주는 도구
>
- 다른 API를 하이퍼링크를 통해 접근할 수 있음
- 사용 목적
    - 개발자들이 소스 코드에 대한 별도의 문서를 작성하지 않고 소스코드와 문서를 하나의 파일로 관리하기 위해 사용함
- 생성 방법
    - Java 코드 → 어노테이션
    - IDE → /**

      ⇒ javadoc.exe 실행하면 html 파일 생성됨


## JavaDoc Tag

- JavaDoc 문서를 작성하기 위해 필요한 tag
- 종류
    - @author
    - @deprecated
    - @exception
    - @param
    - @return
    - @see
    - @serial
    - @serialDate
    - @serialField
    - @since
    - @throws
    - @version

# 어노테이션

> 컴파일 & 런타임 시 컴파일러에게 코드를 `어떻게 컴파일하고 처리할 것인지` 알려줌
>

<aside>
⭐ 백기선님 라이브 스터디
    
어노테이션은 주석이다.

런타임 시 필요한 중요한 정보는 안들어간다.

컴파일러 수준에서 사용하는 정적인 정보들이다. 그 정보들로 문서를 만들수도 있다.

따라서 어노테이션에는 변수 자체가 들어갈 수 없다. 정적인 데이터이기 때문에 (static final은 들어갈 수 있음)

</aside>

- 코드(데이터)에 대한 정보 제공하는 메타 데이터
- 소스 코드 안에 다른 프로그램을 위한 정보를 미리 약속된 형식으로 포함시킨 것
- 주석처럼 소스 코드에는 영향을 주지 않으면서 정보를 제공할 수 있음
- 어노테이션 관련 클래스는 java.lang.annotation 패키지에 선언되어 있음
- 어노테이션은 **상속 불가**
- 용도
    1. 코드 `문법 에러 체크`를하도록 정보를 제공 (제약 사항 선언)

       ex) @Override, @Deprecated, @NotNull

    2. 빌드 툴이 `코드를 자동 생성`할 수 있도록 정보를 제공

       ex) Lombok - @Getter @Setter

    3. 런타임 시 `특정 기능을 수행`하도록 정보를 제공
- 사용하는 이유
    - 어노테이션이 없을 때는 `프로그램 관련 설정`을 **XML**이나 **properies**라는 파일에 지정했음
        - 설정이 복잡해지면 파일이 커지고 복잡해져 **이해하기 힘든 단점**이 있었음
    - 어노테이션을 사용하면서 `설정이 필요한 위치`에 관련 `설정이 위치`하기 때문에 `가독성`이 매우 좋아짐
    - 추가로 `롬복(lombok)`이라는 툴을 이용하면 개발자가 필요한 작업을 어노테이션만으로 처리할 수 있기 때문에 `코드를 줄이고` `개발을 편하게` 할 수 있게 해줌

# 표준 어노테이션

- 자바 코드에서 사용하기 위해 정해져 있는 어노테이션

## @Override

> 오버라이딩 한 메소드 앞에 붙이는 어노테이션
>
- 어떤 메소드가 오버라이딩 되었는지 알아보기 쉬움
- 오버라이딩 할 메소드와 메소드 시그니처가 다른 경우 컴파일 에러남

  → 제대로 오버라이딩 되었는지 확인할 수 있음


## @Deprecated

> 자바 버전이 올라가면서 더 이상 사용되지 않는 클래스, 메소드에 붙이는 어노테이션
>
- Deprecated가 선언된 것을 사용하면 -Xlint:deprecation 옵션을 사용하라는 메세지가 나옴
    - 해당 옵션으로 컴파일하면 `경고`와 함께 정상적으로 컴파일 됨 (에러x)
- 불필요한 클래스나 메소드를 당장 삭제하면 참조하고 있는 부분에서 문제가 생길 수 있기 때문에 `하위 호환성`을 위해 사용함

## @SuppressWarnings

> 컴파일러에게 경고가 발생하지 않도록 명시하기 위해 사용하는 어노테이션
>

## @FunctionalInterface

> Functional Interface임을 명시하는 어노테이션
>
- Functional Interface
    - 구현해야 할 추상 메소드가 1개인 인터페이스
- 해당 어노테이션을 인터페이스에 붙이면 추상 메소드가 1개임을 보장해줌
    - 아닐 시 컴파일 에러 발생

## + 메타 어노테이션

# 메타 어노테이션

> 어노테이션을 위한 어노테이션
>

<aside>
❗ 개발자가 직접 어노테이션을 정의하고 사용할 일은 많지 않으므로 보고 이해할 수 있을 정도로만 파악하자

</aside>

## @Target

> 어노테이션 대상을 지정
>
- ElementType

    ```java
    public enum ElementType {
        /** Class, interface (including annotation type), or enum declaration */
        TYPE,
    
        /** Field declaration (includes enum constants) */
        FIELD,
    
        /** Method declaration */
        METHOD,
    
        /** Formal parameter declaration */
        PARAMETER,
    
        /** Constructor declaration */
        CONSTRUCTOR,
    
        /** Local variable declaration */
        LOCAL_VARIABLE,
    
        /** Annotation type declaration */
        ANNOTATION_TYPE,
    
        /** Package declaration */
        PACKAGE,
    
        /**
         * Type parameter declaration
         *
         * @since 1.8
         */
        TYPE_PARAMETER,
    
        /**
         * Use of a type
         *
         * @since 1.8
         */
        TYPE_USE,
    
        /**
         * Module declaration.
         *
         * @since 9
         */
        MODULE
    }
    ```

    - 만약 Target을 지정하지 않는다면?
        - 아무대나 사용할 수 있다.

## @Retension

> 어노테이션의 유지 시간(유지 정책) 지정
>
- 유지 정책 종류
    1. SOURCE
        - 소스 파일에만 존재
            - 컴파일 이후에 어노테이션 정보가 없어짐
                - 컴파일 이후로 그 정보를 쓰지 않겠다!
            - 바이트 코드에 존재하지 않음
                - 주석처럼 보이는 용으로 쓰려고 하는 것

                  ex) Override → 오버라이딩 한 메소드임을 명시하고 타입 체크를 해줌

        - 컴파일러에 의해 사용되는 어노테이션에 사용

          ex) @Override, @SuppressWarnings

    2. CLASS - `default`
        - 클래스 파일에 정보가 저장됨
            - 바이트코드에 어노테이션 정보가 포함되어 있음
            - but, JVM 로딩 시에는 어노테이션 정보가 누락됨 → 리플렉션을 사용할 수 없음
    3. RUNTIME
        - 클래스 파일에 정보가 저장됨
        - 실행 시 리플렉션을 통해 클래스 파일에 저장된 어노테이션 정보를 읽어서 처리함
        - 이 때부터 리플렉션이 가능함

    ```java
    public enum RetentionPolicy {
        /**
         * Annotations are to be discarded by the compiler.
         */
        SOURCE,
    
        /**
         * Annotations are to be recorded in the class file by the compiler
         * but need not be retained by the VM at run time.  This is the default
         * behavior.
         */
        CLASS,
    
        /**
         * Annotations are to be recorded in the class file by the compiler and
         * retained by the VM at run time, so they may be read reflectively.
         *
         * @see java.lang.reflect.AnnotatedElement
         */
        RUNTIME
    }
    ```


<aside>
⭐ SOURCE → CLASS → RUNTIME

</aside>

## @Documented

> 어노테이션에 대한 정보가 JavaDoc 문서로 포함되도록 함
>

## @Inherited

> 어노테이션이 자식 클래스에 상속되도록 함
>
- 부모 클래스에 있는 어노테이션을 자식 클래스에서도 동일하게 붙인 효과

## @Native

> 네이티브 메소드가 참조하는 상수 필드에 붙임
>

# 어노테이션 정의하는 방법

- @interface를 사용하여 선언
- 필드 (요소)
    - 리턴 타입이 있고 매개변수가 없는 `추상 메소드의 형태`
    - 무조건 public
        - 생략 시 자동으로 public이 붙음

      ![Untitled](https://user-images.githubusercontent.com/87421893/173610529-9231f96f-5966-4034-ba59-1fb41f3f415c.png)

    - String value() → `보충`

## 어노테이션 요소의 규칙

1. 요소의 타입은 기본형, String, enum, 어노테이션, class만 허용
2. () 내부에 `매개변수 선언 불가`
3. `예외 선언 불가`
4. 요소를 `타입 매개변수(제네릭)`로 정의 불가

## 선언한 어노테이션을 확인하는 방법

- 리플렉션 사용

    ```java
    @Target({ElementType.TYPE, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MyAnnotation {
        public int number();
    
        public String text();
    }
    ```

    ```java
    public class UseMyAnnotation {
    
        @MyAnnotation(number = 3, text = "hi")
        void sampleMethod() {
        }
    
        public static void main(String[] args) throws NoSuchMethodException {
            Method method = UseMyAnnotation.class.getDeclaredMethod("sampleMethod");
    
            MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
            int number = annotation.number();
            String text = annotation.text();
    
            System.out.println("입력받은 text를 number만큼 반복시키는 어노테이션");
            for (int i = 0; i < number; i++) {
                System.out.print(text);
            }
        }
    }
    ```

- 어노테이션 바이트 코드

    ```java
    
    public abstract @interface week12_annotation/basic/MyAnnotation 
    implements java/lang/annotation/Annotation {
    
      // compiled from: MyAnnotation.java
    
      @Ljava/lang/annotation/Target;(value={Ljava/lang/annotation/ElementType;.TYPE, Ljava/lang/annotation/ElementType;.METHOD})
    
      @Ljava/lang/annotation/Retention;(value=Ljava/lang/annotation/RetentionPolicy;.RUNTIME)
    
      // access flags 0x401
      public abstract number()I
    
      // access flags 0x401
      public abstract text()Ljava/lang/String;
    }
    ```

    - java/lang/annotation/Annotation 인터페이스를 구현함
- 어노테이션을 사용한 클래스의 바이트코드 (디컴파일 버전)

    ```java
    public class UseMyAnnotation {
        public UseMyAnnotation() {
        }
    
        @MyAnnotation(
            number = 3,
            text = "hi"
        )
        void sampleMethod() {
        }
    
        public static void main(String[] args) throws NoSuchMethodException {
            Method method = UseMyAnnotation.class.getDeclaredMethod("sampleMethod");
            MyAnnotation annotation = (MyAnnotation)method.getAnnotation(MyAnnotation.class);
            int number = annotation.number();
            String text = annotation.text();
            System.out.println("입력받은 text를 number만큼 반복시키는 어노테이션");
    
            for(int i = 0; i < number; ++i) {
                System.out.print(text);
            }
    
        }
    }
    ```

    - 메소드에 붙은 어노테이션의 정보를 저장하고 있음
- @Override 어노테이션
    - @Retention(`RetentionPolicy.*SOURCE*`)
        - 어노테이션 정보가 바이트코드에 남아있지 않음

  ![Untitled 1](https://user-images.githubusercontent.com/87421893/173610558-117a5b1c-9e27-4518-a840-115f297c1f61.png)

# 어노테이션 프로세서

> 소스코드 레벨에서 어노테이션 정보를 읽어 컴파일러가 컴파일 하는 중 새로운 코드를 생성하거나 기존의 코드를 변경할 수 있도록 해줌
>
- 클래스 (바이트코드) 생성 가능
- 소스 코드와 별개의 리소스 생성 가능
- 예시
    - Lombok - @Getter @Setter…
        - getter, setter를 만들어 줌
    - @Override
        - 컴파일러가 오버라이딩 타입 체크를 해줌
- 장점
    - 컴파일 시점에 조작하기 때문에 런타임 비용이 들지 않음

<aside>
⭐ ServiceLoader

- 인터페이스만 제공하고 구현체만 바꿔 끼울 때 사용

- 각 제조사에서 다양한 구현체(jar) 생성했다고 가정했을 때 ServiceLoader가 jar 파일 내에 해당 인터페이스에 대한 구현체를 가져와서 개발자에게 제공함

</aside>

# Reference

[12주차 : 애노테이션](https://www.notion.so/12-386f4cd47d37448fa0252d3ed22b45b7)

[애노테이션 프로세서 실습](https://www.notion.so/e0ec4fb75e1044fcbbf398fbb4480bc8)
