package com.imooc.gradle.todo;

/**
 * 创建人：yang.liu
 * 创建时间：2019/8/5 13:11
 * 版本：1.0
 * 内容描述：
 */
public class TodoItem {
    //待办事项名称
    private String name;

    // 已完成
    private boolean hasDone;

    public TodoItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHasDone() {
        return hasDone;
    }

    public void setHasDone(boolean hasDone) {
        this.hasDone = hasDone;
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "name='" + name + '\'' +
                ", hasDone=" + hasDone +
                '}';
    }
}
