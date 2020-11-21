package My_First_Project;

enum Rainbow { RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET }
enum Rainbow2 { 
    RED(3), ORANGE(10), YELLOW(21), GREEN(5), BLUE(1), INDIGO(-1), VIOLET(-11);

    private final int value;
    Rainbow2(int Value) {this.value = value; }
    public int getValue() { return value;}
}
public class test48 {
    public static void main(String[] args){
        // Rainbow[] arr = Rainbow.values();
        // for (Rainbow rb : arr) {
        //     System.out.println(rb);   -> value 메소드 예제

        // Rainbow rb = Rainbow.valueOf("GREEN");
        // System.out.println(rb);  -> valueOf 메소드 예제

        System.out.println(Rainbow.YELLOW.ordinal());
        }
    }
// }