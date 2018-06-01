package com.jslx.quartz;/**
 * Created by chenjia on 2018/5/30.
 */

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author chenjia
 * @create 2018-05-30 10:22
 * @desc 任务1
 **/
public class QuartzJob1 implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
//        System.out.println("quartz 定时任务 1");
    }
}
