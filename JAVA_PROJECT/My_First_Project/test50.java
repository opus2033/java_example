package My_First_Project;

import java.util.Arrays;

// import java.util.*;

public class test50 {
    public static void main (String [] args){
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = Arrays.copyOf(arr1, 3);

        for (int i = 0; i <arr2.length; i++)
        System.out.print(arr2[i] + " ");
        

        System.out.println(" ");

        int[] arr3 = Arrays.copyOf(arr1, 10);
        for (int i = 0; i < arr3.length; i++)
        System.out.print(arr3[i] + " "); 

        System.out.println(" ");

        int[] arr4 = Arrays.copyOfRange(arr1, 2, 4);
        for ( int i = 0; i < arr4.length; i++)
            System.out.print(arr4[i]+ " ");

        System.out.println(" ");

        int[] arr5 = new int[10];
        Arrays.fill(arr5, 9);
        for ( int i = 0; i < arr5.length; i++)
            System.out.print(arr5[i]+ " ");
        

        System.out.println(" ");
        
        int[] arr6 = {4,6,7,2,8,1,24,99,8,4,3,43,2};
        Arrays.sort(arr6);
        for ( int i =0 ; i < arr6.length; i++)
            System.out.print(arr6[i]+ " ");  
    }
}