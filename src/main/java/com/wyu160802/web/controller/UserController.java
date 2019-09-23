package com.wyu160802.web.controller;

import com.wyu160802.entity.User;
import com.wyu160802.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 黄明潘
 * @date 2019/9/23-19:13
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/query")
    public String test(Model model){
        User user=userService.queryUser();
        model.addAttribute("phone", user.getPhone());
        return "hrm";
    }
}
