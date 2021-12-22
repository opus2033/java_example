package My_First_Project;

class Parent6{
    void display() { System.out.println("부모 클래스의 메소드입니다.");}
}

class Child6 extends Parent6{
    void display() { System.out.println("자식 클래스의 메소드 입니다.");}
}

public class test35 {
    public static void main(String [] args){
        Parent6 pa = new Parent6();
        pa.display();
        Child6 ch = new Child6();
        ch.display();
        Parent6 pc = new Child6();
        pc.display();
    }
}
