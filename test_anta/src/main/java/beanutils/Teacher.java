package beanutils;

/**
 * @Description TODO
 * @Author yang.liu
 * @Date 2019/4/9 18:50
 */
public class Teacher {

    private String name;
    private String password;

    public Teacher() { }

    public Teacher(String name, String password) {
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
