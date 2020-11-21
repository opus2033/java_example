package My_First_Project;

import java.util.Optional;

public class test79 {
    public static void main(String [] args){
        Optional<String> opt = Optional.ofNullable("자바 옵셔널 객체");
        System.out.println(opt.get());

        System.out.println();

        Optional<String> opt2 = Optional.empty();
        System.out.println(opt2.orElse("빈 객체"));
        System.out.println(opt2.orElseGet(String::new));

    }
}
