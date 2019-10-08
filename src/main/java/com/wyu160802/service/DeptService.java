package com.wyu160802.service;

import com.wyu160802.dto.BaseResult;
import com.wyu160802.entity.Dept;

import java.util.List;

/**
 * @author 黄明潘
 * @date 2019/10/6-13:20
 */
public interface DeptService {

    List<Dept> queryDept();

    BaseResult updateDept(Dept dept);

    BaseResult addDept(Dept dept);

    BaseResult delDept(int id);
}
