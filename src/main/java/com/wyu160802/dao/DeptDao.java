package com.wyu160802.dao;

import com.wyu160802.entity.Dept;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 黄明潘
 * @date 2019/10/6-13:16
 */
@Repository
public interface DeptDao {
    List<Dept> queryDept();

    int updateDept(Dept dept);

    int addDept(Dept dept);

    int delDept(int id);
}
