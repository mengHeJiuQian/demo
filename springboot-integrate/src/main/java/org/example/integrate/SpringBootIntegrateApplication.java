package org.example.integrate;

import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 创建人：yang.liu
 * 创建时间：2020/7/17 11:26
 * 版本：1.0
 * 内容描述：
 */
@EnableSchedulerLock(defaultLockAtMostFor = "PT1M")
@EnableScheduling
@SpringBootApplication
public class SpringBootIntegrateApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootIntegrateApplication.class, args);
    }

}
