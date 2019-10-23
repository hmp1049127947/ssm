package com.wyu160802.web.controller;

import com.alibaba.fastjson.JSON;
import com.wyu160802.dto.BaseResult;
import com.wyu160802.dto.PageDto;
import com.wyu160802.entity.User;
import com.wyu160802.entity.UserPageDto;
import com.wyu160802.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.AbstractDocument;
import java.net.URL;
import java.util.List;

/**
 * @author 黄明潘
 * @date 2019/9/23-19:13
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @ResponseBody
    @GetMapping(value = "/userslist", produces = "application/json; charset=utf-8")
    public String getUsers(int page,int rows) {
        int leftArg = (page - 1) * rows;
        List<User> users = userService.queryAllUsers(leftArg,rows);
        PageDto pageDto = new PageDto();
        pageDto.setTotal(userService.queryUserTotal());
        pageDto.setRows(users);
        String userJson = JSON.toJSONString(pageDto);
        return userJson;

    }

    @ResponseBody
    @GetMapping(value = "search", produces = "application/json; charset=utf-8")
    public String search(int page,int rows,String keyword) {

        int pageNumber = (page - 1) * rows;
        UserPageDto userPageDto = new UserPageDto();
        userPageDto.setNumber(keyword);
        userPageDto.setPhone(keyword);
        userPageDto.setUsername(keyword);
        userPageDto.setPageNumber(pageNumber);
        userPageDto.setRows(rows);
        List<User> users = userService.searchUser(userPageDto);
        PageDto pageDto = new PageDto();
        pageDto.setTotal(userService.flitTotal(userPageDto));
        pageDto.setRows(users);
        return JSON.toJSONString(pageDto);
    }

    @ResponseBody
    @PostMapping(value = "delete", produces = "application/json; charset=utf-8")
    public String delUsers(String ids) {
        BaseResult baseResult;
        if (StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            userService.deleteMulti(idArray);
            baseResult = BaseResult.success("删除用户成功");
        } else {
            baseResult = BaseResult.fail("删除用户失败");
        }
        return JSON.toJSONString(baseResult);
    }

    @ResponseBody
    @PostMapping(value = "edit", produces = "application/json; charset=utf-8")
    public String editUser(int id,String number, String phone,
                           @RequestParam(required = false) String username, String password, @RequestParam(required = false) String remark) {
        User user = new User();
        user.setId(id);
        user.setNumber(number);
        user.setPhone(phone);
        user.setUsername(username);
        user.setPassword(password);
        user.setRemark(remark);
        System.out.println(user);
        BaseResult baseResult = userService.updateUser(user);
        System.out.println(baseResult.toString());
        return JSON.toJSONString(baseResult);
    }

    @ResponseBody
    @PostMapping(value = "add", produces = "application/json; charset=utf-8")
    public String insertPerson(String number, String phone,
                               @RequestParam(required = false) String username, String password, @RequestParam(required = false) String remark) {
        User user = new User();
        user.setNumber(number);
        user.setPhone(phone);
        user.setUsername(username);
        user.setPassword(password);
        user.setRemark(remark);
        System.out.println(user);
        BaseResult baseResult = userService.insertPerson(user);
        System.out.println(baseResult.toString());
        return JSON.toJSONString(baseResult);
    }
}
