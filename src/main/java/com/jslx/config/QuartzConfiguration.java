package com.jslx.config;/**
 * Created by chenjia on 2018/5/30.
 */

import com.jslx.quartz.QuartzJob1;
import com.jslx.quartz.QuartzJob2;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * @author chenjia
 * @create 2018-05-30 9:45
 * @desc
 **/
@Configuration
public class QuartzConfiguration {
    @Autowired
    SchedulerFactoryBean schedulerFactoryBean;

    static Scheduler scheduler;

    public void scheduleJobs() throws SchedulerException {
        scheduler = schedulerFactoryBean.getScheduler();
        startJob1(); // 每15分钟执行一次
        startJob2(); // 每两小时执行一次
    }

    public static void startJob1() throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(QuartzJob1.class).withIdentity("job1", "group1").build();
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0 0/1 * * * ?");
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1")
                .withSchedule(scheduleBuilder).build();
        scheduler.scheduleJob(jobDetail, cronTrigger);
    }
    public static void modifyJob1(String cron) throws SchedulerException {
        TriggerKey triggerKey = TriggerKey.triggerKey("trigger1", "group1");
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
        CronTrigger newTrigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1")
                .withSchedule(scheduleBuilder).build();
        scheduler.rescheduleJob(triggerKey, newTrigger);
    }
    public static String getJob1Status() throws SchedulerException {
        TriggerKey triggerKey = TriggerKey.triggerKey("trigger1", "group1");
        return scheduler.getTriggerState(triggerKey).name();
    }
    public static void pauseJob1() throws SchedulerException {
        scheduler.pauseJob(JobKey.jobKey("job1", "group1"));
    }
    public static void resumeJob1() throws SchedulerException {
        scheduler.resumeJob(JobKey.jobKey("job1", "group1"));
    }

    private void startJob2() throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(QuartzJob2.class).withIdentity("job2", "group1").build();
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/1 * * * * ?");
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger2", "group1")
                .withSchedule(scheduleBuilder).build();
        scheduler.scheduleJob(jobDetail, cronTrigger);
    }
    public static void modifyJob2(String cron) throws SchedulerException {
        TriggerKey triggerKey = TriggerKey.triggerKey("trigger2", "group1");
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
        CronTrigger newTrigger = TriggerBuilder.newTrigger().withIdentity("trigger2", "group1")
                .withSchedule(scheduleBuilder).build();
        scheduler.rescheduleJob(triggerKey, newTrigger);
    }
    public static String getJob2Status() throws SchedulerException {
        TriggerKey triggerKey = TriggerKey.triggerKey("trigger2", "group1");
        return scheduler.getTriggerState(triggerKey).name();
    }
    public static void pauseJob2() throws SchedulerException {
        scheduler.pauseJob(JobKey.jobKey("job2", "group1"));
    }
    public static void resumeJob2() throws SchedulerException {
        scheduler.resumeJob(JobKey.jobKey("job2", "group1"));
    }

}