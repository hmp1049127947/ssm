package com.wyu160802.service.impl;


import com.wyu160802.dao.JobDao;
import com.wyu160802.dto.BaseResult;
import com.wyu160802.entity.Job;
import com.wyu160802.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 黄明潘
 * @date 2019/10/6-13:21
 */
@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobDao jobDao;

    @Override
    public List<Job> queryJob() {
        return jobDao.queryJob();
    }

    @Override
    public BaseResult updateJob(Job job) {
        BaseResult baseResult = BaseResult.success("更新成功");
        int i = jobDao.updateJob(job);
        if (i != 1) {
            baseResult = BaseResult.fail("更新失败");
        }
        return baseResult;
    }

    @Override
    public BaseResult addJob(Job job) {
        BaseResult baseResult = BaseResult.success("添加成功");
        int i = jobDao.addJob(job);
        if (i != 1) {
            baseResult = BaseResult.fail("添加失败");
        }
        return baseResult;
    }

    @Override
    public BaseResult delJob(int id) {
        BaseResult baseResult = BaseResult.success("删除成功");
        int i = jobDao.delJob(id);
        if (i != 1) {
            baseResult = BaseResult.fail("删除失败");
        }
        return baseResult;
    }
}
