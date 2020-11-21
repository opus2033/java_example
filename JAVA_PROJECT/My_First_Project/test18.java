package My_First_Project;

public class test18 {
    public static void main(String[] argv){
        int[] grade1 = {70,80,90};
        for(int i=0;i<grade1.length;i++){
            System.out.print(grade1[i] + " ");
        }
        
        System.out.println();

        int[] grade2 = new int[]{70,80,90};
        for(int i=0;i<grade2.length;i++){
            System.out.print(grade2[i] + " ");
        }

        System.out.println();
        
        // int[] grade3;
        // for(int i=0;i<grade3.length;i++){
        //     System.out.println(grade3[i] + " ");
        // }

        int[] grade4;
        grade4 = new int[]{70,80,90};
        for(int i=0;i<grade4.length;i++){
            System.out.print(grade4[i] + " ");
        }
    }
}
