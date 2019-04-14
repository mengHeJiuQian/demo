package beanutils;

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

}
