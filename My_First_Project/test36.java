package My_First_Project;

class Parent7 { }
class Child7 extends Parent7 { }
class Brother7 extends Parent7 { }

public class test36 {
    public static void main (String [] args){
        Parent7 p = new Parent7();
		System.out.println(p instanceof Object);	// true
		System.out.println(p instanceof Parent7);	// true
		System.out.println(p instanceof Child7);		// false
		System.out.println();
		
		Parent7 c = new Child7();
		System.out.println(c instanceof Object);	// true
		System.out.println(c instanceof Parent7);	// true
		System.out.println(c instanceof Child7);		// true
    }
}
