package com.wyu160802.service.impl;

import com.wyu160802.dao.EmployeeDao;
import com.wyu160802.dto.BaseResult;
import com.wyu160802.entity.Employee;
import com.wyu160802.entity.EmployeeDto;
import com.wyu160802.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @author 黄明潘
 * @date 2019/10/7-15:20
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;


    @Override
    public List<EmployeeDto> queryEmpDto() {
        return employeeDao.queryEmpDto();
    }

    @Override
    public EmployeeDto queryEmpDtoById(Integer id) {
        return employeeDao.queryEmpDtoById(id);
    }

    @Override
    public BaseResult updateEmp(Employee employee) {
        BaseResult baseResult=BaseResult.fail("更新失败");
        int i = employeeDao.updateEmp(employee);
        if (i == 1) {
            baseResult = BaseResult.success("更新成功");
        }
        return baseResult;
    }

    @Override
    public BaseResult insertEmp(Employee employee) {
        BaseResult baseResult = BaseResult.fail("添加失败");

        int i = 0;
        try {
            i=employeeDao.insertEmp(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (i == 1) {
            baseResult = BaseResult.success("添加成功");
        }
        return baseResult;
    }

    @Override
    public BaseResult delEmpById(Integer id) {
        BaseResult baseResult = BaseResult.fail("删除失败");
        int i = employeeDao.delEmpById(id);
        if (i == 1) {
            baseResult = BaseResult.success("删除成功");
        }
        return baseResult;
    }

}
