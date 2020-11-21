package RepeatExample.src.main.java;

import java.util.Scanner;

public class RepeatExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(;;) {
            String word = sc.next();
            System.out.println("입력값: " + word);

            if(word.equals("종료")) {
                break;
            }
        }
    }
}

