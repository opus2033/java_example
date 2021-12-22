package My_First_Project;

public class test47 {
    public static void main(String [] args){
        Integer num1 = 7; //박싱 
        Integer num2 = 3; //박싱

        int int1 = num1;
        int int2 = num2;

        Integer result1 = num1 + num2 ; // 10
        System.out.println(result1);
        Integer result2 = int1 - int2 ; // 4
        System.out.println(result2);
        int result3 = num1 * int2 ; // 21
        System.out.println(result3);
    }
}
