package My_First_Project;

public class test17 {
    public static void main(String[] argv){
        int[] grade1 = new int[3]; // 길이가 3인 int형 배열선언과 생성
        int[] grade2 = new int[3]; // 똑같음

        grade1[0] = 85;
        grade1[1] = 65;
        grade2[2] = 90;

        grade2[0] = 85;

        for (int i = 0; i < grade1.length; i++){
            System.out.print(grade1[i] + " ");
        }
        
        System.out.println();

        for(int i=0;i<grade2.length;i++){
            System.out.print(grade2[i] + " ");
        }
    }
}
