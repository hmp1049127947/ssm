package com.wyu160802.web.controller;

import com.wyu160802.entity.User;
import com.wyu160802.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 黄明潘
 * @date 2019/9/23-19:55
 */
@Controller
public class LoginController{

    @Autowired
    private UserService userService;

    @GetMapping(value = {"","/","/login"})
    public String login() {
        return "index";
    }

    @PostMapping(value = "/login")
    public String login(HttpServletRequest request) {
        String username = request.getParameter("number");
        String password = request.getParameter("password");
        User user = userService.queryUser(username, password);
        if (user != null) {
            request.getSession().setAttribute("user",user);
            return "redirect:/main";
        } else {
            return login();
        }

    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return login();
    }
}
