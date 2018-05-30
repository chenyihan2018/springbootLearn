package com.jslx.quartz;/**
 * Created by chenjia on 2018/5/30.
 */

import com.jslx.config.QuartzConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * @author chenjia
 * @create 2018-05-30 10:28
 * @desc
 **/
@Configuration
public class SchedulerLister implements ApplicationListener<ContextRefreshedEvent>{

    @Autowired
    private QuartzConfiguration quartzConfiguration;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        try {
            quartzConfiguration.scheduleJobs();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(){
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        return schedulerFactoryBean;
    }

}
