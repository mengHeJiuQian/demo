package com.shengsiyuan.jvm.classloader;

/**
 * 创建人：yang.liu
 * 创建时间：2019/8/14 19:56
 * 版本：1.0
 * 内容描述：
 *
   助记符
   anewarray：表示创建一个引用类型的（如类、接口、数组）数组，并将其引用值压入栈顶
   newarray：表示创建一个基本类型的数组，并将其引用值压入栈顶
 */
public class MyTest4 {

    public static void main(String[] args) {
        MyParent4[] myParent4s = new MyParent4[1];

        // class [Lcom.shengsiyuan.jvm.classloader.MyParent4 这个类型是Java虚拟机在运行期生成出来的
        // 引用对象数组的夫类型是Object
        System.out.println(myParent4s.getClass());
        System.out.println(myParent4s.getClass().getSuperclass());

        MyParent4[][] myParent4s1 = new MyParent4[1][1];
        System.out.println(myParent4s1.getClass());
        System.out.println(myParent4s1.getClass().getSuperclass());

        int[] ints = new int[1];
        System.out.println(ints.getClass());
        System.out.println(ints.getClass().getSuperclass());
    }
}

class MyParent4 {
     static {
         System.out.println("MyParent4 static block");
     }
}
