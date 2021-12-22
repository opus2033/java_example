package My_First_Project;

public class test21 {
    public static void main(String[] argv){
        int[][] arr = {
            {10,20,30},
            {40,50,60}
        };
        
        for (int i=0; i< arr.length; i++) {
            for (int j =0; j< arr[i].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
