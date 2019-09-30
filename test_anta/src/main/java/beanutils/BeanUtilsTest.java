package beanutils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;

/**
 * @Description TODO
 * @Author yang.liu
 * @Date 2019/4/9 18:49
 */
public class BeanUtilsTest {

    public static void main(String[] args) {
        Student s1 = new Student("yangliu", "123456");
        Student s2 = new Student("yl", "123");
        BeanUtils.copyProperties(s1, s2);
        System.out.println(s1);
        System.out.println(s2);
    }

    /**
     * 对象属性不相同在属性复制时不会报错
     */
    @Test
    public void test1() {
        Student s1 = new Student("yangliu", "123456");
        Teacher t1 = null;

        // org.apache.commons.beanutils.BeanUtils.copyProperties(s1, t1);

        System.out.println(s1);
        System.out.println(t1);
    }

}
