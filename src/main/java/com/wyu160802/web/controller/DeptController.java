package com.wyu160802.web.controller;

import com.alibaba.fastjson.JSON;
import com.wyu160802.dto.BaseResult;
import com.wyu160802.entity.Dept;
import com.wyu160802.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 黄明潘
 * @date 2019/10/6-13:24
 */
@Controller
@RequestMapping("dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @PostMapping(value = "lists",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String query() {
        List<Dept> dept = deptService.queryDept();
        return JSON.toJSONString(dept);
    }

    @PostMapping(value = "update")
    @ResponseBody
    public BaseResult updateDept(Dept dept) {
        System.out.println(dept);
        return deptService.updateDept(dept);
    }

    @PostMapping("add")
    @ResponseBody
    public BaseResult addDept(Dept dept) {
        System.out.println(dept);
        return deptService.addDept(dept);
    }

    @PostMapping("del")
    @ResponseBody
    public BaseResult delDept(Dept dept) {
        System.out.println(dept);
        return deptService.delDept(dept.getId());
    }
}
