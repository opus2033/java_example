package My_First_Project;

class Method {
    int a = 10, b = 20;
    int add() { return a + b;}
    static int add(int x, int y) { return x + y;}
}

public class test28 {
    public static void main(String[] args){
        System.out.println(Method.add(40,50));
        Method myMethod = new Method();
        System.out.print(myMethod.add());
	}
}
