import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        var i = "yangliu";
        System.out.println(i);
        var j = 1;
        var list = new ArrayList<String>();
        System.out.println("hello world");

        var linked = new LinkedList();

        int[] ints = {1,2,3,4,5};
        System.out.println(squareOfSum(ints));

        IntAddDouble();
    }

    public static int squareOfSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            double pow = Math.pow(arr[i], 2);//java中的次方表示放式：Math.pow(2, 3); 2的3次方
            sum += pow;

        }
        return sum;
    }

    public static void IntAddDouble() {
        int i = 10;
        double d = 12.2;
        int r = 2;
        r += i * d;
        System.out.println(r);
    }
}
