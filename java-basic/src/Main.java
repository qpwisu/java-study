import ref.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
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
        System.out.println(student.a.get(0));
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
}