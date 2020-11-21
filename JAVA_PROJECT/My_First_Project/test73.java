package My_First_Project;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class test73 {
    public static void main(String [] args){
        IntStream stream = new Random().ints(4);
        stream.forEach(System.out::println);

    }
}
