package My_First_Project;

public class test22 {
    public static void main(String[] args){
        int[][] arr = {
            {10,20},
            {10,20,30,40},
            {10}
        };

        for(int i = 0; i < arr.length; i++) {
            for(int j=0; j < arr[i].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}