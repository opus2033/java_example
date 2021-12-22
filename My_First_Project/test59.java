package My_First_Project;

import java.util.Iterator;
import java.util.TreeSet;

public class test59 {
    public static void main(String[] args){
        TreeSet<Integer> ts = new TreeSet<Integer>();

        ts.add(30);
        ts.add(40);
        ts.add(20);
        ts.add(10);

        for (int e : ts) {
            System.out.print(e + " ");
        }
        ts.remove(40);

        Iterator<Integer> iter = ts.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        System.out.println("이진 검색 트리의 크기 : " + ts.size());

        System.out.println(ts.subSet(10, 20));

        System.out.println(ts.subSet(10, true, 20, true));
    }
}
