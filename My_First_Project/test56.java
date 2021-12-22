package My_First_Project;

import java.util.LinkedList;

public class test56 {
    public static void main(String [] args){
        LinkedList<String> qu = new LinkedList<String>();

        qu.add("넷");
        qu.add("둘");
        qu.add("셋");
        qu.add("하나");

        // peek 메소드를 이용해서 반환하기
        System.out.println(qu.peek());
        System.out.println(qu);
        System.out.println();

        //poll 메소드를 이용해서 반환하기
        System.out.println(qu.poll());
        System.out.println(qu);
        System.out.println();

        //remove 메소드를 이용해서 요소를 제거하기
        qu.remove("하나");
        System.out.println(qu);

    }
}
