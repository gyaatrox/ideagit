package com.gy.test;
//888
import com.gy.job.PlanJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.ParseException;

public class TestQuartz {
    public static void main(String[] args) throws ParseException {
        //产生实际使用的job
        JobBuilder jobBuilder = JobBuilder.newJob(PlanJob.class);
        JobDetail jobDetail = jobBuilder.withIdentity("meeting job", "group1").build();

        //触发器 ：时间规则 依赖2个对象（triggerbuilder,schedule）
        TriggerBuilder<Trigger> triggerTriggerBuilder = TriggerBuilder.newTrigger();
        triggerTriggerBuilder = triggerTriggerBuilder.withIdentity("meeting trigger", "group1");
        triggerTriggerBuilder.startNow();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date start = simpleDateFormat.parse("2020-03-23 16:07:00");
//        Date stop = simpleDateFormat.parse("2020-03-23 16:07:20");
//        triggerTriggerBuilder.startAt(start);
//        triggerTriggerBuilder.endAt(stop);
        //schedule
//        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule();
//        simpleScheduleBuilder.withIntervalInSeconds(1);
//        simpleScheduleBuilder.withRepeatCount(3);  //重复3次
//        SimpleTrigger trigger = triggerTriggerBuilder.withSchedule(simpleScheduleBuilder).build();

        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("5 * * * * ? *");//第五秒
        CronTrigger trigger = triggerTriggerBuilder.withSchedule(cronScheduleBuilder).build();

        //调度器
        StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
        try {
            Scheduler scheduler = stdSchedulerFactory.getScheduler();
            //调度器  将任务和触发器 一一对应
            scheduler.scheduleJob(jobDetail, trigger);
            scheduler.start();
            //Thread.sleep(10000);
            // scheduler.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
