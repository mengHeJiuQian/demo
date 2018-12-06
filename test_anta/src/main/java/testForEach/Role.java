package testForEach;

/**
 * @Description TODO
 * @Author shuyun
 * @Date 2018/11/9 17:56
 */
public class Role {
    private int id;

    public Role(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                '}';
    }
}
