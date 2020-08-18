package chapter05.testFuture;

public class TestStatus {
    public static void main(String[] args) {
        System.out.println(-1 << 32);
        System.out.println(-1 << 29);
        System.out.println(1 << 29);
        System.out.println((1 << 29) - 1);
        System.out.println(~((1 << 29) - 1));
    }
}
