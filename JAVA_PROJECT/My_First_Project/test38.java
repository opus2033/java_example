package My_First_Project;

interface Animal2 { public abstract void cry();}
interface Pet { public abstract void play();}

class Cat2 implements Animal2 {
    public void cry(){
        System.out.println("야옹");
    }
    public void play() {
        System.out.println("놀자고양이");
    }
}

class Dog2 implements Animal2 {
    public void cry(){
        System.out.println("멍멍");
    }
    public void play(){
        System.out.println("놀자강아지");
    }
}

public class test38 {
    public static void main (String[] args){
        Cat2 ca = new Cat2();
        Dog2 d = new Dog2();

        ca.cry();
        ca.play();
        d.cry();
        d.play();
        
    }
}
