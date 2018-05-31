package com.jslx.task;/**
 * Created by chenjia on 2018/5/30.
 */

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author chenjia
 * @create 2018-05-30 9:26
 * @desc springboot定时任务的实现
 **/
@Component
public class springbootTask {

    @Scheduled(cron = "0 0/1 * * * ?")
    public void task1() throws  Exception{
        System.out.println("执行定时任务1");
    }

    @Scheduled(fixedRate = 2000)
    public void task2() throws Exception{
        System.out.println("执行定时任务2");
    }

    @Scheduled(cron = "0/2 * * * * ?")
    public void task3()  throws Exception{
        System.out.println("执行定时任务3");
    }

    @Scheduled(cron = "0 0 0/1 * * ?")
    public void task4() throws Exception{
        System.out.println("执行定时任务4");
    }
}
