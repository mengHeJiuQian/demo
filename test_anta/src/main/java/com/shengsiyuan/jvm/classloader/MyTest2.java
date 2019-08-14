package com.shengsiyuan.jvm.classloader;

/**
 * 创建人：yang.liu
 * 创建时间：2019/8/14 16:48
 * 版本：1.0
 * 内容描述：
 * 常量在编译阶段会存入调用这个常量的方法所在的类的常量池中，
 * 本质上，调用类并没有直接引用到定义常量的类，因此并不会触发定义常量的类的初始化。
 *
 * 相当于例子中"hello world"在编译期间被存放到MyTest2的常量池中

 $ javap -c  MyTest2.class
 Compiled from "MyTest2.java"
 public class com.shengsiyuan.jvm.classloader.MyTest2 {
 public com.shengsiyuan.jvm.classloader.MyTest2();
 Code:
 0: aload_0
 1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 4: return

 public static void main(java.lang.String[]);
 Code:
 0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
 3: ldc           #4                  // String hello world
 5: invokevirtual #5                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 8: return
 }

 助记符：
 ldc表示将int，float或是String类型的常量值从常量池中推送至栈顶
 bipush表示将单字节（-128 ~ 127）的常量值推送至栈顶
 ipush表示将单短整型（-32768 ~ 32767）的常量值推送至栈顶

 iconst_m1表示将数字-1常量值推送至栈顶
 iconst_1 表示将数字1常量值推送至栈顶 范围是iconst_m1 ~ iconst_5，应该是-1~5这几个数字比较常用
 */
public class MyTest2 {

    public static void main(String[] args) {
        System.out.println(MyParent2.m);
    }
}

class MyParent2 {
    //public static final String str = "hello world";
    //public static final byte[] str = {123};
    public static final int m = -1;

    static {
        System.out.println("MyParent2 static block");
    }
}
