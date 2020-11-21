package My_First_Project;

public class test2 {
	public static void main(String[] args){
		new Thread(new Runnable() {
			public void run() {
				System.out.println("전통적인 방식의 일회용 스레드 생성");
			}
		}).start();
		
		new Thread(()->{
			System.out.println("람다 표현식을 사용한 일회용 스레드 생성");
		}).start();
	}
}