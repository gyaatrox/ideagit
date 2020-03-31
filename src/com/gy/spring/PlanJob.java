package com.gy.spring;

import com.gy.spring.entity.ScheduleJob;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class PlanJob implements Job {
    MeetingService meetingService = new MeetingService();

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        ScheduleJob scheduleJob = (ScheduleJob)jobDataMap.get("scheduleJob");
        System.out.println(scheduleJob.getId()+" "+scheduleJob.getJobName());
        meetingService.remindMeeting();
    }
}
