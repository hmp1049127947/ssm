package com.wyu160802.service;

import com.wyu160802.dto.BaseResult;
import com.wyu160802.entity.Dept;
import com.wyu160802.entity.Job;

import java.util.List;

/**
 * @author 黄明潘
 * @date 2019/10/6-16:42
 */
public interface JobService {

    List<Job> queryJob();

    BaseResult updateJob(Job job);

    BaseResult addJob(Job job);

    BaseResult delJob(int id);
}
