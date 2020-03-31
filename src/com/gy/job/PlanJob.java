package com.gy.job;

import com.gy.service.MeetingService;
import org.quartz.*;

public class PlanJob implements Job {

    MeetingService meetingService = new MeetingService();
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        TriggerKey key = jobExecutionContext.getTrigger().getKey();
        System.out.println(key);
        JobKey key1 = jobExecutionContext.getJobDetail().getKey();
        System.out.println(key1);
        meetingService.calClassMeeting();
    }
}
