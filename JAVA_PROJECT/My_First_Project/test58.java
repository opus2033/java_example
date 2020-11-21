package My_First_Project;
import java.util.*;
class Animal5 {
	String species;
	String habitat;
	
	Animal5(String species, String habitat) {
		this.species = species;
		this.habitat = habitat;
	}
	
	public int hashCode() {
		return (species + habitat).hashCode();
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Animal5) {
			Animal5 temp = (Animal5)obj;
			return species.equals(temp.species) && habitat.equals(temp.habitat);
		} else {
			return false;
		}
	}
}
public class test58 {
    public static void main(String [] args){
        HashSet<Animal5> hs = new HashSet<Animal5>();
		
		hs.add(new Animal5("고양이", "육지"));
		hs.add(new Animal5("고양이", "육지"));
		hs.add(new Animal5("고양이", "육지"));
		
		System.out.println(hs.size());
    }
}
