package My_First_Project;

public class test12 {
    public static void main(String[] argv){
        char ch = '아';

        if(ch >= 'a' && ch <= 'z'){
            System.out.println("해당 문자는 영문 소문자 입니다.");
        } else if (ch >= 'A' && ch <= 'Z'){
            System.out.println("아닙니다");
        } else {
            System.out.println("영어아님");
        }
    }
}
