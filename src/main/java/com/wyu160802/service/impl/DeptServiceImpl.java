package com.wyu160802.service.impl;

import com.wyu160802.dao.DeptDao;
import com.wyu160802.dto.BaseResult;
import com.wyu160802.entity.Dept;
import com.wyu160802.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 黄明潘
 * @date 2019/10/6-13:21
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao deptDao;
    @Override
    public List<Dept> queryDept() {
        return deptDao.queryDept();
    }

    @Override
    public BaseResult updateDept(Dept dept) {
        BaseResult baseResult = BaseResult.success("更新成功");
        int i = deptDao.updateDept(dept);
        if (i != 1) {
            baseResult = BaseResult.fail("更新失败");
        }
        return baseResult;
    }

    @Override
    public BaseResult addDept(Dept dept) {
        BaseResult baseResult = BaseResult.success("添加成功");
        int i = deptDao.addDept(dept);
        if (i != 1) {
            baseResult = BaseResult.fail("添加失败");
        }
        return baseResult;
    }

    @Override
    public BaseResult delDept(int id) {
        BaseResult baseResult = BaseResult.success("删除成功");
        int i = deptDao.delDept(id);
        if (i != 1) {
            baseResult = BaseResult.fail("删除失败");
        }
        return baseResult;
    }
}
