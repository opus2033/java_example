package My_First_Project;
import java.util.*;

class Car5 implements Cloneable {
	private String ModelName;
	private ArrayList<String> owners = new ArrayList<String>();

	public String getModelName() { return this.ModelName;}
	public void setModelName(String modelName) { this.ModelName = modelName;}

	public ArrayList getOwners() { return this.owners;}
	public void setOwners(String ownerName) { this.owners.add(ownerName);}

	public Object clone() {
		try {
			Car5 cloneCar5 = (Car5)super.clone();
			return cloneCar5;
		} catch (CloneNotSupportedException ex) {
			ex.printStackTrace();
			return null;
		}
	}
}


public class test39 {
    public static void main (String [] args){
        Car5 car01 = new Car5();

		car01.setModelName("아반떼");
		car01.setOwners("홍길동");
		System.out.println("Car01 : " + car01.getModelName() + ", " + car01.getOwners() + "\n");
		
		Car5 car02 = (Car5)car01.clone();
		car02.setOwners("이순신");
		System.out.println("Car01 : " + car01.getModelName() + ", " + car01.getOwners());
		System.out.println("Car02 : " + car02.getModelName() + ", " + car02.getOwners());
    }
}
