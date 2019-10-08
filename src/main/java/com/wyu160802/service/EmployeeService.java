package com.wyu160802.service;

import com.wyu160802.dto.BaseResult;
import com.wyu160802.entity.Employee;
import com.wyu160802.entity.EmployeeDto;

import java.util.List;

/**
 * @author 黄明潘
 * @date 2019/10/7-15:20
 */
public interface EmployeeService {
    List<EmployeeDto> queryEmpDto();

    EmployeeDto queryEmpDtoById(Integer id);

    BaseResult updateEmp(Employee employee);

    BaseResult insertEmp(Employee employee);

    BaseResult delEmpById(Integer id);
}
