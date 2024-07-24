## 세션[1] 클래스와 데이터 (20240720)

정의

- 클래스에 정의한 변수들을 멤버 변수, 또는 필드라 한다.클래스에 정의한 변수들을 멤버 변수, 또는 필드라 한다.
- 클래스는 관례상 대문자로 시작하고 낙타 표기법을 사용한다.
예): Student , User , MemberService
- 클래스 : 사용자가 직접 정의하는 사용자 정의 타입을 만들기 위한설계도
- 객체 또는 인스턴스 : 설계도인 클래스를 사용해서 실제 메모리에 만들어진 실체
    
    student1 객체는 Student 클래스의 인스턴스다
    
    보통 둘을 구분하지 않음
    

객체 참조 

- 변수에 인스턴스를 저장하는건 인스턴스의 값이 아닌 참조값을 저장한다.
- 객체에 접근하려면 . (점, dot) 키워드를 사용
    
    ex)student1.name="학생1”
    

배열 참조 

- 배열에 저장된 인스턴스의 위치를 가리키는 참조값이 들어있을 뿐이다! 따라서 대입
( = )시에 인스턴스가 복사되는 것이 아니라 참조값만 복사된다

```java

      Student student = new Student();
      student.name = "han";
      student.age =  5;
      //Student[] students = new Student[]{student1, student2};
      //Student[] students = {student1, student2};

      List<Student> studentList = new ArrayList<Student>();
      // 인스턴스의 참조값을 저장하기에 배열에 같은 인스턴스 두개가 추가된다 
      studentList.add(student);
      studentList.add(student);
      System.out.println(studentList.get(0).toString()); // 5
      System.out.println(studentList.get(1).toString()); // 5
			// 배열에 추가하기전 인스턴스의 필드 값을 변경하면 배열안에 값도 모두 변경
      student.age = 12;
      System.out.println(studentList.get(0).toString());// 12 
      System.out.println(studentList.get(1).toString()); // 12

			// 배열
      Student student1 = studentList.get(0);
      student1.age = 20;
      System.out.println(studentList.get(0).toString());//20
      System.out.println(studentList.get(1).toString());//20
  }
  public static class Student{
      String name ;
      int age;

      @Override
      public String toString() {
          return name + " " + age ;
      }
  }
}
```

## 세션[2] 기본형, 참조형 (20240720)

- 변수의 데이터 타입을 가장 크게 보면 기본형과 참조형으로 분류할 수 있다. 사용하는 값을 변수에 직접 넣을 수 있는 기본형, 그리고 이전에 본 Student student1 과 같이 객체가 저장된 메모리의 위치를 가리키는 참조값을 넣을 수 있는 참조형으로 분류할 수 있다.
    - 기본형(Primitive Type): int , long , double , boolean 처럼 변수에 사용할 값을 직접 넣을 수 있는 데이터 타입을 기본형이라 한다.
        - 기본형 변수는 null 을 할당할 수 없지만, 참조형 변수는 null 을 할당할 수 있다.
        - 소문자 시작
    - 참조형(Reference Type): Student student1 , int[] students 와 같이 데이터에 접근하기 위한 참조(주소)를 저장하는 데이터 타입을 참조형이라 한다. 참조형은 객체 또는 배열에 사용된다.
        - 기본형 변수는 null 을 할당할 수 없지만, 참조형 변수는 null 을 할당할 수 있다.
        - 기본형을 제외한 나머지는 모두 참조형이다.
        - 클래스는 대문자 시작

**메서드** 

- 대원칙: 자바는 항상 변수의 값을 복사해서 대입한다.
- 기본형: 메서드로 기본형 데이터를 전달하면, 해당 값이 복사되어 전달된다. 이 경우, 메서드 내부에서 매개변수(파라미터)의 값을 변경해도, 호출자의 변수 값에는 영향이 없다.
- 참조형: 메서드로 참조형 데이터를 전달하면, 참조값이 복사되어 전달된다. 이 경우, 메서드 내부에서 매개변수(파라미터)로 전달된 객체의 멤버 변수를 변경하면, 호출자의 객체도 변경된다.
- 객체 선언, 초기화 메서드
    
    ```jsx
    static Student createStudent(String name, int age, int grade) {
    	 Student student = new Student(); // 인스턴스 생성
    	 student.name = name;// 초기화
    	 student.age = age;
    	 student.grade = grade;
    	 return student; // 참조값 반환 
     }
    ```
    

**변수와 초기화**

- 멤버 변수(필드): 클래스에 선언
    - 인스턴스의 멤버 변수는 인스턴스를 생성할 때 자동으로 초기화된다.
    - 숫자( int )= 0 , boolean = false ,String = null, 참조형 = null ( null 값은 참조할 대상이 없다는 뜻으로 사용된다.)
    - 개발자가 초기값을 직접 지정할 수 있다.
- 지역 변수: 메서드에 선언, 매개변수도 지역 변수의 한 종류이다
    - 지역 변수: 수동 초기화

```java
    public static void main(String[] args) {
        int a; // 선언
        a=10; // 초기화 이게 없으면 오류
        System.out.println(a); // 지역변수는 직접 초기화 해야한다
//
        int[] b ; // 아직 아무 참조값도 들어있지 않음
        b = new int[5]; // 이거 없으면 오류
        System.out.println(Arrays.toString(b)); // 0으로 채워짐

        Student student = new Student(); // 아직 멤버 변수를 초기화 하지 않았지만
        System.out.println(student.toString());// 0과 null로 초기화 되어있음
    }

    public static class Student{
        int age;
        String name;
        List<Integer> a;

        @Override
        public String toString() {
            return "Student{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    ", a=" + a +
                    '}';
        }
    }
    
10
[0, 0, 0, 0, 0]
Student{age=0, name='null', a=null}
```

**null**

- 아무도 참조하지 않는 인스턴스는 jvm의 가비지 컬랙션이 메모리에서 제거해줌

NullPointerException

- null에 .을 찍었을때 발생
- student.a 멤버변수가 null일때 이를 출력하면 null이 나오지만 .get()해서 값을 가져오려하면
    
    널 포인트 에러가 발생한다 
    

```java
        Student student = new Student(); // 아직 멤버 변수를 초기화 하지 않았지만
        System.out.println(student.toString());// 0과 null로 초기화 되어있음
        System.out.println(student.a.get(0)); // 널포인트에러 발생
    }

    public static class Student{
        int age;
        String name;
        List<Integer> a;

        @Override
        public String toString() {
            return "Student{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    ", a=" + a +
                    '}';
        }
```

**정리**

- 대원칙: 자바는 항상 변수의 값을 복사해서 대입한다.
자바에서 변수에 값을 대입하는 것은 변수에 들어 있는 값을 복사해서 대입하는 것이다.
기본형, 참조형 모두 항상 변수에 있는 값을 복사해서 대입한다. 기본형이면 변수에 들어 있는 실제 사용하는 값을 복사
해서 대입하고, 참조형이면 변수에 들어 있는 참조값을 복사해서 대입한다.
기본형이든 참조형이든 변수의 값을 대입하는 방식은 같다. 하지만 기본형과 참조형에 따라 동작하는 방식이 달라진다.
- 기본형 vs 참조형 - 기본
자바의 데이터 타입을 가장 크게 보면 기본형과 참조형으로 나눌 수 있다.
기본형을 제외한 나머지 변수는 모두 참조형이다. 클래스와 배열을 다루는 변수는, 참조형이다.
기본형 변수는 값을 직접 저장하지만, 참조형 변수는 참조(주소)를 저장한다.
기본형 변수는 산술 연산을 수행할 수 있지만, 참조형 변수는 산술 연산을 수행할 수 없다.
기본형 변수는 null 을 할당할 수 없지만, 참조형 변수는 null 을 할당할 수 있다.
- 기본형 vs 참조형 - 대입
기본형과 참조형 모두 대입시 변수 안에 있는 값을 읽고 복사해서 전달한다.
기본형은 사용하는 값을 복사해서 전달하고, 참조형은 참조값을 복사해서 전달한다! 이것이 중요하다. 실제 인스턴스가 복사되는 것이 아니다. 인스턴스를 가리키는 참조값을 복사해서 전달하는 것이다! 따라서 하나의 인스턴스
를 여러곳에서 참조할 수 있다.
헷갈리면 그냥 변수 안에 들어간 값을 떠올려보자. 기본형은 사용하는 값이, 참조형은 참조값이 들어있다! 변수에 어떤 값이 들어있든간에 그 값을 그대로 복사해서 전달한다.
- 기본형 vs 참조형 - 메서드 호출
메서드 호출시 기본형은 메서드 내부에서 매개변수(파라미터)의 값을 변경해도 호출자의 변수 값에는 영향이 없다.
메서드 호출시 참조형은 메서드 내부에서 매개변수(파라미터)로 전달된 객체의 멤버 변수를 변경하면, 호출자의객체도 변경된다.

## 세션[3] 객체지향프로그래밍 (20240722)

**객체 지향 프로그래밍**은 실제 세계의 사물이나 사건을 객체로 보고, 이러한 객체들 간의 상호작용을 중심으로 프
로그래밍하는 방식

- 객체는 속성(멤버변수),기능(메서드)로 구성

**절차 지향 프로그래밍**은 이름 그대로 절차를 지향한다. 쉽게 이야기해서 실행 순서를 중요하게 생각하는 방식이
다.

둘의 중요한 차이

- 절차 지향은 데이터와 해당 데이터에 대한 처리 방식이 분리되어 있다.
- 반면 객체 지향에서는 데이터와 그 데이터에 대한 행동(메서드)이 하나의 '객체' 안에 함께 포함되어 있다.

## 세션[4] 생성자 (20240722)

### 생성자가 필요한 이유

- 불필요한 반복
    
    ```java
    MemberInit member1 = new MemberInit();
    member1.name = "user1";
    member1.age = 15;
    member1.grade = 90;
    ```
    
- 생성자 사용
    
    ```java
    public class MemberInit {
        String name;
        int age;
        int grade;
    
        //추가
        void initMember(String name, int age, int grade) {
            this.name = name;
            this.age = age;
            this.grade = grade;
        }
    }
    
    MemberConstruct member1 = new MemberConstruct("user1", 15, 90);
    
    ```
    

### 생성자 규칙

- 생성자 이름은 클래스 이름과 같아야한다
- 생성자는 반환 타입이 없다

### 생성자 장점

- 중복 호출 제거
- 생성자를 반드시 호출해야한다 (필수 입력을 보장)

### 기본 생성자

- **클래스의 생성자가 없으면 자바가 기본 생성자를 자동으로 만들어줌**
    
    ```java
    MemberInit member1 = new MemberInit(); // 기본생성자 매개변수로 아무것도 받지 않고, 클래스에 생성자가 존재하지 않음
    ```
    

### this

- 멤버변수와 매개변수의 이름이 같을때 구분하기 위해 사용
    - this.은 인스턴스의 참조값을 가져온다
    - 매개 변수가 {} 더 안쪽에 있어 우선 순위를 갖는다
    - 멤버 변수에 접근 하기 위해서 this를 붙여야한다
    - 아래 코드에서 객체의 멤버변수와 initMember에서 넘어온 인자가 이름이 똑같다 이를 구분하기 위함
- 멤버변수와 매개변수의 이름이 다르면 this 생략 가능
    - 멤버변수에 접근할때는 무조건 this를 붙히는 코딩 스타일도 있음 (최근에는 안씀)
    
    ```java
    public class MemberInit {
        String name; // 멤버변수
        int age;
        int grade;
        int month;
    
        //추가
        void initMember(String name, int age, int grade, int m) { // 매개 변수
            this.name = name;
            this.age = age;
            this.grade = grade;
            month = m 
        }
    }
    ```
    

### 오버로딩과 this

- 생성자를 매개변수의 개수를 다르게 해서 여러개의 생성자를 만들 수 있다. (오버라이딩)
    
    ```java
        MemberConstruct(String name, int age) {
            this.name = name;
            this.age = age;
            this.grade = 50;
        }
    
        MemberConstruct(String name, int age, int grade) {
            this.name = name;
            this.age = age;
            this.grade = grade;
        }
    ```
    
- **this()** 라는 기능을 사용하면 생성자 **내부에서 자신의 생성자를 호출할 수 있다(바로 아래에 호출해야함)**.
    
    참고로 this 는 인스턴스 자신의 참조값을 가리킨다. 그래서 자신의 생성자를 호출한다고 생각하면 된다
    
    ```java
    public class MemberConstruct {
    		 String name;
    		 int age;
    		 int grade;
    		 MemberConstruct(String name, int age) {
    				 this(name, age, 50); //아래의 생성자를 호출, 위에 다른 코드가 있으면 오류
    		 }
    		 MemberConstruct(String name, int age, int grade) {
    				 this.name = name;
    				 this.age = age;
    				 this.grade = grade;
    		 }
    }
    ```
    

### 생성자 중복 제거 예제

```java
public class Book {
    String title; //제목
    String author; //저자
    int page; //페이지 수
    // 기본 생성자
    Book() {
        this("", "", 0);
    }
    Book(String title, String author) {
        this(title, author, 0);
    }
    Book(String title, String author, int page) {
        this.title = title;
        this.author = author;
        this.page = page;
    }
    void displayInfo() {
        System.out.println("제목: " + title + ", 저자: " +author+ ", 페이지: " + page);
    }
}
```

## 세션[5] 패키지 (20240722)

### 패키지

- **패키지를 사용하는 경우 항상 코드 첫줄에 package pack 과 같이 패키지 이름을 적어주어야 한다**
- .을 통해서 하위 패키지를 가리킴 package pack.a
- pack 과 pack.a는 다른 패키지에 있는 것이다

### import

- 코드에서 첫줄에는 package 를 사용하고, 다음 줄에는 import 를 사용할 수 있다.
import 를 사용하면 다른 패키지에 있는 클래스를 가져와서 사용할 수 있다
    
    import 사용으로 패키지내 클래스를 경로 없이 사용 가능할 수있다
    
    ```java
    package pack;
    import pack.a.User;
    
    public class PackageMain2 {
    
    		 public static void main(String[] args) {
    		 
    				 Data data = new Data();
    				 User user = new User(); //import 사용으로 패키지 명 생략 가능
     }
    ```
    
- pack.* 을 통해 해당 패키지에 있는 모든 클래스를 사용할 수 있다
    
    ```java
    import pack.a.*; //pack.a의 모든 클래스 사용
    ```
    

### 중복 import

- 같은 이름의 클래스가 있다면 import 는 둘중 하나만 선택할 수 있다. 이때는 자주 사용하는 클래스를 import 하고 나머지를 패키지를 포함한 전체 경로를 적어주면 된다. 물론 둘다 전체 경로를 적어준다면 import 를 사용하지 않아도된다.
    
    ```java
    // pack.a.User도 있고, pack.b.User도 있을떄 
    package pack;
    import pack.a.User;
    
    public class PackageMain3 {
    			public static void main(String[] args) {
    					 User userA = new User();
    					 pack.b.User userB = new pack.b.User();
    		 }
    }
    ```
    

### 패키지 규칙

- 패키지의 이름과 위치는 폴더(디렉토리) 위치와 같아야 한다. (필수)
- 패키지 이름은 모두 소문자를 사용한다. (관례)
- 패키지 이름의 앞 부분에는 일반적으로 회사의 도메인 이름을 거꾸로 사용한다. 예를 들어,
com.company.myapp 과 같이 사용한다. (관례)
이 부분은 필수는 아니다. 하지만 수 많은 외부 라이브러리가 함께 사용되면 같은 패키지에 같은 클래스 이
름이 존재할 수도 있다. 이렇게 도메인 이름을 거꾸로 사용하면 이런 문제를 방지할 수 있다.
내가 오픈소스나 라이브러리를 만들어서 외부에 제공한다면 꼭 지키는 것이 좋다.
내가 만든 애플리케이션을 다른 곳에 공유하지 않고, 직접 배포한다면 보통 문제가 되지 않는다

### 패키지의 계층 구조

- **a 패키지와 a.b , a.c 패키지는 서로 완전히 다른 패키지**
    - 따라서 a 패키지의 클래스에서 a.b 패키지의 클래스가 필요하면 import 해서 사용해야 한다.
    - 반대로 a.b 패키지 클래스에서 a의 클래스가 필요하면 import 해서 사용해야한다

## 세션[6] 접근제어자 (20240723)

- **접근 제어자를 사용하여 해당 클래스 외부에서 특정 필드나 메서드에 접근하는 것을 허용하거나 제한할 수 있다.**

### 접근제어자 - 필드, 메서드 레벨

**private(현재 클래스에서만)-> default(같은패키지 허용) -> protected(같은 패키지, 다른 패키지여도 상속관계시 허용) -> public(모두 허용 )**

- private : 모든 외부 호출을 막는다.
    - private 은 나의 클래스 안으로 속성과 기능을 숨길 때 사용, 외부 클래스에서 해당 기능을 호출할 수 없다.
    - 클래스 내부에서는 접근 가능
- default (package-private): 같은 패키지안에서 호출은 허용한다.(아무것도 안쓰면 default)
    - default 는 나의 패키지 안으로 속성과 기능을 숨길 때 사용, 외부 패키지에서 해당 기능을 호출할 수 없다.
- protected : 같은 패키지안에서 호출은 허용한다. 패키지가 달라도 상속 관계의 호출은 허용한다.
    - protected 는 상속 관계로 속성과 기능을 숨길 때 사용, 상속 관계가 아닌 곳에서 해당 기능을 호출할 수 없다.
- public : 모든 외부 호출을 허용한다.
    - public 은 기능을 숨기지 않고 어디서든 호출할 수 있게 공개한다.

### 접근제어자 - 클래스 레벨

- **클래스 레벨의 접근 제어자는 public과 default만 사용 사용할 수 있다**
- 하나의 자바 파일에 **public 클래스는 하나만** 등장할 수 있다.
- 하나의 자바 파일에 default 접근 제어자를 사용하는 클래스는 무한정 만들 수 있다.

### 접근제어자의 캡슐화

1. 데이터 (멤버 변수)는 private으로 웬만하면 숨겨두자 
    - public 메서드, 생성자로 멤버 변수에 접근하거나 변경하는 방식을 사용해야 한다
2. 기능(메서드)는 외부에서 꼭 필요한 기능만 public으로 노출하고 최대한 기능을 private로 숨긴다 
    - 클래스 내부에서 검증, 계산 같은 메서드들은 private으로 숨기자

```java
package access;
public class BankAccount {

		// 데이터는 private
    private int balance;

    public BankAccount() {
        balance = 0;
    }

    // public 메서드: deposit
    public void deposit(int amount) {
        if (isAmountValid(amount)) {
            balance += amount;
        } else {
            System.out.println("유효하지 않은 금액입니다.");
        }
    }

    // public 메서드: withdraw
    public void withdraw(int amount) {
        if (isAmountValid(amount) && balance - amount >= 0) {
            balance -= amount;
        } else {
            System.out.println("유효하지 않음 금액이거나 잔액이 부족합니다.");
        }
    }

    // public 메서드: getBalance
    public int getBalance() {
        return balance;
    }

		// 검증 메서드는 외부가 아닌 내부에서 하기 때문에 private
    private boolean isAmountValid(int amount) {
        // 금액이 0보다 커야함
        return amount > 0;
    }
}

```

- isAmountValid 메서드는 검증 메서드로 외부가 아닌 내부에서 하기 때문에 private
    - 만약 public이라면 내부에서 검증을 이미 하고 있는데 외부에서 검증하라고 오해하고 이 중 검증을 할 수 있다

## 세션[7] 자바 메모리 구조와 static (20240723)

### 메모리의 구조

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/720abf95-7e09-46c8-8ccd-ff391e9ecc90/f01adeb0-668f-487e-abb4-bda3cbf82c3c/Untitled.png)

- 메서드 영역(Method Area): 메서드 영역은 프로그램을 실행하는데 필요한 공통 데이터를 관리한다. 이 영역은 프로그램의 모든 영역에서 공유한다.
    - **클래스** 정보: 클래스의 실행 코드(바이트 코드), 필드, 메서드와 생성자 코드등 모든 실행 코드가 존재한다.
        - 메서드를 호출할때  메서드에 대한 새로운 메모리 할당은 없다. 메서드는 메서드 영역에서 공통으로 관리되고 실행
    - **static** 영역: static 변수들을 보관한다. 뒤에서 자세히 설명한다.
    - **런타임 상수 풀**: 프로그램을 실행하는데 필요한 공통 리터럴 상수를 보관한다. 예를 들어서 프로그램에
    "hello" 라는 리터럴 문자가 있으면 이런 문자를 공통으로 묶어서 관리한다. 이 외에도 프로그램을 효율
    적으로 관리하기 위한 상수들을 관리한다. (참고로 문자열을 다루는 문자열 풀은 자바 7부터 힙 영역으로 이동했다.)
- 스택 영역(Stack Area): 자바 실행 시, 하나의 실행 스택이 생성된다. 각 스택 프레임은 **지역 변수, 중간 연산 결과, 메서드 호출 정보** 등을 포함한다.
    - 스택 프레임: 스택 영역에 쌓이는 네모 박스가 하나의 스택 프레임이다. **메서드를 호출할 때 마다 하나의 스택 프레임이 쌓이고, 메서드가 종료되면 해당 스택 프레임이 제거**된다.
- 힙 영역(Heap Area): **객체(인스턴스)와 배열**이 생성되는 영역이다. 가비지 컬렉션(GC)이 이루어지는 주요 영역이며, 더 이상 참조되지 않는 객체는 GC에 의해 제거된다.

<aside>
💡 참고: 스택 영역은 더 정확히는 각 쓰레드별로 하나의 실행 스택이 생성된다. 따라서 쓰레드 수 만큼 스택 영역이 생성된다. 지금은 쓰레드를 1개만 사용하므로 스택 영역도 하나이다. 쓰레드에 대한 부분은 멀티 쓰레드를 학습해야 이해할 수 있다.

</aside>

### 스택, 힙  - 이건 ppt 읽어 보자

- 스택 : LIFO(후입선출)
- 힙 : FIFO(선입선출)

### static 변수 = 정적변수 = 클래스 변수

클래스에서 공용으로 함께 사용할 수 있는 변수

- 한 클래스로 생성된 여러 인스턴스가 하나의 변수를 공유함
- static 멤버 변수는 인스턴스 영역(힙)에서 관리 하지 않고 **메서드 영역**에서 관리한다
- 인스턴스로 접근도 가능하지만 인스턴스와 무관하게 클래스에 바로 접근해서 사용할 수 있다(객체를 생성하지 않고도 가능) - **클래스로 바로 접근하는거 권장(안 헷갈리게)**
    
    ```java
      public static void main(String[] args) {
            // 객체 생성 없이 클래스 이름을 통해 static 변수에 접근
            System.out.println(Data3.count);
            //인스턴스를 통한 접근도 가능 
            Data3 data4 = new Data3("D");
            System.out.println(data4.count);
      }
    ```
    

인스턴스 변수: static 이 붙지 않은 멤버 변수

### 변수와 생명주기

- 지역 변수(매개변수 포함): 지역 변수는 스택 영역에 있는 스택 프레임 안에 보관된다. **메서드가 종료**되면 스택 프레임도 제거 되는데 이때 해당 스택 프레임에 포함된 지역 변수도 함께 제거된다. 따라서 지역 변수는 생존 주기가 짧다.
- 인스턴스 변수: 인스턴스에 있는 멤버 변수를 인스턴스 변수라 한다. 인스턴스 변수는 힙 영역을 사용한다. 힙 영역은 **GC(가비지 컬렉션)가 발생**하기 전까지는 생존하기 때문에 보통 지역 변수보다 생존 주기가 길다.
- 클래스 변수: 클래스 변수는 메서드 영역의 static 영역에 보관되는 변수이다. 메서드 영역은 프로그램 전체에서 사용하는 공용 공간이다. 클래스 변수는 해당 클래스가 **JVM에 로딩 되는 순간 생성**된다. 그리고 JVM이 종료될 때 까지 생명주기가 이어진다. 따라서 가장 긴 생명주기를 가진다.
static 이 정적이라는 이유는 바로 여기에 있다. 힙 영역에 생성되는 인스턴스 변수는 동적으로 생성되고, 제거된다. 반면에 static 인 정적 변수는 거의 프로그램 실행 시점에 딱 만들어지고, 프로그램 종료 시점에 제거된다. 정적 변수 는 이름 그대로 정적이다.

### static 메서드 = 클래스 메서드 = 정적 메서드

- 정적 변수처럼 인스턴스 생성 없이 클래스 명을 통해서 바로 호출할 수 있다
- 정적 메서드는 객체 생성이 필요 없이 메서드의 호출만으로 필요한 기능을 수행할 때 주로 사용한다(계산기)
- 객체 생성 없이 클래스명 + . (dot) + 메서드 명으로 바로 호출
- static 메서드는 static 만 사용할 수 있다.
    - 클래스 내부의 기능을 사용할 때, 정적 메서드는 static 이 붙은 정적 메서드나 정적 변수만 사용할 수 있
    다.
    - 클래스 내부의 기능을 사용할 때, 정적 메서드는 인스턴스 변수나, 인스턴스 메서드를 사용할 수 없다.
- 반대로 모든 곳에서 static 을 호출할 수 있다.
    - 정적 메서드는 공용 기능이다. 따라서 접근 제어자만 허락한다면 클래스를 통해 모든 곳에서 static 을 호
    출할 수 있다

인스턴스 메서드: static 이 붙지 않은 메서드

<aside>
💡 객체의 참조값을 직접 매개변수로 전달하면 정적 메서드도 인스턴스의 변수나 메
서드를 호출할 수 있다

public static void staticCall(DecoData data) {
      data.instanceValue++;
      data.instanceMethod(); // 동적 메서드인데 인스턴스 메서드에서 사용 
}

</aside>

### static import

DecoData.staticCall(); → staticCall(); 이렇게 클래스 명을 입력 안할 수 있다(정적 변수에도 사용가능)

```java
package static2;
//import static static2.DecoData.staticCall; // 하나만
import static static2.DecoData.*; // 클래스내 static 메서드전부 
```

### main() 메서드는 정적 메서드

- 같은 클래스에서 호출하는 메서드도 정적 메서드로 선언해서 사용

## 세션[8]  final (20240724)

finer은 클래스, method 여러 곳에서 사용가능

### final 지역 변수

 값을 변경 불가능, 최초 한번만 할당 가능 

### final 매개 변수

객체의 매개변수일 경우 생성자로 한번 초기화 가능(미리 초기화 되어 있다면 불가능)

인스턴스마다 각자의 final 변수 값을 가짐(값을 공유하지 않음) 

상수(static final ) : 클래스의 단 하나뿐인 변하지 않는 변수를 설정 (모두 대문자와 _만 사용 규칙)

어플리케이션 전반에서 많이 사용하고 변경이 불가하기에 보통 **public**으로 많이 사용

```java
package final1;
//final 필드 - 생성자 초기화
public class ConstructInit {
	final int value;
	//final int value = 10; 이러면 값을 바꿀수 없음 

	public static final int VAL = 10; // 상수 
	
	public ConstructInit(int value) {
	this.value = value;
	}
}
```

### final 참조형 변수

참조형 변수의 final을 붙히면 참조값을 변경 못함

참조값내의 값은 변경할 수 있다 

```java
final Data data = new Data();

// Data data = new Data(); 참조값을 변경 못함
data.name = 'han'
data.name = 'jang // 참조값 내의 값은 변경가능
```

### final 클래스

final 클래스는 상속 받을 수 없다

## 세션[8]  상속 (20240724)

### 상속 관계

부모 클래스의 속성과 기능을 그대로 물려 받는 것 extends를 사용 

**한개의 클래스**만 상속 가능 

```java

public class Parent {

    public String value = "parent";

    public void hello() {
        System.out.println("Parent.hello");
    }
}

public class Child extends Parent {

    public String value = "child";

    @Override
    public void hello() {
        System.out.println("Child.hello");
    }

    public void call() {
        System.out.println("this value = " + this.value); //this 생략 가능
        System.out.println("super value = " + super.value);

        this.hello(); //this 생략 가능
        super.hello();
    }
}
```

### 상속과 메모리 구조

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/720abf95-7e09-46c8-8ccd-ff391e9ecc90/9eb3580a-25e3-4684-94a5-5071bd9cf8c4/Untitled.png)

- 상속 관계의 객체를 생성하면 그 내부에는 부모와 자식이 모두 생성된다.
- 상속 관계의 객체를 호출할 때, 대상 타입을 정해야 한다. 이때 호출자의 타입을 통해 대상 타입을 찾는다.
- 현재 타입에서 기능을 찾지 못하면 상위 부모 타입으로 기능을 찾아서 실행한다. 기능을 찾지 못하면 컴파일 오류가 발생한다.

### 메서드 오버라이딩

부모 타입의 기능을 자식에서는 다르게 재정의하는 것  (@Override)

오버라이딩된 메서드를 자식 클래스에서 찾으면 부모 클래스의 메서드를 찾지 않는다 

### 메서드 오버라이딩 조건

- 이름, 매개변수(타입,순서,개수)가 같아야함
- 반환타입이 같아야함(하위 클래스 타입은 가능)
- 상위 클래스의 접근 제어자보다 제한적이면 안된다
    
    상위 클래스가 default이면 public, protected는 가능하지만 private는 안된다 
    
- 예외: 오버라이딩 메서드는 상위 클래스의 메서드보다 더 많은 체크 예외를 throws 로 선언할 수 없다. 하지만
더 적거나 같은 수의 예외, 또는 하위 타입의 예외는 선언할 수 있다.
- static , final , private : 키워드가 붙은 메서드는 오버라이딩 될 수 없다
    - static은 클래스 로딩 시점에 메모리에 할당되기 떄문
    - final은 수정 불가
    - private는 클래스내에서만 사용 가능
- 생성자는 오버라이딩 할 수 없다

### super - 부모참조

부모와 자식의 필드, 메서드 명이 같을때 부모꺼를 참조할 수 있다. 

```java
public void call() {
    System.out.println("this value = " + this.value); //this 생략 가능
    System.out.println("super value = " + super.value);

    this.hello(); //this 생략 가능
    super.hello();
}
```

### super - 생성자

1. **상속 관계를 사용하면 자식 클래스의 생성자에서 부모 클래스의 생성자를 반드시 호출해야 한다.(규칙)**
    - 상속 관계의 인스턴스를 생성하면 결국 **메모리 내부에는 자식과 부모 클래스가 각각 다 만들어진다**.  Child 를 만들면 부모인 Parent 까지 함께 만들어지는 것이다. 따라서 각각의 생성자도 모두 호출되어야 한다.
2. 생성자는 오버라이딩 할 수 없다.
3. 상속 관계에서 자식 클래스의 생성자 첫줄에 반드시 super(...) 를 호출해야 한다. 단 기본 생성자
super() 인 경우 생략할 수 있다.
4. 코드의 첫줄에 this(...) 를 사용하더라도 반드시 한번은 super(...) 를 호출해야 한다.
    
    아래 코드에서 두개의 생성자에서 super()가 들어간 이 생성자는 무조건 적으로 실행되어야한다
    
5. 상속 관계의 생성자 호출은 결과적으로 부모에서 자식 순서로 실행된다. 따라서 부모의 데이터를 먼저 초기화하고 그 다음에 자식의 데이터를 초기화한다
    
    각 클래스에 맨 위에는 super()가 있어야하기 때문에 
    
    ```java
    public class ClassA {
        public ClassA() {
            System.out.println("ClassA 생성자");
        }
    }
    
    public class ClassB extends ClassA {
    
        public ClassB(int a) {
            this(a, 0); //기본 생성자 생략 가능
            System.out.println("ClassB 생성자 a=" + a);
        }
    
        public ClassB(int a, int b) { // 이 생성자는 무조건 적으로 실행되어야한 
            super(); //기본 생성자 생략 가능
            System.out.println("ClassB 생성자 a=" + a + " b=" + b);
        }
    }
    
    public static void main(String[] args) {
        //ClassC classC = new ClassC();
        ClassB classB = new ClassB(100);
    }
        
    // 결과 부모의 생성자 부터 실행 되기 때문
    ClassA 생성자
    ClassB 생성자 a=100 b=0
    ClassB 생성자 a=100
    ```
    

### 클래스와 메서드에 사용되는 final

final 클래스는 상속 받을 수 없다

final 메서드는 오버라이딩을 할 수 없다 

## 세션[10]  다형성 (20240724) - 꼭 다시 읽어보자

다형성 : 하나의 객체가 여러 타입으로 사용될 수 있다는 뜻

### 다형적 참조 : 부모 변수가 자식 인스턴스 참조

- **부모 변수가 자식 인스턴스 참조할 수있다, 자식은 부모를 담을 수 없다.**
- **부모 변수가 자식 인스턴스 참조시 자식의 기능은 호출할 수 없다**
- 다형적 참조는 업캐스팅의 일종이다

```java
//부모 변수가 자식 인스턴스 참조(다형적 참조)
System.out.println("Parent -> Child");
Parent poly = new Child();
poly.parentMethod();
//자식의 기능은 호출할 수 없다. 컴파일 오류 발생
//poly.childMethod();

//Child child1 = new Parent(); //자식은 부모를 담을 수 없다.

Parent poly2 = new Grandson(); // 부모는 손자도 담을 수 있다 하위 클래스는 다 담을 수 있ㅇ므 

```

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/720abf95-7e09-46c8-8ccd-ff391e9ecc90/0ef3292a-3aa4-4cdd-8f57-7667e03d67c3/Untitled.png)

1. 부모 타입 변수가 자식 인스터스를 참조(Parent poly = new Child())
2. Child 인스턴스를 만들었다(new Child()). 이 경우 자식 타입인 Child 를 생성했기 때문에 메모리 상에 Child 와 Parent 가 모두 생성된다
3. 생성된 참조값을 Parent 타입의 변수인 poly 에 담아둔다.

**부모 변수가 자식 인스턴스 참조시 자식의 기능은 호출할 수 없는 이유** 

1. 호출자인 poly 는 Parent 타입이다. 따라서 **Parent 클래스부터 시작해서 필요한 기능을 찾는다**
2. 상속 관계는 부모 방향으로 찾아 올라갈 수는 있지만 자식 방향으로 찾아 내려갈 수는 없다. Parent 는
부모 타입이고 상위에 부모가 없다. 따라서 childMethod() 를 찾을 수 없으므로 컴파일 오류가 발생
- 자식의 기능을 사용하기 위해선 **캐스팅**이 필요하다

### 다형성과 캐스팅(부모↔자식)

**캐스팅을 한다고 해서 Parent poly 의 타입이 변하는 것은 아니다**. 해당 참조값을 꺼내고 꺼낸 참조값이
Child 타입이 되는 것이다. 따라서 poly 의 타입은 Parent 로 기존과 같이 유지된다

**다운 캐스팅 : (부모** **타입을 자식 타입으로 변경) (부모, 자식 기능 둘다 사용 가능)**

- 다운 캐스팅을 하면 자식의 메서드를 사용할 수있다(이전처럼 부모 기능도 사용가능)

```java
//부모 변수가 자식 인스턴스 참조(다형적 참조)
Parent poly = new Child(); //x001
//단 자식의 기능은 호출할 수 없다. 컴파일 오류 발생
//poly.childMethod();

//다운캐스팅(부모 타입 -> 자식 타입)
Child child = poly; // 이건 불가능 
Child child = (Child) poly;  // 기본적으로 poly는 바뀌지 않음  
child.childMethod();
child.parentMethod();

```

1. 다운캐스팅을 통해 부모타입을 자식 타입으로 변환한 다음에 대입 시도
2. 참조값을 읽은 다음 자식 타입으로 지정

**일시적 다운 캐스팅** 

```java
Parent poly = new Child(); // child의 메서드를 사용 못함 , 기본적으로 poly는 바뀌지 않음  
((Child) poly).childMethod(); // 일시적 다운 캐스팅 
```

**다운캐스팅 주의점** 

부모타입 변수에 부모타입 인스턴스 참조값을 저장했다 → 여기에는 child에 대한 객체가 메모리에 없다 → 오류

```java
Parent parent1 = new Child();
Child child1 = (Child) parent1;
child1.childMethod(); //문제 없음

Parent parent2 = new Parent();
Child child2 = (Child) parent2; //런타임 오류 - ClassCastException
child2.childMethod(); //실행 불가
```

### **업캐스팅**(upcasting): 자식 타입을 부모 타입으로 변경

부모는 자식을 담을 수 있기때문에 생략 가능(권장)

- 다운캐스팅은 생략 불가능

자식 타입에 부모 인스턴스를 저장 못하는거랑 햇갈리지 말자 

```java
Child child = new Child();
Parent parent1 = (Parent) child; //업캐스팅은 생략 가능, 생략 권장
Parent parent2 = child; //업캐스팅 생략

parent1.parentMethod();
parent2.parentMethod();
```

**캐스팅 정리** 

```java
//부모 변수가 자식 인스턴스 참조(다형적 참조)
Parent poly = new Child(); //x001
poly.parentMethod();
//poly.childMethod(); //단 자식의 기능은 호출할 수 없다. 컴파일 오류 발생

// 자식 변수가 부모 인스턴스를 참조하는것은 불가
// Child child1 = new Parent(); // 자식 타입에 부모를 담을 수없다 new Parent()에는 child에 대한 객체정보가 없다

//다운캐스팅(부모 타입 -> 자식 타입)
Child child = (Child) poly; //x001
child.childMethod();
child.parentMethod();

// 다운캐스팅 실패(부모타입에 부모 인스턴스가 들어있는 경우)
Child child2 = new Child();
Parent parent2 = new Parent();
child2 = (Child) parent2; // (다운 캐스팅 실패) parent가 위치한 메모리에 child에 대한 객체 정보가 없다 

// 업캐스팅 (자식 타입 -> 부모타입)
// Child child1 = new Parent(); // 자식 타입에 부모를 담을 수없다 new Parent()에는 child에 대한 객체정보가 없다
Parent parent3 = new Parent();
Child child3 = new Child();
parent3 = (Parent) child3; // (업 캐스팅) 부모는 자식을 품을 수 있다
```

**Parent poly = new Child(); 해석** 

1. new Child() -  Child 클래스로 인스턴스를 생성 (메모리상에 Parent, Child의 객체 정보 모두가 저장)
2. Parent 타입의 변수 poly에 인스턴스의 참조값을 저장
3. Parent 타입의 변수 poly의 메서드 사용시 메모리상에 Parent, Child의 객체 정보 중 Parent를 사용 

**컴파일 오류 vs 런타임 오류**

- 컴파일 오류는 변수명 오타, 잘못된 클래스 이름 사용등 자바 프로그램을 실행하기 전에 발생하는 오류이다. 이런 오류는 IDE에서 즉시 확인할 수 있기 때문에 안전하고 좋은 오류이다.
- 반면에 런타임 오류는 이름 그대로 프로그램이 실행되고 있는 시점에 발생하는 오류이다. 런타임 오류는 매우 안좋은 오류이다. 왜냐하면 보통 고객이 해당 프로그램을 실행하는 도중에 발생하기 때문이다

### instanceof

어떤 인스턴스를 참조하고 있는지 확인해주는 키워드 

- `parent instanceof Child`
- `parent instanceof Child child` - 자바 16부터 사용가능 캐스팅 불필요

```java
private static void call(Parent parent) {
    parent.parentMethod();
    if (parent instanceof Child) {
        System.out.println("Child 인스턴스 맞음");
        Child child = (Child) parent; //캐스팅
        child.childMethod();
    }
}
or 
private static void call(Parent parent) {
    parent.parentMethod();
    //Child 인스턴스인 경우 childMethod() 실행
    if (parent instanceof Child child) {
        System.out.println("Child 인스턴스 맞음");
        child.childMethod();
    }
}
```

### 다형성과 메서드 오버라이딩

오버라이딩 된 메서드가 항상 우선권을 가진다

- 변수는 오버라이딩이 되지 않는다

```java
public class Child extends Parent {

    public String value = "child";

    @Override
    public void method() {
        System.out.println("Child.method");
    }
}

public class Parent {

    public String value = "parent";

    public void method() {
        System.out.println("Parent.method");
    }
}

    public static void main(String[] args) {
        //자식 변수가 자식 인스턴스 참조
        Child child = new Child();
        System.out.println("Child -> Child");
        System.out.println("value = " + child.value);
        child.method();

        //부모 변수가 부모 인스턴스 참조
        Parent parent = new Parent();
        System.out.println("Parent -> Parent");
        System.out.println("value = " + parent.value);
        parent.method();

        //부모 변수가 자식 인스턴스 참조(다형적 참조)
        Parent poly = new Child();
        System.out.println("Parent -> Child");
        System.out.println("value = " + poly.value); //변수는 오버라이딩X
        poly.method(); //메서드 오버라이딩!
    }

Child -> Child
value = child
Child.method
Parent -> Parent
value = parent
Parent.method
Parent -> Child
value = parent
Child.method
```

- **오버라이딩 된 메서드는 항상 우선권을 가진**다. 오버라이딩은 부모 타입에서 정의한 기능을 자식 타입에서 재정의하는것이다. 만약 자식에서도 오버라이딩 하고 손자에서도 같은 메서드를 오버라이딩을 하면 손자의 오버라이딩 메서드가 우선권을 가진다. 더 하위 자식의 오버라이딩 된 메서드가 우선권을 가지는 것

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/720abf95-7e09-46c8-8ccd-ff391e9ecc90/69d94137-017c-4d84-b7e3-3042727aca3e/Untitled.png)

### 내가 이해한 내용

다형적 참조란? 부모 타입의 변수에 자식 클래스 인스턴스를 참조(참조값을 저장)할 수 있다 

이는 메모리에 자식 클래스 인스터스를 저장하면서 부모  클래스, 자식 클래스 모두를 저장하기 때문이다 

이때는 자식 클래스의 메서드, 필드를 사용하지 못하고 부모 클래스의 메서드, 필드만 사용 할 수 있다.

하지만 오버라이딩된 메서드가 호출될 때는 실제 객체인 자식 클래스의 메서드가 실행(오버라이딩 된 메서드는 항상 우선권을 가지기 때문)

이때 다운 캐스팅을 통해 부모 타입을 자식 타입으로 변경할 수 있다. 이 또한 마찬가지로 자식 클래스 인스터스를 저장하면서 부모  클래스, 자식 클래스 모두를 저장하기 때문이다. 이때는 부모, 자식 모두의 메서드, 필드를 사용할 수 있다.

하지만 다형적 참조 형태가 아닌 부모 타입 변수에 부모 인스턴스가 저장된 경우에는 자식 객체에 대한 정보가 없기 때문에 다운 캐스팅이 불가능하다 

자식 타입 변수에 부모 인스턴스를 저장할 수는 없다. 부모인스턴스에는 자식 클래스에대한 정보가 없기 때문이다.

하지만 자식 타입 변수에 자식 인스턴스가 저장된 경우 업 캐스팅을 통해 자식 타입을 부모 타입으로 변경할 수 있다. 하지만 자식 클래스의 메서드는 사용이 불가능하다. 

또한 다형적 참조 역시 업캐스팅이다. 

## 세션[11]  다형성 활용 (20240724) - 다시 읽자

### 다형성 메서드 오버라이딩 쓰는 이유

**예제** 

- animal이라는 클래스를 상속하는 dog,cat,cow가 있다
- 각 동물은 animal의 sound() 메서드를 오버라이딩함
- dog, cat, caw를 상위 클래스인 Animal 타입의 배열에 넣을 수 있음(다형적 참조)
    - 해당 배열을 for문 동작가능

```java
// 불필요한 반복 
Dog dog = new Dog();
Cat cat = new Cat();
Caw caw = new Caw();
dog.sound();
cat.sound();
caw.sound();

// 
 Dog dog = new Dog();
 Cat cat = new Cat();
 Caw caw = new Caw();
 Animal[] animalArr = {dog, cat, caw}; (다형적참조)
 //변하지 않는 부분
 for (Animal animal : animalArr) {
	 animal.sound();
	} 
```

**생길 수 있는 문제** 

1. 개념적 클래스 animal의 인스턴스를 생성하는 경우 - 제대로된 기능을 수행하지 않음
2. animal을 상속받고 sound()를 오버라이딩 하지 않는 경우 - 부모클래스의 sound()가 실행됨

### 추상클래스

추상적인 개념 제공하는 클래스

필드를 생성, 수정 가능  

실제 생성(인스턴스)이 불가능 → 부모 클래스를 인스턴스로 만들것을 방지

상속을 목적으로 사용되고, 부모 클래스로 사용된다 `extends` 사용

`abstract class AbstractAnimal {...}`

### 추상메서드

추상 메서드는 이름 그대로 추상적인 개념을 제공하는 메서드

부모 클래스를 상속 받는 자식 클래스가 반드시 오버라이딩 해야 하는 메서드를 부모 클래스에 정의

실체가 존재하지 않고,메서드 바디가 없다.

**추상 메서드가 하나라도 있으면 추상 클래스로 선언해야한다** 

**추상 메서드는 상속 받는 자식 클래스가 반드시 오버라이딩 해서 사용해야 한다.→ 오버라이딩 강조** 

`public abstract void sound();`

### 순수 추상 클래스

**모든 메서드가 추상 메서드인 추상 클래스- 모든 메서드에 abstract**

### 인터페이스

순수 추상 클래스를 더 쉽게 사용하게 해주는 기능

모든 메서드를 추상메서드로 오버라이딩해서 구현해야함

class가 아닌 interface

**상속이 아닌 구현**이라함 , extends 대신 implements 

**모든 메서드는 public, abstract를 포함하고 이를 생략 가능**

**다중 구현을 지원한다** 

**인터페이스에서 멤버 변수는 public , static , final 이 모두 포함되었다고 간주된다 → 필드 수정 불가**

`public class Child implements InterfaceA, InterfaceB {`

### 추상 클래스와 인터페이스의 차이

- 제약
    
    추상 클래스에는 실행가능한 메서드를 추가할 수 있지만 인터페이스는 모든 메서드를 구현하게 끔 강제된다
    
- 다중 구현
    
    추상 클래스를 상속하는 경우는 하나만 상속 가능하지만 인터페이스는 한번에 여러개를 구현할 수 있다  
    

### 다중 상속을 지원하지 않고 다중 구현은 구현하는 이유

여러 클래스를 상속 받으면 같은 이름의 메서드 중 어떤 부모의 메서드를 구현할지 결정해야 하는 다이아몬드 문제가 발생한다

인터페이스 자신은 구현을 가지지 않는다. 대신에 인터페이스를 구현하는 곳에서 해당 기능을 모두 구현해야 한
다. 여기서 InterfaceA , InterfaceB 는 같은 이름의 methodCommon() 를 제공하지만 이것의 기능은 Child
가 구현한다. 그리고 오버라이딩에 의해 어차피 Child 에 있는 methodCommon() 이 호출된다. 결과적으로 두 부모 중에 어떤 한 부모의 methodCommon() 을 선택하는 것이 아니라 그냥 인터페이스들을 구현한 Child 에 있는 methodCommon() 이 사용된다

**상속과 구현을 동시에 사용 가능하다** 

`public class Bird extends AbstractAnimal implements Fly {` 

## 세션[10]  객체지향프로그래밍 (20240724)

객체들의 모임으로 프로그램을 파악하고자 함, 각각의 개체는 메세지를 주고 받고 데이터를 처리(협력)

캡슐화, 다형성, 추상화, 상속성

**역할(인터페이스)과 구현(구현 객체)으로 세상을 구분 ,** 프로그램은 유연하고 변경이 용이하게 만듬

- 클라이언트는 대상의 역할(인터페이스)만 알면 된다
- 클라이언트는 구현 대상의 내부 구조를 몰라도 된다
- 클라이언트는 구현 대상의 내부 구조가 변경되어도 영향을 받지 않는다
- 클라이언트는 구현 대상 자체를 변경해도 영향을 받지 않는다

### 다형성의 본질

- 클라이언트를 변경하지 않고, 서버의 구현 기능을 유연하게 변경할 수 있다

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/720abf95-7e09-46c8-8ccd-ff391e9ecc90/8ada1cdd-74c4-4a1d-ba54-41a7a03e2318/Untitled.png)

- 여기서 driver는 car(역할)에만 의존한다 , 밑의 어떤 차종인지는 모른다
    - driver는 car 멤버변수=인터페이스를 가진다, car 인터페이스만을 참조
- car는 인터페이스로 k3car, model3car 클래스가 인터페이스를 구현

### OCP 원칙

확장에 열려있고 수정에는 닫혀있어야한다 

- 위 예시에서 새로운 차를 추가해도 driver(클라이언트)의 코드는 전혀 변경되지 않는다(인터페이스때문)
- main()에서 새로운차를 생성하고 전달하는 부분은 프로그램을 설정하고 조율하는 역할, 이런부분은 ocp를 지켜도 변경이 필요하다

**전략 패턴** 

- 디자인 패턴 중 가장 중요한 패턴
- 클라이언트의 코드 변경없이 알고리즘을 쉽게 교체
- 위 코드가 전략 패턴