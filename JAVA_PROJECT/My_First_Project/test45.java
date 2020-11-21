package My_First_Project;

public class test45 {
    public static void main(String [] args){
        // StringBuffer str = new StringBuffer("Java");
        // System.out.println("원본 문자열 :" + str);

        // System.out.println(str.append("수업"));
        // System.out.println(str);

        StringBuffer str01 = new StringBuffer();
        StringBuffer str02 = new StringBuffer("Javaaaaaaaaaaaaaa");

        System.out.println(str01.capacity());
        System.out.println(str02.capacity());
        System.out.println(" ");
        System.out.println(str02.delete(3,10));
        System.out.println(str02.deleteCharAt(0));
        System.out.println("후에 문자열 " + str02);
        System.out.println( " ");
        System.out.println(str02.insert(0, "nono"));
        System.out.println("후 문자열 : " + str02);

    }
}
