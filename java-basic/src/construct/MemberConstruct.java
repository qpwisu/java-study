package construct;

public class MemberConstruct {
    String name;
    int age;
    int grade;

    //추가
    MemberConstruct(String name, int age) {
        this(name, age, 50); //변경
    }

    MemberConstruct(String name2, int age, int grade) {
        System.out.println("생성자 호출 name=" + name2 + ",age=" + age + ",grade=" + grade);
        name = name2;
        this.age = age;
        this.grade = grade;
    }
}
