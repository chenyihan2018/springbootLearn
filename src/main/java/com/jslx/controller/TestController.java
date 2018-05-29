package com.jslx.controller;/**
 * Created by chenjia on 2018/5/28.
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jslx.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author chenjia
 * @create 2018-05-28 16:57
 * @desc
 **/
@Controller
@RequestMapping(value = "/user")
public class TestController {

    @RequestMapping(value = "/tologin")
    public ModelAndView login(){
        ModelAndView response = new ModelAndView("login/login");
        response.addObject("name","thymeleaf");
        System.out.println("项目执行了");
        return response;
    }

    @RequestMapping(value = "/tologin1",method = RequestMethod.GET)
    public String login2(Model model,String username,String password){
        model.addAttribute("username",username);
        model.addAttribute("password",password);
        return "login/login";
    }

    @RequestMapping(value = "/login1")
    @ResponseBody
    public JSONObject login1(){
        String s = "{js:[{id:\"110000\",\"city\":\"北#001京市\"},{id:\"110000\",\"city\":\"北#002京市\"}"
                + ",{id:\"110000\",\"city\":\"北#002京市\"},{id:\"110000\",\"city\":\"北#002京市\"},"
                + "{id:\"110000\",\"city\":\"#006北#005京市\"},"
                + "{id:\"110000\",\"city\":\"北#002京市\"},"
                + "{id:\"110000\",\"city\":\"北#002京市\"},{id:\"120000\",\"city\":\"天#009津市\"}]}";
        JSONObject parse = JSON.parseObject(s);
        return parse;
    }

    /**
     */
    @Autowired
    private RedisService redisService;
    @RequestMapping(value = "/jedis",method = RequestMethod.GET)
    @ResponseBody
    public String testJedis(String key,String value) throws Exception{
        boolean set = redisService.set(key, value);

        if(set){
            System.out.println(value);
            String redisValue = redisService.get(key);
            System.out.println(redisValue);
        }

        return value;
    }


    /**
     * 测试邮箱
     */

    @Value("${spring.mail.username}")
    private  String lastname;

    @Autowired
    private JavaMailSender javaMailSender;
    @RequestMapping(value = "/testmail")
    @ResponseBody
    public String testMail(){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(lastname);
        simpleMailMessage.setSubject("hello Word");
        simpleMailMessage.setText("spring boot ,hello");
        simpleMailMessage.setTo("1265129132@qq.com");

        String result= "";
        try {
            javaMailSender.send(simpleMailMessage);
            result="发送成功";
        }catch (Exception e){
            System.out.println(e.getMessage());
            result= "发送失败";
        }

        return result;
    }



}
