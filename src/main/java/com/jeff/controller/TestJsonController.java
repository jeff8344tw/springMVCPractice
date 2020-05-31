package com.jeff.controller;

import com.jeff.bean.Employee;
import com.jeff.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

@Controller
public class TestJsonController {

    @Autowired
    private EmployeeDao employeeDao;

    /**
     * springMVC處理json的四個條件
     * 1. 導入jackson的jar
     * 2. 在springMVC的配置文件中開啟MVC驅動，<mvc:annotation-driven />
     * 3. 在處理ajax請求的方法上加上註解@ResponseBody
     * 4. 將要轉換為json且響應到客戶端的數據，直接作為該方法的返回值返回
     * @ResponseBody
     */
    @RequestMapping("/testJson")
    @ResponseBody
    public Collection<Employee> testJson(){
        Collection<Employee> emps = employeeDao.getAll();
        return emps;
    }
}
