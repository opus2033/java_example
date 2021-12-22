package My_First_Project;

class Parent1 {
    private int a = 10;
    public int b = 20;
}

class Child1 extends Parent1 {
    public int c = 30;
    void display() {
        System.out.println(b);
        System.out.println(c);
    }
}


public class test31 {
    public static void main(String[] args){
        Child ch2 = new Child();
        ch2.display();
    }
}
