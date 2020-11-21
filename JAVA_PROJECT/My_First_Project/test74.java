package My_First_Project;

import java.util.stream.IntStream;
import java.util.Arrays;
import java.util.stream.*;

public class test74 {
    public static void main(String [] args){
        IntStream stream1 = IntStream.of(7,5,5,2,1,2,3,5,4,6);
        IntStream stream2 = IntStream.of(7,5,5,2,1,2,3,5,4,6);
    
        stream1.distinct().forEach(e -> System.out.print(e + " "));
        System.out.println();

        stream2.filter(n -> n% 2 !=0).forEach(e -> System.out.print(e + " "));
        System.out.println();

        Stream<String> stream3 = Stream.of("HTML","PYTHON","JAVA","SCALA");
        stream3.map(s -> s.length()).forEach(System.out::print);
        System.out.println();

        String [] arr = {"I study hard", "You study JAVA AND SCLA", "I AM HUNGRY"};

        Stream<String> stream = Arrays.stream(arr);
        stream.flatMap(s -> Stream.of(s.split(" + "))).forEach(System.out::println);
    }
}
