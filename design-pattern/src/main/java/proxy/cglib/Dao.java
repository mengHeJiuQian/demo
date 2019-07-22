package proxy.cglib;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/22 15:32
 * 版本：1.0
 * 内容描述：
 */
public class Dao {

    public Dao() {
        update();
    }

    public void update() {
        System.out.println("PeopleDao.update()");
    }

    public void select() {
        System.out.println("PeopleDao.select()");
    }
}
