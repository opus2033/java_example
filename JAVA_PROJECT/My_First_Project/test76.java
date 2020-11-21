package My_First_Project;

import java.util.Comparator;
import java.util.stream.Stream;

public class test76 {
    public static void main(String [] args){
        Stream<String> stream1 = Stream.of("JAVA", "HTML", "JAVASCRIPT", "CSS");
        Stream<String> stream2 = Stream.of("JAVA", "HTML", "JAVASCRIPT", "CSS");
        
        stream1.sorted().forEach(s -> System.out.print(s + "  "));
        System.out.println();

        stream2.sorted(Comparator.reverseOrder()).forEach(s -> System.out.print(s + " "));
    }
}
