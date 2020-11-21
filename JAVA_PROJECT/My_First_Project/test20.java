package My_First_Project;

public class test20 {
    public static void main(String[] argv){
        int[][] arr = new int[2][3];

        int k =10;
        for(int i=0; i < arr.length; i++){
            for(int j=0; j < arr[i].length; j++){
                arr[i][j] =k;
                k += 10;
            }
        }

        for(int i = 0; i< arr.length; i++){
            for (int j =0; j < arr[i].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
