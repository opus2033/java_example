package My_First_Project;

import java.util.Arrays;
import java.util.stream.Stream;

public class test72 {
    public static void main(String [] args){
        String[] arr = new String[]{"넷","둘","셋","하나"};
        Stream<String> stream1 = Arrays.stream(arr);
        stream1.forEach(e -> System.out.print(e + " "));
        System.out.println();

        Stream<String> stream2 = Arrays.stream(arr,1,3);
        stream2.forEach(e -> System.out.print(e + " "));
        System.out.println();
        
        Stream<Double> stream3 = Stream.of(4.2,2.5,3.1,1.9);
        stream3.forEach(System.out::println);
    }
}
