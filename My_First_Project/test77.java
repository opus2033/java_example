package My_First_Project;

import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.*;

public class test77 {
    public static void main(String [] args){
        Stream<String> stream = Stream.of("넷","둘","셋","하나");
        Stream<String> stream2 = Stream.of("넷", "둘", "셋", "하나");

        // stream.forEach(System.out::println);

        Optional<String> result1 = stream.reduce((s1, s2) -> s1 + "++" + s2);
        result1.ifPresent(System.out::println);

        String result2 = stream2.reduce("시작", (s1,s2)-> s1 + " ++" + s2);
        System.out.println(result2);
    }
}
