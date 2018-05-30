package com.jslx.controller.test;/**
 * Created by chenjia on 2018/5/30.
 */

import com.jslx.config.QuartzConfiguration;
import org.quartz.SchedulerException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenjia
 * @create 2018-05-30 10:33
 * @desc
 **/
@Controller
@RequestMapping(value = "/quartz")
public class QuartzControllerTest {

    @RequestMapping("/modify")
    public @ResponseBody
    String modify() throws SchedulerException {
        QuartzConfiguration.modifyJob1("0/1 * * * * ?");
        return "1";
    }

    @RequestMapping("/status")
    public @ResponseBody String status() throws SchedulerException {
        return QuartzConfiguration.getJob1Status();
    }

    @RequestMapping("/pause")
    public @ResponseBody String pause() throws SchedulerException {
        QuartzConfiguration.pauseJob2();
        return "1";
    }

    @RequestMapping("/resume")
    public @ResponseBody String resume() throws SchedulerException {
        QuartzConfiguration.resumeJob1();
        return "1";
    }
}
