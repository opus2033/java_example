package My_First_Project;
import java.util.Stack;
public class test55 {
    public static void main(String [] args){
        Stack<Integer> st = new Stack<Integer>();

        st.push(4);
        st.push(2);
        st.push(3);
        st.push(1);

        // peek 으로 꺼내기
        System.out.println(st.peek());
        System.out.println(st);
        System.out.println();
        // pop으로 꺼내기
        System.out.println(st.pop());
        System.out.println(st);
        System.out.println();
        // search로 검색하기
        System.out.println(st.search(4));
        System.out.println(st.search(3));
        System.out.println();
    }
}
