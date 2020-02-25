package com.wangqiang.controller;

import com.wangqiang.dao.DepartmentDao;
import com.wangqiang.dao.EmployeeDao;
import com.wangqiang.pojo.Department;
import com.wangqiang.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Collection;

/**
 * @version : V1.0
 * @ClassName: EmploeeController
 * @Description: TODO
 * @Auther: wangqiang
 * @Date: 2020/2/24 23:51
 */
@Controller
public class EmploeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    //查询所有员工，返回列表页面
    @GetMapping("/emp")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        //将结果放在请求中
        model.addAttribute("emps",employees);
        return "emp/list.html";
    }

    //to员工添加页面
    @GetMapping("/add")
    public String toAdd(Model model){
        //查出所有的部门，提供选择
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "emp/add.html";
    }

    //员工添加功能，使用post接收
    @PostMapping ("/add")
    public String add(Employee employee){
        System.out.println(employee);
        employeeDao.save(employee); //保存员工信息
        //回到员工列表页面，可以使用redirect或者forward
        return "redirect:/emp";
    }

    //to员工修改页面
    @GetMapping("/emp/{id}")
    public String toUpdateEmp(@PathVariable("id") Integer id, Model model){
        //根据id查出来员工
        Employee employee = employeeDao.getEmployeeById(id);
        //将员工信息返回页面
        model.addAttribute("emp",employee);
        //查出所有的部门，提供修改选择
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);

        return "emp/update.html";
    }

    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee){
        employeeDao.save(employee);
        //回到员工列表页面
        return "redirect:/emp";
    }

    @GetMapping("/delEmp/{id}")
    public String deleteEmp(@PathVariable("id")Integer id){
        //根据id查出来员工
        employeeDao.delete(id);
        return "redirect:/emp";
    }


}
