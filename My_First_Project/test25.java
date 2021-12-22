package My_First_Project;

class Car3 {
    private String modelName = "G80";
    private int modelYear = 2019;
    private String color = "검정색";

    public String getModel() {
        return this.modelYear + "년식" + this.modelName + " " + this.color;
    }
}


public class test25 {
    public static void main(String[] args){
        Car3 myCar = new Car3();
        System.out.println(myCar.getModel());        
    }
}
