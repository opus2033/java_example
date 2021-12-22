package My_First_Project;

import java.util.Arrays;

public class test49 {
    public static void main(String [] args){
        int[] arr = new int[1000];
        for(int i=0; i < arr.length; i++){
            arr[i] = i;
            System.out.println(arr[i]+ " ");
        }
        System.out.println(Arrays.binarySearch(arr, 437));
    }
}
