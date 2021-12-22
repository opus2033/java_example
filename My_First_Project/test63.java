package My_First_Project;

import java.io.IOException;
import java.io.RandomAccessFile;

public class test63 {
    public static void main(String [] args){
        try {
            RandomAccessFile file = new RandomAccessFile("data.txt", "rw");
            System.out.println(file.getFilePointer());
            file.writeInt(10);
            System.out.println(file.getFilePointer());
            file.seek(20);
            System.out.println(file.getFilePointer());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
