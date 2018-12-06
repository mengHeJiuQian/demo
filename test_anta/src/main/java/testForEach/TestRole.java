package testForEach;

import org.apache.commons.lang.StringUtils;

/**
 * @Description TODO
 * @Author shuyun
 * @Date 2018/11/9 17:56
 */
public class TestRole {
    public static void main(String[] args) {
        Role[] roles = new Role[2];
        roles[0] = new Role(1);
        roles[1] = new Role(2);
        System.out.println(roles.toString());
        System.out.println(roles.length);
//        for (Role role : roles) {
//
//        }
    }
}
