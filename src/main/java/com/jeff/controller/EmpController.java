package com.jeff.controller;

import com.jeff.bean.Department;
import com.jeff.bean.Employee;
import com.jeff.dao.DepartmentDao;
import com.jeff.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Controller
public class EmpController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    /**
     * 獲取所有員工訊息
     * @param map
     * @return
     */
    @RequestMapping(value="/emps")
    public String getAll(Map<String, Object> map){
        Collection<Employee> emps =  employeeDao.getAll();
        map.put("emps", emps);
        return "list";
    }

    /**
     * 跳轉到添加頁面
     * @return
     */
    @RequestMapping(value="/emp", method= RequestMethod.GET)
    public String toAdd(Map<String, Object> map) {
        Collection<Department> depts = departmentDao.getDepartments();
        map.put("depts", depts);
        return "add";
    }

    /**
     * 添加員工訊息
     * @param employee
     * @return
     */
    @RequestMapping(value="/emp", method = RequestMethod.POST)
    public String addEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    /**
     * 獲取要回顯的數據，跳轉到修改頁面，並回顯
     * @param id
     * @param map
     * @return
     */
    @RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
    public String toUpdate(@PathVariable("id") Integer id, Map<String, Object> map){
        // 獲取要修改的員工訊息
        Employee emp = employeeDao.get(id);
        // 獲取所有的部分訊息，供用戶選擇
        Collection<Department> depts = departmentDao.getDepartments();
        map.put("emp", emp);
        map.put("depts", depts);
        return "update";
    }

    @RequestMapping(value="/emp", method = RequestMethod.PUT)
    public String updateEmp(Employee employee){
        employeeDao.save(employee); // 修改
        return "redirect:/emps";
    }

    @RequestMapping(value="/editEmp", method = RequestMethod.GET)
    public String toEdit(Map<String, Object> map){
        // 獲取所有的部門訊息
        Collection<Department> depts = departmentDao.getDepartments();
        // 創建存儲性別gneder的訊息
        Map<String, String> genders = new HashMap<>();
        genders.put("0", "female");
        genders.put("1", "male");
        map.put("depts", depts);
        map.put("genders", genders);
        // form標籤有自動回顯得功能,會在頁面中默認獲取獲取request作用域Command屬性的值
        // 若在<form:form>設置了modelAttribute，就可以自定義回顯對象的屬性名
        map.put("command", new Employee());
        return "edit";
    }

    /**
     * 獲取要回顯的數據，跳轉到修改頁面，並回顯
     * @param id
     * @param map
     * @return
     */
    @RequestMapping(value = "/editEmp/{id}", method = RequestMethod.GET)
    public String toUpdate2(@PathVariable("id") Integer id, Map<String, Object> map){
        // 獲取要修改的員工訊息
        Employee emp = employeeDao.get(id);
        // 獲取所有的部分訊息，供用戶選擇
        Collection<Department> depts = departmentDao.getDepartments();
        // 創建存儲性別gneder的訊息
        Map<String, String> genders = new HashMap<>();
        genders.put("0", "female");
        genders.put("1", "male");
        map.put("command", emp);
        map.put("depts", depts);
        map.put("genders", genders);
        return "edit";
    }

}
