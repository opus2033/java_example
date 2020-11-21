package My_First_Project;

import java.util.*;

class LandAnimal {
    public void crying(){ 
        System.out.println("육지동물");
    }
}
class Cat3 extends LandAnimal { 
    public void crying(){ 
        System.out.println("냐옹");
    }
}
class Dog3 extends LandAnimal {
     public void crying(){ 
        System.out.println("멍멍");
    }
}
class Sparrow { 
    public void crying(){ 
        System.out.println("짹짹");
    }
}

// 제네릭 선언

class AnimalList<T extends LandAnimal> {
    ArrayList<T> al = new ArrayList<T>();

    void add(T animal) { 
        al.add(animal);
    }
    T get(int index) {
        return al.get(index);
    }
    boolean remove(T animal) { 
        return al.remove(animal);
    }
    int size() { 
        return al.size();
    }
}


public class test52 {
    public static void main(String [] args){
        AnimalList<LandAnimal> landAnimal = new AnimalList<>();

        landAnimal.add(new LandAnimal());
        landAnimal.add(new Cat3());
        landAnimal.add(new Dog3());
        
        for (int i = 0; i < landAnimal.size(); i++){
        landAnimal.get(i).crying();
        }
    }
}
