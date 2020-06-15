package beanutils;

import lombok.Data;

/**
 * @Description TODO
 * @Author yang.liu
 * @Date 2019/4/9 18:50
 */
@Data
public class Teacher {

    private String name;

    private String password;

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
