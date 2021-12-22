package My_First_Project;

import java.io.File;

public class test64 {
    public static void main(String [] args){
        File dir = new File("C:\\data");
        File file = new File(dir, "data.txt");
        if(!file.exists()) {
            System.out.println("파일이 존재하지 않습니다.");
            System.exit(0);
        }

        System.out.println(file.getPath());
        System.out.println(file.length());
    }
}
