package com.wyu160802.web.controller;

import com.alibaba.fastjson.JSON;
import com.mysql.cj.Session;
import com.wyu160802.dto.PageDto;
import com.wyu160802.entity.Files;
import com.wyu160802.entity.Notice;
import com.wyu160802.entity.User;
import com.wyu160802.service.FilesService;
import com.wyu160802.service.NoticeService;
import com.wyu160802.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import javax.management.modelmbean.ModelMBean;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author 黄明潘
 * @date 2019/9/23-21:01
 */
@Controller
public class TabsController {

    @Autowired
    private UserService userService;

    @Autowired
    private FilesService filesService;



    @GetMapping(value = "/queryPerson")
    public String queryPerson(String keyword,Model model) {
        //查询所有用户
        if (StringUtils.isBlank(keyword)) {
            model.addAttribute("url", "/user/userslist");
        } else {
            model.addAttribute("keyword", keyword);
            model.addAttribute("url", "/user/search?keyword=" + keyword);
        }
        return "queryPerson";
    }

    @GetMapping(value = "/addPerson")
    public String addPerson() {
        return "addPerson";
    }

    @GetMapping(value = "/addNotice")
    public String addNotice() {
        return "addNotice";
    }

    @GetMapping(value = "/editUser")
    public String editUser(int id,Model model) {
        System.out.println(id);
        User  user = userService.queryUserById(id);
        model.addAttribute("user", user);
        return "editUser";
    }

    @GetMapping("queryNotice")
    public String queryNotice() {
        return "queryNotice";
    }
    @GetMapping("upload")
    public String uploadFile() {
        return "uploadFile";
    }

    @GetMapping("download")
    public String download(@RequestParam(value = "pageNumber",defaultValue = "1") int pageNumber,
                           @RequestParam(value = "pageSize",defaultValue = "6")int pageSize,Model model) {
        int page=(pageNumber - 1) * pageSize;
        List<Files> files = filesService.filesPage(page,pageSize);
        int filesNum = filesService.filesNum();
        model.addAttribute("total", filesNum);
        model.addAttribute("files",files);
        model.addAttribute("page", pageNumber);
        return "downloadFile";
    }
    @GetMapping("queryDept")
    public String queryDept() {
        return "queryDept";
    }

    @GetMapping("getJobPage")
    public String jobManage() {
        return "jobManage";
    }




}
