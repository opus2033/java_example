package My_First_Project;

import java.util.HashSet;
import java.util.Iterator;

public class test57 {
    public static void main(String [] args){
        HashSet<String> hs01 = new HashSet<String>();
        HashSet<String> hs02 = new HashSet<String>();

        hs01.add("이순신");
        hs01.add("홍길동");
        System.out.println(hs01.add("임꺽정"));
        System.out.println(hs01.add("임꺽정")); // 중복저장
        System.out.println(hs01);

        for (String e : hs01) {
            System.out.print(e + " ");
        }

        hs02.add("임꺽정");
        hs02.add("홍길동");
        hs02.add("이순신");

        System.out.println();
        Iterator<String> iter02 = hs02.iterator();
        while (iter02.hasNext()){
            System.out.print(iter02.next()+ " ");
        }
        System.out.println();
        System.out.println("집합의 크기 :" + hs02.size());
    }
}
