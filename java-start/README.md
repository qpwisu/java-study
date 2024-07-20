# (20240719) 완

### 섹션[1]

---

- 주석 한줄 // 여러줄 /* */

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/720abf95-7e09-46c8-8ccd-ff391e9ecc90/297df668-abb4-4505-8be5-c5e2eceb1a27/Untitled.png)

### 섹션[2] 변수

---

**타입** 

- byte : -128 ~ 127 (1byte, 2⁸)
- short : -32,768 ~ 32,767 (2byte, 2¹⁶)
- int : -2,147,483,648 ~ 2,147,483,647 (약 20억) (4byte, 2³²)
- long : -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807 (8byte, 2⁶⁴)
실수형
- float : 대략 -3.4E38 ~ 3.4E38, 7자리 정밀도 (4byte, 2³²)
- double : 대략 -1.7E308 ~ 1.7E308, 15자리 정밀도 (8byte, 2⁶⁴)
기타
- boolean : true , false (1byte)
- char : 문자 하나(2byte)
- String : 문자열을 표현한다. 메모리 사용량은 문자 길이에 따라 동적으로 달라진다. (특별한 타입이다. 자
세한 내용은 뒤에서 학습한다)

**실무 사용** 

- byte,short는 너무 짧아 대신 int 사용
- float는 길이와 정밀도가 낮다 대신 double 사용
- char 문자 하나 대신 String 사용
- 메모리 비용은 매우 저렴

**규칙** 

- 변수,메서드 : 소문자 시작 낙타 표기법 myAccount , 메소드는 일반적으로 동사로 시작
    
    변수명 예): customerName , totalSum , employeeCount , isAvailable
    메서드명 예): printReport() , calculateSum() , addCustomer() 
    
- 클래스 : 대문자
- 패키지 : 모두 소문자
- 상수 : 모두 대문자 + _ (USER_LIMIT)

## 섹션[3] 연산자

**조건문** 

```java
 int age = 14;
 if(age <= 7) { //~7: 미취학
	 System.out.println("미취학");
 } else if(age <= 13) { //8~13: 초등학생
	 System.out.println("초등학생");
 } else { //20~: 성인
	 System.out.println("성인");
 }
```

**switch** 

```java
switch (조건식) {
 case value1:
 // 조건식의 결과 값이 value1일 때 실행되는 코드
 break;
 case value2:
 // 조건식의 결과 값이 value2일 때 실행되는 코드
 break;
 default:
 // 조건식의 결과 값이 위의 어떤 값에도 해당하지 않을 때 실행되는 코드
 }
```

- switch 문은 break 문이 없으면 계속 이어서 실행된다, default 문은 제외

**삼항연산자** 

- (조건) ? 참_표현식 : 거짓_표현식

```java
String status = (age >= 18) ? "성인" : "미성년자"; //age=18
```

## 섹션[5] 반복문

---

```java
# while 
while(조건식){}

# do-while 조건에 상관없이 한번은 실행 
do {
 // 코드
} while (조건식);

# for (초기식; 조건식; 증감식) for (int i = 1; i <= 10; i++) {
# for (; ; )  - 무한 반복 

// 배열 반복문 
for (int number : numbers) {}
```

## 섹션[6] 스코프, 형변환

**형변환**

- 자동 형변환
    - int < long < double 같이 작은 범위에서 큰 범위는 자동으로 형변환 가능
    - 반대로 double을 int로 자동 형변환은 안됨
    
- 명시적 형변환
    - 큰 범위에서 작은 범위로 변환 할때 사용
    - 큰 범위(double)과 작은 범위(int)로 계산하면 큰범위로 결과 나옴
    
    ```java
            int a = 3;
            double b = 2;
            double c =  a/b ; / int면 오류 a,b 둘중 큰 범위로 자료형 결정
            
            double d = (double) a
            
            double div2 = 3 / 2; //int / int 이경우 결과가 1로 나온다 둘 중 하나에 (double)로 형변환해야 1.5
    ```
    
- 문자열 형변환
    - 기본 자료형→문자열 : String.valueOf(), Double.toString()
        
        ```java
                int intValue = 100;
                double doubleValue = 123.45;
                boolean boolValue = true;
        
                // 기본 자료형을 문자열로 변환
                String intString = String.valueOf(intValue);
                String doubleString = String.valueOf(doubleValue);
                String boolString = String.valueOf(boolValue);
        
                // 또 다른 방법: Integer.toString(), Double.toString(), Boolean.toString() 등 사용
                String intString2 = Integer.toString(intValue);
                String doubleString2 = Double.toString(doubleValue);
                String boolString2 = Boolean.toString(boolValue);
        ```
        
    - 문자열→ 기본 자료형 : Double.parseDouble()
        
        ```java
                String intString = "100";
                String doubleString = "123.45";
                String boolString = "true";
        
                // 문자열을 기본 자료형으로 변환
                int intValue = Integer.parseInt(intString);
                double doubleValue = Double.parseDouble(doubleString);
                boolean boolValue = Boolean.parseBoolean(boolString);
        ```
        

## 섹터[7] 훈련

scanner

```java
import java.util.Scanner;

Scanner scanner = new Scanner(System.in);
String str = scanner.nextLine(); // 입력을 String으로 가져옵니다.
int intValue = scanner.nextInt(); // 입력을 int로 가져옵니다.
double doubleValue = scanner.nextDouble(); // 입력을 double로 가져옵니다.

System.out.print("1"); // 줄바꿈 없음.
System.out.println("2"); //줄바꿈.
System.out.println(); //한 행이 끝나면 라인을 변경한다.
```

## 섹터[8] 배열

---

배열 초기화 

- 숫자는 0 , boolean 은 false , String 은 null (없다는 뜻이다.)로 초기화 된다.

선언

```java
// 배열 선언후 초기화
int[] students;
students = new int[]{1,2,3,4,5};

//선언 초기화 동시에
int[] students2 = new int[]{1,2,3,4,5};

// 크기 선언 후에는 인덱스로 값 채워 넣어야함  
students = new int[5]; 
students[0] = 1;
students[1] = 2;

```

기본형 vs 참조형

- 기본형 : 사용값을 직접 넣음(int,long)
- 참조형 메모리의 참조값을 넣음 (배열) # 동적 메로리 할당

이차원 배열 

```java
int[][] arr = new int[2][3]
```

배열 for 문 

```java
for (int number : numbers) {}
```

## 세션[9] 메소드

```java
public static int add(int a, int b) {
 //메서드 본문, 실행 코드
}
제어자 반환타입 메서드이름(매개변수 목록) {
 메서드 본문
}
```