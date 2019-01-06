package core1.chapter06;

/**
 * describe: 测试接口的一些特性
 *
 * @author 梦合九千
 * @date 2019/1/6 10:13
 */
interface Animal {
    public int i = 1;
    public Object m1 = new Object();
    public static void callMember() { System.out.println(new Object()); }
    // default void call2() { System.out.println(new Object()); }
}

interface Animal2 {
    // 修饰符时public static final
    public static final Object m1 = new Object();
    public static void callMember() { System.out.println(new Object()); }

    // 修饰符时public abstract
    void call1();
    // 修饰符是 default
    default void call2() { System.out.println(new Object()); }
}

class A {


    public static void callMember() { System.out.println("父类方法和接口方法冲突，父类优先"); }
    public void call2() { System.out.println("父类方法和接口方法冲突，父类优先2"); }
}

public class InterfaceTest extends A implements Animal, Animal2{

    public static void main(String[] args) {
        callMember();
        InterfaceTest i = new InterfaceTest();
        i.call2();
        // InterfaceTest.callMember(); 编译不通过
        int i1 = Animal.i;
        int i2 = InterfaceTest.i;
        System.out.println("接口中成员在接口中和子类中都可以访问？" + (i1 == i2)); // true
        System.out.println("接口中静态函数只能在接口中可以访问");
    }

    @Override
    public void call1() {}



//    // Animal, Animal2两个接口都有同样的方法，子类必须重写
//    @Override
//    public void call2() {}
}
