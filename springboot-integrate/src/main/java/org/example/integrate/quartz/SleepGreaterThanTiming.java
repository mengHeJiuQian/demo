package org.example.integrate.quartz;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author：yang.liu
 * @create time：2020/7/27 16:20
 * @version：1.0
 * @description： 模拟定时任务执行的时间（执行需要五秒）大于定时任务设置的时间（定时任务设置的三秒）
 */
@Slf4j
@Configuration
public class SleepGreaterThanTiming {

    /**
     * 定时任务执行的时间（执行需要五秒）大于定时任务设置的时间（定时任务设置的三秒）
     * run = 5, timing=3
     * 则相当于timing为6. 2 * 3 > 5
     * @throws InterruptedException
     */
    @Scheduled(cron = "*/4 * * * * ?")
    public void execute() throws InterruptedException {
        log.info("SleepGreaterThanTiming Begin");
        Thread.sleep(5000);
        log.info("SleepGreaterThanTiming End");
    }

}
