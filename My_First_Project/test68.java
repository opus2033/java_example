package My_First_Project;

public class test68 {
    public static void main(String [] args){
        new Thread(() -> {
            System.out.println("람다표현식 이용");
        }).start();
    }
}