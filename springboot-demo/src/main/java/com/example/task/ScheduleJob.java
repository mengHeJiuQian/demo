package com.example.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@Component
public class ScheduleJob {

    static {
        log.warn("static");
    }

    public ScheduleJob() {
        log.warn("construct");
    }

    @PostConstruct
    private void init() {
        log.warn("PostConstruct");
    }

    @PreDestroy
    public void destroy() {
        log.warn("PreDestroy");
    }
}
