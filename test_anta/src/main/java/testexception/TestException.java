package testexception;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description TODO
 * @Author shuyun
 * @Date 2018/11/27 11:35
 */
@Slf4j
public class TestException {
    public static void main(String[] args) {
        Object o = throwExcep();
        System.out.println(o.toString());
    }

    public static Object throwExcep() {
        Object res = null;
        try {
            int i = 1 / 0;
            res = "1";
            System.out.println("--1--");
        } catch (Exception e) {
            System.out.println("出错了");

            log.error(e.getMessage(), e);
            // e.printStackTrace();
        } finally {
            res = "3";
            System.out.println("--3--");
        }
        res = "4";
        return res;
    }
}
