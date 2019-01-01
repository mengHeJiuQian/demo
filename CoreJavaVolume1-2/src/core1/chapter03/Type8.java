package core1.chapter03;

import java.io.Console;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

/**
 * describe: 八大基本类型
 *
 * @author 梦合九千
 * @date 2018/12/31 20:24
 */
strictfp interface A {

}
public class Type8 {

    public static strictfp void main(String[] args) {
        // ----- 整型 -----
        // 二进制，“_”让人更易读，Java编译器会去除这些下划线
        int bin = 0B1_0;
        // 八进制
        int eightBinary = 01_0;
        // 十六进制
        int hex = 0X1_0;
        System.out.println(bin);
        System.out.println(eightBinary);
        System.out.println(hex);


        // ----- 浮点类型 -----
        System.out.println(0.125);
        // 0.125的另一种表示方式
        // 0x表示十六进制表示法，1是十六进制的1（尾数），p表示十进制3（指数），基数是2。
        System.out.println(0x1.0p-3); // 1 * （2的-3次方）
        System.out.println(0x1p-3);
        System.out.println(0x11p-4);  // 17 * （2的-4次方）
        Double d1 = 0.0d / 0.0;
        // System.out.println(d1 == Float.NaN); // false，所有“非数值”的值都认为是不相同的
        System.out.println(d1 == Double.NaN); // false，所有“非数值”的值都认为是不相同的
        System.out.println( Double.isNaN(d1)); // false


        // ----- 字符类型 -----
        System.out.println('\u2122'); // ™
        System.out.println('\u03C0'); // π
        float π = 3.14F;
        System.out.println("Java中的可以表示变量名的字符范围很广泛的PI=" + π);
        Character.isJavaIdentifierStart((char)π);
        Character.isJavaIdentifierPart((char)π);

        //整数被0除会产生一个异常，浮点数被0除会得到无穷大或NaN结果。
        // float res = 1L / 0;  // java.lang.ArithmeticException: / by zero
        double divDouble = 2.3 / 0;
        System.out.println("浮点数被0除会得到无穷大或NaN结果，是真的吗？" + divDouble);
        /*
        x * y / z 有些机器在计算 x * y 会把结果存储在80位寄存器中，再除以z，将结果截断为64位返回。虽然结果精确了，
        但是不同的的机器执行结果可能就不一样。
        可以使用 strictfp 关键字修饰类、接口、方法必须严格使用浮点计算生成可再生的结果（此时 x * y 结果会截断为64位长度，
        再去进行下一步计算，注意：严格计算可能会产生溢出）
        */


        // ----- 数学运算 -----
        double v = Math.log10(100);
        System.out.println(v);
        double PI = Math.PI;
        double E = Math.E;
        double exp = Math.exp(2); // exp = e^2
        System.out.println(PI);
        System.out.println(E);
        System.out.println(exp);

        // Math和StrictMath都是用于数学计算的工具类，
        // Math里的很多方法都是直接调用StrictMath类里的native修饰的方法
        // Math
        // StrictMath

        // 隐式的强制类型转换，(int)(1 * 2.5)
        int op =  1;
        op *= 2.5;
        System.out.println(op);


        // >>>运算符会用0填充高位，>>会用符号位填充高位。不存在<<<运算符。
        // 移位运算符的右操作数要完成模32的运算，
        // 除非左操作数是long类型，这种情况下需要对右操作模64。
        System.out.println(1<<35);
        System.out.println(1<<3);
        System.out.println(1L<<67);
        System.out.println(1L<<3);

        String all = String.join(", ", "1", "2", "3", "4", "5");
        System.out.println(all);


        /*
        char类型是一个采用UTF-16编码表示Unicode码点的代码单元。
        大多数常用的Unicode字符使用一个代码单元就可以表示，而辅助字符需要一对代码单元表示。
        𝕆这个字符是两个代码单元表示的。
         */
        String greeting = "hel𝕆lo";
        int i = greeting.codePointCount(0, greeting.length());
        System.out.println("i = " + i);
        System.out.println(greeting.length());
        for (int j = 0; j < greeting.length(); j++) {
            System.out.print(greeting.charAt(j));
        }
        System.out.println("\n---两个代码单元表示的符号分开写是什么样子---");
        for (int j = 0; j < greeting.length(); j++) {
            System.out.println(greeting.charAt(j));
        }
        StringBuilder sb = new StringBuilder();
        System.out.println("\u2122是int，难以置信！！！");
        sb.appendCodePoint('\u2122');
        System.out.println("追加一个码点：" + sb.toString());


        // -----Console类读取密码。只能在控制台运行Console类的方法 -----
        // java.io.Console 只能用在标准输入、输出流未被重定向的原始控制台中使用，
        // 在 Eclipse 或者其他 IDE 的控制台是用不了的。
        Console cons = System.console();
        // String username = cons.readLine("User name:");
        //char[] pass = cons.readPassword("Password:");
        // System.out.println("输入的用户名是：" + username);
        //System.out.println("输入的密码是：" + Arrays.toString(pass));

        System.out.printf("一种时间格式化的方式：%tz\n", new Date());

        Scanner scanner = new Scanner("myfile.txt");
        System.out.println(System.getProperty("user.dir"));

        for (int j = 0; j < 10; j++) {
            int k = 0;
            k+=1;
            System.out.println("k = " + k); // k永远是1。
        }


        // ----- 带标签的break -----
        int breakFlag = 1;
        breakFor:
        while (true) {
            while (true) {
                if (0 != breakFlag % 3)
                    System.out.println("执行breakFlag++" + breakFlag++);
                break breakFor; //直接跳出两个循环，进不到循环了？？？？？
            }
        }


        // ----- 匿名数组？？？？ -----
        int[] arr1 = {1,2};
        // new int[] {2,1,3}; 这个匿名数组怎么不行呢？没搞懂

        int[][][] deepArr = {{{1,2,3}, {4,5,6}, {7,8,9}},
                             {{10, 11, 12}, {13, 14, 15}, {16, 17, 18}},
                             {{19, 20, 21}, {22, 23, 24}, {25, 26, 27}}};
        System.out.println("快速打印多维数组：" + Arrays.deepToString(deepArr));
    }
}
