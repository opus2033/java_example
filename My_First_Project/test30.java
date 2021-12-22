package My_First_Project;

class Parent {
    private int a = 10;
    public int b = 20;
}

class Child extends Parent{
    public int c = 30;
    void display(){
        System.out.println(b);
        System.out.println(c);
    }
}

public class test30 {
    public static void main(String[] args){
        Child ch = new Child();
        ch.display();
    }
}
