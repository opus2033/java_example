package My_First_Project;

import java.time.LocalDate;

public class test5 {
    public static void main(String[] argv){
        LocalDate today = LocalDate.now();
        System.out.println("올해는" + today.getYear()+ "년입니다");

        LocalDate otherDay = today.withYear(1982);
        System.out.println("올해는" + otherDay.getYear()+ "입니다");
    }
}
