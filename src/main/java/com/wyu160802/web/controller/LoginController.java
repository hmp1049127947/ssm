package com.wyu160802.web.controller;

import com.wyu160802.dto.BaseResult;
import com.wyu160802.entity.User;
import com.wyu160802.service.UserService;
import com.wyu160802.util.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author 黄明潘
 * @date 2019/9/23-19:55
 */
@Controller
public class LoginController{

    @Autowired
    private UserService userService;

    @GetMapping(value = {"", "/", "/login"})
    public String login(HttpServletRequest request) {
        String cookieValue = CookieUtils.getCookieValue(request, "remember_user",true);
        //如果cookie有值
        if (cookieValue != null) {
            User user = userService.findByNumber(cookieValue);
            if (user != null) {
                System.out.println(user);
                request.getSession().setAttribute("user",user);
                return "redirect:/main";
            }
        }
        return "login";
    }

    @PostMapping(value = "/login")
    public String login(String number,String password,
                        HttpServletRequest request,
                        HttpServletResponse response,
                        String remember) {

        System.out.println(remember);
        User user = userService.queryUser(number, password);
        //登录成功
        if (user != null) {
            //选中记住登录
            if (remember!=null) {
                //保存cookie
                CookieUtils.setCookie(request,response,"remember_user",user.getNumber(),604800,true);
            }
            request.getSession().setAttribute("user",user);
            return "redirect:/main";
        } else {
            return "login";
        }

    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request,HttpServletResponse response) {
        request.getSession().invalidate();
        CookieUtils.deleteCookie(request,response,"remember_user");
        return "redirect:/";
    }

    @PostMapping("/register")
    public String register(User user, RedirectAttributes redirectAttributes) {
        BaseResult baseResult = userService.insertPerson(user);
        if (baseResult.status == 200) {
            baseResult.setMessage("注册成功");
        }
        redirectAttributes.addFlashAttribute("baseResult", baseResult);
        return "redirect:/";
    }


}
