
package My_First_Project;

public class test19 {
    public static void main(String[] argv){
        int[] grade = new int[]{85,10,30,50,40,50,10,90,90,90};
        int sum = 0;

        for(int i=0;i<grade.length;i++){
            sum += grade[i];
        }
        System.out.println("합은 "+ sum);
        System.out.println("평균은"+ (sum/ grade.length));
    }
}
