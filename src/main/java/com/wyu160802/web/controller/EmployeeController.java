package com.wyu160802.web.controller;

import com.alibaba.fastjson.JSON;
import com.sun.xml.internal.ws.encoding.ContentType;
import com.wyu160802.dto.BaseResult;
import com.wyu160802.entity.Employee;
import com.wyu160802.entity.EmployeeDto;
import com.wyu160802.service.EmployeeService;
import com.wyu160802.util.TimeUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author 黄明潘
 * @date 2019/10/7-15:22
 */
@Controller
@RequestMapping("emp/")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("page")
    public String empManage() {
        return "empManage";
    }
    /**
     * 员工管理新增或修改后台
     * @param
     * @return
     */
    @PostMapping(value = "save")
    @ResponseBody()
    public BaseResult save(Employee employee,HttpServletResponse response) {
        if (employee.getBirthday().trim()=="") {
            employee.setBirthday(null);
        }
        employee.setCreateDate(new Timestamp(System.currentTimeMillis()).toString() );
        System.out.println(employee);
        if (employee.getId()!=null) {
            //修改数据
            BaseResult baseResult = employeeService.updateEmp(employee);
            response.setContentType("application/json");
            return baseResult;
        } else {
            //新增数据
            BaseResult baseResult = employeeService.insertEmp(employee);
            return baseResult;
        }

    }

    /**
     * 员工管理新增或修改前端
     * @param id
     * @param model
     * @return
     */
    @GetMapping("operate")
    public String addEmp(@RequestParam(value = "id",required = false) Integer id, Model model) {
        //修改
        if (id != null) {
            EmployeeDto employeeDto = employeeService.queryEmpDtoById(id);
            System.out.println(employeeDto.getBirthday());
            model.addAttribute("employeeDto", employeeDto);
        }
        return "emp_operate";
    }

    /**
     * 获取所有员工具体信息
     * @return
     */
    @ResponseBody
    @PostMapping(value = "lists",produces = "application/json;charset=utf-8")
    public List<EmployeeDto> query() {
        return employeeService.queryEmpDto();
    }


    @PostMapping("delete")
    @ResponseBody
    public BaseResult delEmpById(Integer id) {
        BaseResult baseResult = employeeService.delEmpById(id);
        return baseResult;
    }
}
