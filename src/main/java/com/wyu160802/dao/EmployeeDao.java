package com.wyu160802.dao;

import com.wyu160802.entity.Employee;
import com.wyu160802.entity.EmployeeDto;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 黄明潘
 * @date 2019/10/7-15:14
 */
@Repository
public interface EmployeeDao {

    List<EmployeeDto> queryEmpDto();

    EmployeeDto queryEmpDtoById(Integer id);

    int updateEmp(Employee employee);

    int insertEmp(Employee employee);

    int delEmpById(Integer id);
}
