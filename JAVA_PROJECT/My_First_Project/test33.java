package My_First_Project;

class Parent4 {
    int a = 10;
}

class Child4 extends Parent4{
    int a = 20;

    void display(){
        System.out.println(a);
        System.out.println(this.a);
        System.out.println(super.a);
    }
}
public class test33 {
    public static void main(String[] args){
        Child4 ch = new Child4();
        ch.display();
    }
}
