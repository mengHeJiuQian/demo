package sort;

/**
 * @Description TODO
 * @Author shuyun
 * @Date 2018/11/12 16:14
 */
public class Teacher {
    private String id;
    private String title;

    public Teacher(String id, String name) {
        this.id = id;
        this.title = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return title;
    }

    public void setName(String name) {
        this.title = name;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
