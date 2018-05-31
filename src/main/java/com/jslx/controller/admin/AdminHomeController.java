package com.jslx.controller.admin;/**
 * Created by chenjia on 2018/5/31.
 */

import com.jslx.model.User;
import com.jslx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenjia
 * @create 2018-05-31 10:19
 * @desc
 **/
@Controller
@RequestMapping(value = "/blogs")
public class AdminHomeController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/home")
    public String home(Model model){

        User user = userService.selectById(2);
        List list = new ArrayList();
        list.add("list 1 ");
        list.add("list 2 ");
        list.add("list 3 ");
        list.add("list 4 ");

        Map<String,String> map = new HashMap<>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        map.put("key4","value4");

        model.addAttribute("user",user);
        model.addAttribute("list",list);
        model.addAttribute("map",map);
        model.addAttribute("username","陈佳");
        return "home/home";
    }

}
