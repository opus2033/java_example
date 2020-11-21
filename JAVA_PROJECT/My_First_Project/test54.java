package My_First_Project;
import java.util.*;

public class test54 {
    public static void main(String [] args ){
        ArrayList<Integer> arrList = new ArrayList<Integer>();

        arrList.add(40);
        arrList.add(30);
        arrList.add(20);
        arrList.add(10);

        for ( int i = 0; i < arrList.size(); i++){
            System.out.print(arrList.get(i) + " ");
        }
        System.out.println();
        arrList.remove(1);
        
        // Enhanced for 문과 get 메소드를 이용한 출력
        for(int e: arrList) {
            System.out.print(e + " ");
        }
        System.out.println();

        Collections.sort(arrList);

        Iterator<Integer> iter = arrList.iterator();
        while (iter.hasNext()){
            System.out.print(iter.next()+ " ");
        }

        arrList.set(0,20);
        System.out.println();

        for ( int e: arrList) {
            System.out.print(e + " ");
        }

        System.out.println("리스트의 크기 :" + arrList.size());
    }
}