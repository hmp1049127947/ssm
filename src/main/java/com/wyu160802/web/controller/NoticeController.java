package com.wyu160802.web.controller;

import com.alibaba.fastjson.JSON;
import com.wyu160802.dto.BaseResult;
import com.wyu160802.entity.Notice;
import com.wyu160802.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.management.modelmbean.ModelMBean;
import java.util.List;

/**
 * @author 黄明潘
 * @date 2019/10/4-20:01
 */
@Controller
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @ResponseBody
    @PostMapping(value = "/add",produces = "application/json; charset=utf-8")
    public String addNotice(String name, String title, String content) {
        Notice notice = new Notice();
        notice.setName(name);
        notice.setTitle(title);
        notice.setContent(content);
        BaseResult baseResult = noticeService.addNotice(notice);
        return JSON.toJSONString(baseResult);
    }


    @ResponseBody
    @GetMapping(value = "/lists",produces = "application/json; charset=utf-8")
    public String noticesList() {
        List<Notice> notices = noticeService.queryNotice();
        return JSON.toJSONString(notices);
    }

    @GetMapping("/previews")
    public String showNotice(int id, Model model) {
        Notice notice = noticeService.showNotice(id);
        model.addAttribute("notice", notice);
        return "showNotice";
    }

}
