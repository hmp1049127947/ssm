package com.wyu160802.web.controller;

import com.wyu160802.handle.BaseExceptionHandleAction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 黄明潘
 * @date 2019/9/23-19:55
 */
@Controller
public class LoginController extends BaseExceptionHandleAction {

    @GetMapping(value = {"","/","/login"})
    public String login() {
        return "index";
    }
}
