package _10_static.staticInitialization;

/**
 * describe:
 *
 * @author 梦合九千
 * @date 2019/1/8 8:28
 */

class A {
    // 静态成员和静态代码块，谁写在前面谁先执行
    private static A a = new A();
    static {
//        a = new A();
        System.out.println("static");
    }
    public A() {
        System.out.println("A 构造");
    }
    {
        System.out.println("A1");
    }

}

public class B extends A {
    public B() {
        System.out.println("B");
    }

    public static void main(String[] args) {
        System.out.println("0000");
        B b = new B();
    }

}
