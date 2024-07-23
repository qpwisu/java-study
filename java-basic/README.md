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