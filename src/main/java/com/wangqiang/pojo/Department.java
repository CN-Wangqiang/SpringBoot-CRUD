package com.wangqiang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @version : V1.0
 * @ClassName: Department
 * @Description: TODO
 * @Auther: wangqiang
 * @Date: 2020/2/24 18:17
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    private Integer id;
    private String departmentName;
}
