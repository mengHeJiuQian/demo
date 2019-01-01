package a.java;

// 一级包名不能叫“java”，会报“java.lang.SecurityException: Prohibited package name: java.mypackage”
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
