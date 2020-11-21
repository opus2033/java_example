package My_First_Project;

public class test16 {
    public static void main(String[] argv){
        for(int i = 1; i <= 100; i++){
            if(i % 5 ==0 || i %7 ==0){
                System.out.println(i);
            } else {
                continue;
            }
        }
    }
}
