package My_First_Project;

abstract class Animal { abstract void cry(); }
class Cat extends Animal { void cry(){ System.out.println("야옹");}}
class Dog extends Animal { void cry() { System.out.println("멍멍");}}

public class test37 {
    public static void main(String [] args){
        Cat c = new Cat();
        Dog d = new Dog();


        c.cry();
        d.cry();
    }
}
