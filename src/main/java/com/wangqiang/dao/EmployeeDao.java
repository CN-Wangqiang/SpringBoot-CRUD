package com.wangqiang.dao;

import com.wangqiang.pojo.Department;
import com.wangqiang.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @version : V1.0
 * @ClassName: EmploeeDao
 * @Description: TODO
 * @Auther: wangqiang
 * @Date: 2020/2/24 19:05
 */
@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees = null;

    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<Integer, Employee>();
        employees.put(1001,new Employee(1001,"A","123@qq.com",0,new Department(1,"技术")));
        employees.put(1002,new Employee(1002,"B","456@qq.com",1,new Department(2,"客服")));
        employees.put(1003,new Employee(1003,"C","789@qq.com",0,new Department(3,"市场")));
        employees.put(1004,new Employee(1004,"D","abc@qq.com",1,new Department(4,"营销")));

    }

    private static Integer initId = 1005;

    public void save(Employee employee){
        if (employee.getId() == null){
           employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }

    public Collection<Employee> getAll(){
        return employees.values();
    }

    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    public void delete(Integer id){
        employees.remove(id);
    }

}
