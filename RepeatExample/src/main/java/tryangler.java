package RepeatExample.src.main.java;

import java.util.Scanner;

public class tryangler {
    public static void main(String[] argv){
        Scanner sc = new Scanner(System.in);
		System.out.println("삼각형의 높이를 입력해주세요. ");
		int height = sc.nextInt();
		
		//직각 삼각형 
		for(int i=1;i<=height;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print("*"); 
			}
			System.out.println(""); //줄바꿈 
		}
		
		System.out.println(""); //줄바꿈 
		
		//이등변삼각형
		for(int i=1;i<=height;i++) {
			for(int j=1;j<=height-i;j++) {
				System.out.print(" "); 
			}
			for(int j=1;j<=i;j++) {
				System.out.print("*"); 
			}
			for(int j=1;j<i;j++) {
				System.out.print("*"); 
			}
			System.out.println(""); //줄바꿈 
		}

    }
    
}
