package com.ggs.controller;

import com.ggs.domain.User;
import com.ggs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author Starbug
 * @Date 2020/7/21 16:13
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/list")
    public List<User> getUserList(){
        return userService.getUserList();
    }

    @RequestMapping("/to/jsp")
    public String forward(Model model){
        model.addAttribute("template","SSM模板");
        return "view";
    }


}
