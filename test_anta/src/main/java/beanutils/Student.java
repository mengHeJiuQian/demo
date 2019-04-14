package beanutils;

import lombok.Data;

/**
 * @Description TODO
 * @Author yang.liu
 * @Date 2019/4/9 18:50
 */
@Data
public class Student {

    private String name;
    private String password;

    public Student() { }

    public Student(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
