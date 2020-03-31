package com.gy.spring;

import org.quartz.SchedulerException;
import org.quartz.impl.StdScheduler;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringQuartz {
    public static void main(String[] args) throws SchedulerException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationConfig.xml");
        StdScheduler scheduler= (StdScheduler) context.getBean("scheduler");
        scheduler.start();
    }
}
