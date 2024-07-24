package poly.basic;

public class CastingMain1 {

    public static void main(String[] args) {
        //부모 변수가 자식 인스턴스 참조(다형적 참조)
        Parent poly = new Child(); //x001
        //단 자식의 기능은 호출할 수 없다. 컴파일 오류 발생
        //poly.childMethod();
        poly.parentMethod();
        // 자식 변수가 부모 인스턴스를 참조하는것은 불가
        // Child child1 = new Parent(); // 자식 타입에 부모를 담을 수없다 new Parent()에는 child에 대한 객체정보가 없다

        //다운캐스팅(부모 타입 -> 자식 타입)
        Child child = (Child) poly; //x001
        child.childMethod();
        child.parentMethod();

        // 다운캐스팅 실패(자식타입에 자식 인스턴스가 들어있는 경우)
        Child child2 = new Child();
        Parent parent2 = new Parent();
        //child2 = (Child) parent2; // (다운 캐스팅 실패) parent가 위치한 메모리에 child에 대한 객체 정보가 없다


        // 업캐스팅 (자식 타입 -> 부모타입)
        // Child child1 = new Parent(); // 자식 타입에 부모를 담을 수없다 new Parent()에는 child에 대한 객체정보가 없다
        Child child3 = new Child();
        Parent parent3 = new Parent();
        parent3 = (Parent) child3; // (업 캐스팅) 부모는 자식을 품을 수 있다
        parent3.parentMethod();
        //parent3.childMethod(); // 사용 불가
    }
}
