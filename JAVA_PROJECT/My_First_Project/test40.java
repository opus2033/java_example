package My_First_Project;



public class test40 {
    public static void main (String [] args){
        String str = new String("Java");
        System.out.println("원본 문자열 : " + str);

        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i)+ " ");
        }
        System.out.println(str);
    }
}
