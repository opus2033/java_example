package My_First_Project;

class Test {
	static void display(int num1) { System.out.println(num1); }
	static void display(int num1, int num2) { System.out.println(num1 * num2); }
	static void display(int num1, double num2) { System.out.println(num1 + num2); }
}

public class test26 {
    public static void main(String[] args){
        Test mytest = new Test();
        mytest.display(10);
        mytest.display(10,20);
        mytest.display(10,3.14);
        mytest.display(10, 'a');
    }
}
