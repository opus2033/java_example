package My_First_Project;

import java.util.function.*;

public class test70 {
    public static void main(String [] args){
        DoubleUnaryOperator oper;

        oper = (n) -> Math.abs(n); // 람다표현식
        System.out.println(oper.applyAsDouble(-5));

        oper = Math::abs;
        System.out.println(oper.applyAsDouble(-5));
    }
}
