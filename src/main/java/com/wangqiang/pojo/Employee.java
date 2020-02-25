package com.wangqiang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @version : V1.0
 * @ClassName: Employee
 * @Description: TODO
 * @Auther: wangqiang
 * @Date: 2020/2/24 18:18
 */
@Data
@NoArgsConstructor
public class Employee {
    private Integer id;
    private String name;
    private String email;
    private Integer gender;
    private Department department;
    private Date date;

    public Employee(Integer id, String name, String email, Integer gender, Department department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.department = department;
        this.date = new Date();
    }

}
