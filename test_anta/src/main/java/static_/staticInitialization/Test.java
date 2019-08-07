package static_.staticInitialization;

/**
 * describe:
 *
 * @author 梦合九千
 * @date 2019/1/8 8:59
 */
public class Test {
    static {
        _i = 20;
    }
    public static int _i = 10;

    public static void main(String[] args) {
        System.out.println(_i);
    }
}
