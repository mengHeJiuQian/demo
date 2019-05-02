package org.jooq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * describe:
 *
 * @author 梦合九千
 * @date 2019/5/2 10:12
 */
@SpringBootApplication
public class JooqApplication {

    public static void main(String[] args) {
        System.out.println("开始启动应用");
        SpringApplication.run(JooqApplication.class, args);
    }
}
