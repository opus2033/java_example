package My_First_Project;

import java.io.IOException;

public class test62 {
    public static void main(String [] args){
        byte[] list = {'a', 'b', 'c'};

        try {
            System.out.write(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
