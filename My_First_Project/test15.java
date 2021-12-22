package My_First_Project;


import java.util.Arrays;
public class test15 {
    public static void main(String[] argv){
        int[] arr1 = new int[]{1,2,3,4,5};
        int newLen = 10;

        // 1. System 클래스의 arraycopy() 메소드
        int[] arr2 = new int[newLen];
        System.arraycopy(arr1, 0, arr2, 0, arr1.length);

        for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}
		System.out.println();
        // 2. arrays 클래스의 copyOf() 메소드
        int[] arr3 = Arrays.copyOf(arr1, 10);
        for (int i = 0; i < arr3.length; i++) {
			System.out.print(arr3[i] + " ");
		}
		System.out.println();
        // 3. object 클래스의 clone() 메소드
        int[] arr4 = (int[])arr1.clone();
        for (int i = 0; i < arr4.length; i++) {
			System.out.print(arr4[i] + " ");
		}
		System.out.println();
        // 4. for 문과 인덱스를 이용한 복사
        int[] arr5 = new int[newLen];
        for (int i = 0; i < arr5.length; i++) {
			System.out.print(arr5[i] + " ");
		}
		System.out.println();
    }
}
