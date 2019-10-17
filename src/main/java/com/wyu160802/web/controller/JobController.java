package com.wyu160802.web.controller;

import com.alibaba.fastjson.JSON;
import com.wyu160802.dto.BaseResult;
import com.wyu160802.entity.Dept;
import com.wyu160802.entity.Job;
import com.wyu160802.service.DeptService;
import com.wyu160802.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 黄明潘
 * @date 2019/10/6-13:24
 */
@Controller
@RequestMapping("job")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping(value = "lists",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String query() {
        List<Job> jobs = jobService.queryJob();
        return JSON.toJSONString(jobs);
    }

    @PostMapping(value = "update")
    @ResponseBody
    public BaseResult update(Job job) {
        System.out.println(job);
        return jobService.updateJob(job);
    }

    @PostMapping("add")
    @ResponseBody
    public BaseResult insert(Job job) {
        System.out.println(job);
        return jobService.addJob(job);
    }

    @PostMapping("del")
    @ResponseBody
    public BaseResult delete(Job job) {
        System.out.println(job);
        return jobService.delJob(job.getId());
    }
}
