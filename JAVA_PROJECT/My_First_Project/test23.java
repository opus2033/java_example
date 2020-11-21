package My_First_Project;

class Car {
    private int currentSpeed;
    private int accelerationTime;

    public void accelerate(int speed, int second) {
        System.out.println(second + "초간 시속 " + speed + "로가속함");
    }
}

public class test23 {
	public static void main(String[] args) {
		Car myCar = new Car();		// 객체 생성
		myCar.accelerate(60, 3);	// 메소드 호출
	}
}