## 섹션[1] Object 클래스 (20240801)

### Object 클래스

- 자바의 모든 클래스의 최상위 부모 클래스
- 클래스에 상속 받을 부모 클래스가 없으면 묵시적으로 Object 클래스를 상속 받는다
- 다형성 : 모든 객체를 Object 타입으로 모두 담을 수 있다
- 공통 기능 제공
    - toString() : 객체정보제공
    - equals() : 객체같음비교
    - getClass() : 객체클래스정보제공

### Object 다양성의 한계

- 부모클래스(Object) 타입으로 저장할시 자식 클래스의 메서드를 사용 못한다(오버라이딩 예외)
    - 다운 캐스팅을 이용해 자식 클래스의 메서드 사용
        
        ```java
        
        if (obj instanceof Dog dog) {
         dog.sound();
        ```
        

### toString()

- Object의 toString()은 객체의 값을 출력해주지 않는데
    - 자식 클래스에서 오버라이딩해서 재정의해서 보기 쉽게 변경해주자 (command+N)
    - toString을 오버라이딩해주면 sout 내부에서 toString을 사용하기에 적용된다

### equals() 동일성과 동등성

- 동일성(Identity): == 연산자를 사용해서 두 객체의 참조가 동일한 객체를 가리키고 있는지 확인
- 동등성(Equality): equals() 메서드를 사용하여 두 객체가 논리적으로 동등한지 확인
    - 기본적으로는 == 를 사용해 두 객체의 참조값이 같은지를 비교한다. 내부의 값으로 비교하기 위해서는 오버라이딩이 필요하다
- 예시
    
    ```java
    // 두 객체는 참조값은 다르지만(동일성(X)) 객체안의 값은 같다(동등성O)
    User a = new User("id-100") //참조 x001
    User b = new User("id-100") //참조 x002
    ```
    
- Object 가 기본으로 제공하는 equals() 는 == 으로 동일성 비교를 제공한다.
    - 오버라이딩해서 사용해야한다 (command +N)
        
        ```java
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            UserV1 userV1 = (UserV1) o;
            return Objects.equals(id, userV1.id); // id로 비교 
        } 
        ```
        
    

## 섹션[2] 불변 객체 (20240801)

### 공유 참조와 사이드 이펙트

- 사이드 이펙트(Side Effect)는 프로그래밍에서 어떤 계산이 주된 작업 외에 추가적인 부수 효과를 일으키는 것
    
    ```java
    Address a = new Address("서울");
    Address b = a; // 참조값의 공유를 막을 수가 없다 
    ```
    

### 불변객체

객체의 상태(객체 내부의 값, 필드, 멤버 변수)가 변하지 않는 객체를 불변 객체(Immutable Object)라 한다.

- 필드를 final로 생성한다
- 불변 객체는 기존 값은 변경하지 않고 대신에 계산 결과를 바탕으로 새로운 객체를 만들어서 반환한다.
    
    ```java
     public ImmutableObj add(int addValue) {
    	 int result = value + addValue;
    	 return new ImmutableObj(result);
     }
    ```
    
- 참고 - withXxx()
불변 객체에서 값을 변경하는 경우 withYear() 처럼 "with"로 시작하는 경우가 많다
    
    원본 객체의 상태가 그대로 유지됨을 강조하면서 변경사항을 새 복사본에 포함하는 과정을 간결하게 표현
    

## 섹션[3] String (20240802)

- String은 참조형이다, 클래스임으로 필드와 메서드를 갖는다
    
    ```java
    String str1 = "hello"; //문자열 리터럴, 최적화를 위해  문자열 풀을 사용 
    String str1 = new String("hello"); //변경 
    ```
    
- == 는 참조값을 비교, equals는 안에 값을 비교(오버라이딩되있음)
    - 하지만 String str1 = "hello"; - 이렇게 문자열 리터럴 사용시 같은 hello를 만들면 문자열 풀에 있는 같은 참조값을 참조해서 == 도 True과 된다
- 고로 문자열 비교시에는 항상 equals를 사용하자
- String은 final이라 생성 이후에는 내부의 값을 바꿀 수 없다
- CharSequence 는 String , StringBuilder 의 상위 타입이다. 문자열을 처리하는 다양한 객체를 받
을 수 있다

### 주요 메서드

### 1. `indexOf(a, 2)`

**설명**: 문자열에서 지정된 값 `a`를 위치 `2`부터 검색하여 처음 발생하는 위치를 반환합니다.

**예제**:

```java
java코드 복사
String str = "Hello world!";
int index = str.indexOf('o', 2);
System.out.println(index); // 출력: 4

```

### 2. `substring`

**설명**: 문자열의 두 지정된 인덱스 사이의 문자들을 추출하여 새로운 문자열을 반환합니다.

**예제**:

```java
java코드 복사
String str = "Hello world!";
String part = str.substring(1, 5);
System.out.println(part); // 출력: "ello"

```

### 3. `trim`

**설명**: 문자열의 양 끝에서 공백을 제거합니다.

**예제**:

```java
java코드 복사
String str = "   Hello world!   ";
String trimmedStr = str.trim();
System.out.println(trimmedStr); // 출력: "Hello world!"

```

### 4. `replace`

**설명**: 문자열에서 지정된 값을 새 값으로 대체합니다.

**예제**:

```java
java코드 복사
String str = "Hello world!";
String newStr = str.replace("world", "there");
System.out.println(newStr); // 출력: "Hello there!"

```

### 5. `split`

**설명**: 문자열을 지정된 구분자를 기준으로 나누어 배열로 반환합니다.

**예제**:

```java
java코드 복사
String str = "Hello world!";
String[] arr = str.split(" ");
for (String word : arr) {
    System.out.println(word);
}
// 출력: "Hello"
// 출력: "world!"

```

### 6. `join`

**설명**: 배열의 모든 요소를 문자열로 결합합니다 (Java 8부터 사용 가능).

**예제**:

```java
java코드 복사
String[] arr = {"Hello", "world!"};
String joinedStr = String.join(" ", arr);
System.out.println(joinedStr); // 출력: "Hello world!"

```

### 7. `reverse`

**설명**: 문자열을 반전시킵니다 (StringBuilder 또는 StringBuffer를 사용하여 구현).

**예제**:

```java
java코드 복사
String str = "Hello world!";
String reversedStr = new StringBuilder(str).reverse().toString();
System.out.println(reversedStr); // 출력: "!dlrow olleH"

```

### StringBuilder - 가변 스트링

- StringBuilder 객체를 생성한다.
append() 메서드를 사용해 여러 문자열을 추가한다.
insert() 메서드로 특정 위치에 문자열을 삽입한다.
delete () 메서드로 특정 범위의 문자열을 삭제한다.
reverse() 메서드로 문자열을 뒤집는다.
마지막으로 toString 메소드를 사용해 StringBuilder 의 결과를 기반으로 String 을 생성해서 반환한
다.

```java
StringBuilder sb = new StringBuilder();
 sb.append("A");
```

- 문자열 합치기 최적화
    
    ```java
    StringBuilder sb = new StringBuilder();
     for (int i = 0; i < 100000; i++) {
    	 sb.append("Hello Java ");
     }
     String result = sb.toString();
    ```
    

### StringBuffer - 멀티스레드에서 사용

- StringBuilder 와 똑같은 기능을 수행하는 StringBuffer 클래스도 있다.
StringBuffer 는 내부에 동기화가 되어 있어서, 멀티 스레드 상황에 안전하지만 동기화 오버헤드로 인해 성능
이 느리다.
StringBuilder 는 멀티 쓰레드에 상황에 안전하지 않지만 동기화 오버헤드가 없으므로 속도가 빠르다.

### 메서드 체인닝 - Method Chaining

- 메서드 호출의 결과로 자기 자신의 참조값을 반환하면, 반환된 참조값을 사용해서 메서드 호출을 계속 이어갈 수 있다
- StringBuilder도 메서드 체이닝을 제공함

```java
private int value;
public ValueAdder add(int addValue) {
	value += addValue;
return this; // 이 부분이 핵심 
}

ValueAdder adder = new ValueAdder();
int result = adder.add(1).add(2).add(3).getValue()
 
 StringBuilder sb = new StringBuilder();
 String string = sb.append("A").append("B").append("C").append("D")
 .insert(4, "Java")
 .delete(4, 8)
 .reverse()
 .toString();
```