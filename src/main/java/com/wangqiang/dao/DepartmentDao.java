package com.wangqiang.dao;

import com.wangqiang.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @version : V1.0
 * @ClassName: DepartmentDao
 * @Description: TODO
 * @Auther: wangqiang
 * @Date: 2020/2/24 18:27
 */
@Repository
public class DepartmentDao {
    private static Map<Integer, Department> departments = null;

    static {
        departments = new HashMap<>();
        departments.put(1,new Department(1,"技术"));
        departments.put(2,new Department(2,"客服"));
        departments.put(3,new Department(3,"市场"));
        departments.put(4,new Department(4,"营销"));

    }

    public Collection<Department> getDepartments(){
        return departments.values();

    }


    public Department getDepartmentById(Integer id){
        return departments.get(id);
    }
}
