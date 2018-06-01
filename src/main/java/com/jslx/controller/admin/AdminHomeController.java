package com.jslx.controller.admin;/**
 * Created by chenjia on 2018/5/31.
 */

import com.jslx.config.WebAppConfig;
import com.jslx.model.User;
import com.jslx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
@RequestMapping(value = "/layUi")
public class AdminHomeController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/home")
    public String home(Model model, HttpServletRequest request){

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute(WebAppConfig.SESSION_KEY);

        model.addAttribute("username",username);
        return "index";
    }

}
