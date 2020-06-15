package beanutils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;

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
    public void test1() throws InvocationTargetException, IllegalAccessException {
        Student s1 = new Student("yangliu", "123456");
        Teacher t1 = new Teacher();

        //org.apache.commons.beanutils.BeanUtils.copyProperties(t1, s1);
        BeanUtils.copyProperties(s1, t1);

        System.out.println("aa".intern() == "aa".intern());
        System.out.println(s1);
        System.out.println(t1);
    }

}
