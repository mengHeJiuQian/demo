package com.imooc.gradle.todo;

import java.util.Scanner;

/**
 * 创建人：yang.liu
 * 创建时间：2019/8/5 13:12
 * 版本：1.0
 * 内容描述：
 */
public class App {
    public static void main(String[] args) {
        int i = 0;
        Scanner scanner = new Scanner(System.in);
        while (++i > 0) {
            System.out.println(i + ". please input todo item name:");
            TodoItem item = new TodoItem(scanner.nextLine());
            System.out.println(item);
        }
    }
}
