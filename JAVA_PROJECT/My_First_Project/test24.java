package My_First_Project;

class Car2 {
    private String modelName;
    private int modelYear;
    private String color;
    private int maxSpeed;
    private int currentSpeed;

    Car2(String modelName, int modelYear, String color, int maxSpeed) {
        this.modelName = modelName;
        this.modelYear = modelYear;
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.currentSpeed = 0;
    }

    public String getModel() {
        return this.modelYear + "년식" + this.modelName + " " + this.color;
    }
}

public class test24 {
    public static void main(String[] args){
        Car2 yunCar = new Car2("G80", 2020 , "녹색", 340);
        System.out.println(yunCar.getModel());
    }
}
