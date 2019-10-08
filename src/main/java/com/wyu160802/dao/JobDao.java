package com.wyu160802.dao;

import com.wyu160802.entity.Dept;
import com.wyu160802.entity.Job;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 黄明潘
 * @date 2019/10/6-16:40
 */
@Repository
public interface JobDao {
    List<Job> queryJob();

    int updateJob(Job job);

    int addJob(Job job);

    int delJob(int id);
}
