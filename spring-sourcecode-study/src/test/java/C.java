/**
 * 创建人：yang.liu
 * 创建时间：2019/7/26 20:15
 * 版本：1.0
 * 内容描述：
 */
public class C extends B {
    public void c() {
        printA();
    }

    public static void main(String[] args) {
        C c = new C();
        c.c();
    }
}
