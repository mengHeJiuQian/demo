package org.example.integrate.quartz;

import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.core.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 创建人：yang.liu
 * 创建时间：2020/7/17 11:42
 * 版本：1.0
 * 内容描述：
 */
@Slf4j
@Component
public class SendWeChatMessageJob {

    @SchedulerLock(name = "SchedulerLockName", lockAtLeastForString = "PT5S", lockAtMostForString = "PT5S")
    @Scheduled(cron = "0 */1 * * * ?")
    public void execute() {
        log.info("SendWeChatMessageJob");
    }

}
