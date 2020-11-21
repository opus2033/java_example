package My_First_Project;


@FunctionalInterface
        interface Calc {
            public int min(int x, int y);
        }

public class test4 {
    public static void main(String[] argv){
            Calc minNum = (x,y) -> x < y ? x: y;
            System.out.println(minNum.min(1,50));
        }
    }