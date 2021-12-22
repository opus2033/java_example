package My_First_Project;



public class test41 {
    public static void main(String[] args){
        String str = new String("abcd");
        System.out.println(" 원본문자열 : " + str);

        System.out.println(str.compareTo("bcef"));
        System.out.println(str.compareTo("abcd"));

        System.out.println(str.compareTo("ABCD"));
        System.out.println(str.compareToIgnoreCase("Abcd"));
        System.out.println("compareTo() 메소드 호출 후 원본 문자열 : " + str);
    }
}
