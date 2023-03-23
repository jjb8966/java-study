# 7주차 : 패키지

## package

> 클래스 & 인터페이스의 모음 단위
> 
- 클래스를 구분짓는 폴더 개념
- 자바는 패키지의 가장 상위 (root)에서 컴파일함
    - 해당 패키지에서 컴파일하는 것 X
- 패키지명이 java로 시작하면 안 됨
    - java로 시작하는 패키지는 자바 표준 api만 사용하도록 되어있음
- `FQCN` (Full Qualified Class Name)
    - 하나의 클래스를 완전히 표현하기 위해서는 정의된 패키지명과 클래스명을 모두 사용해야 함
        
        ex) java.lang.String
        
- **패키지 명명 규칙**
    - (일반적) 패키지 시작 이름
        - java
            - 자바의 기본 패키지
        - javax
            - 자바의 확장 패키지
        - org
            - 일반적으로 비영리단체 (오픈소스) 패키지
        - com
            - 일반적으로 영리단체 (회사) 패키지
    - 패키지명
        - 소문자만 사용
        - 자바 예약어 사용 x
        - 팀에서 정해진 개발 표준에 따름
- `Built-in Package`
    - 자바가 기본으로 제공하는 패키지 & 클래스
        - java.lang
            - 기본 자료형, 수학 연산 등이 정의되어 있는 패키지
            - 별도의 import 없이 사용 가능
        - java.util
            - 자료구조 관련 클래스가 있는 패키지
        - 기타
            - java.io
            - java.applet
            - java.awt
            - java.net

## import

> 다른 패키지에 있는 클래스를 사용하고자 할 때 사용
> 
- import 패키지명.*
    - 해당 패키지의 모든 클래스를 사용
- import static
    - 특정 클래스의 static 변수, static 메소드를 클래스 이름없이 사용하고 싶을 때 사용
- import가 필요없는 패키지
    - java.lang
    - 자신이 속한 패키지
- import 한 패키지의 하위 패키지는 import의 대상이 아님

## CLASSPATH

> JVM이 클래스 로딩 시 .class 파일을 찾는데 기준이 되는 파일 경로
> 
- .class 파일이 포함된 디렉토리와 파일을 콜론으로 구분한 목록
    - 윈도우 → `:`
    - 리눅스, mac → `;`
- CLASSPATH 사용하는 목적
    - **자바 파일이 설치되어 있는 경로까지 이동하지 않고** 어디서든 자바 프로그램을 실행하기 위해 사용
- classpath를 지정하기 위한 2가지 방법
    1. CLASSPATH 환경 변수 사용
        - 시스템 변수 설정에서 CLASSPATH 추가
            - JAVA_HOME/lib/tools.jar
        - 시스템 어디에서든 -cp 옵션을 사용하지 않고 자바 프로그램을 실행할 수 있음
            - 권장 x → OS 종속
    2. java runtime 시 -classpath (-cp) 옵션 사용
        - 컴파일 시 필요한 라이브러리 파일 경로를 지정해줌
        - javac -cp 파일경로 자바파일.java
            - 파일 경로에 있는 자바 파일을 컴파일해라
        - java -cp 파일경로 자바파일.java
            - 파일 경로에 해당하는 디렉토리를 참고하여 자바 파일을 실행해라
- 예제
    - ParentClass.java
        
        ```java
        package whiteship_study.week7_package.parent;
        
        public class ParentClass {
        
            public static void main(String[] args) {
                System.out.println("hi");
            }
        }
        ```
        
    - ParentWithoutPackage
        
        ```java
        public class ParentWithoutPackage {
        
        	public static void main(String[] args){
        		System.out.println("hihi");
        	}
        }
        ```
        
    - javac → java
        
        ![Untitled](7%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%91%E1%85%A2%E1%84%8F%E1%85%B5%E1%84%8C%E1%85%B5%200b32725bf38545c68140a99b69b62184/Untitled.png)
        
        - 패키지 선언이 되어있던 ParentClass는 실행됨
        - 패키지 선언이 되어있지 않던 ParentWithoutPackage는 실행됨
    - why?
        - .class 파일을 실행하기 위해서는 package의 경로가 포함되어야 하기 때문에
            
            ![Untitled](7%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%91%E1%85%A2%E1%84%8F%E1%85%B5%E1%84%8C%E1%85%B5%200b32725bf38545c68140a99b69b62184/Untitled%201.png)
            
            - java `whiteship_study.week7_package.parent.ParentClass`
                - .java파일이 있는 디렉토리가 아니라 root 디렉토리에서 실행해야 함
        - root 디렉토리 외 다른 디렉토리에서 자바 파일 실행
            - JVM이 .class 파일의 위치를 찾을 수 있도록 -cp 옵션으로 root 디렉토리의 경로를 지정해줘야 함 (java, javac 둘 다 가능)
                - 파일 경로 : `/Users/joojongbum/Desktop/project/kh/java-study/src`
                - 실행할 클래스 파일 : `whiteship_study.week7_package.parent.ParentClass`
            - javac 컴파일 시 -cp root 디렉토리 설정을 하면 root 디렉토리가 아니어도 자바 파일을 실행할 수 있음
                
                ![Untitled](7%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%91%E1%85%A2%E1%84%8F%E1%85%B5%E1%84%8C%E1%85%B5%200b32725bf38545c68140a99b69b62184/Untitled%202.png)
                
- 클래스로더 & classpath
    - 클래스로더는 런타임 시 $CLASSPATH 환경변수를 호출해 해당 디렉토리의 클래스 파일을 로딩함
        
        ![Untitled](7%E1%84%8C%E1%85%AE%E1%84%8E%E1%85%A1%20%E1%84%91%E1%85%A2%E1%84%8F%E1%85%B5%E1%84%8C%E1%85%B5%200b32725bf38545c68140a99b69b62184/Untitled%203.png)
        
        - Bootstrap Class Loader
            - jre/lib/rt.jar에 담긴 JDK 클래스 파일을 로딩
                - String, Object 같은 클래스가 메모리에 로딩
        - Extension Class Loader
            - jre/lib/ext 디렉토리에 있는 클래스 파일을 로딩
        - `System Class Loader`
            - $CLASSPATH를 기준으로 우리가 만든 클래스 파일 로딩

## 접근 제어자 (Access Modifer)

> 멤버 필드, 메소드의 접근 범위를 정의하기 위해 사용
> 
- 종류 4가지
    1. public → `누구나` 접근 가능
    2. protected → `같은 패키지`or `상속받은 경우` 접근 가능
    3. package-private (default) → `같은 패키지 내` 접근 가능
    4. private → `해당 클래스 내` 접근 가능
- 클래스, 메소드, 인스턴스 변수, 클래스 변수 선언 시 사용
- 하나의 자바(.java) 파일에는 최대 하나의 public class만 존재할 수 있고 그 이름이 같아야 함.
    - 존재하지 않을 수 도 있음
        
        ```java
        //PublicClass.java
        class PublicClass {
            
            public static void main(String[] args) {}
        
            class PublicClass2 {}
        }
        ```
        

## Reference

[kill.og.kil.log](https://kils-log-of-develop.tistory.com/430)

[패키지](https://www.notion.so/ed8e346f88f54849a06ff968b1877ca5)

[7주차 과제 : 패키지](https://velog.io/@ljs0429777/7%EC%A3%BC%EC%B0%A8-%EA%B3%BC%EC%A0%9C-%ED%8C%A8%ED%82%A4%EC%A7%80)