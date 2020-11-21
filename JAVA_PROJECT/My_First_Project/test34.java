package My_First_Project;

class Parent5 {
    int a;

    Parent5() { a = 10;}
    Parent5(int n) { a = n;}
}

class Child5 extends Parent5 {
    int b;
    Child5() {
        b = 20;
    }
    void display() {
        System.out.println(a);
        System.out.println(b);
    }
}

public class test34 {
    public static void main(String [] args){
        Child5 ch = new Child5();
        ch.display();
    }
}
