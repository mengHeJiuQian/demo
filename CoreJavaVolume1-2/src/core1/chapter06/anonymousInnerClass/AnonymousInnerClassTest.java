package core1.chapter06.anonymousInnerClass;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

/**
 * This program demonstrates anonymous inner classes.
 *
 * @author Cay Horstmann
 * @version 1.11 2015-05-12
 */
class A {

    private int val;

    A(int val) {
        this.val = val;
    }

    public void print() {
        System.out.println("我是类A，val = " + val);
    }

    public void printArr(ArrayList list) {
        System.out.println(list.toString());
    }

    public void printClassName() {
        System.out.println("当前类名：" + new Object(){}.getClass().getEnclosingClass());
    }

}
public class AnonymousInnerClassTest {


    public static void main(String[] args) {
        new A(5).print();
        new A(6).printArr(new ArrayList() {{ add("a");add("a");add("a"); }});
        new A(7).printClassName();
        System.out.println("当前类名：" + new A(7).getClass());
    }
}


