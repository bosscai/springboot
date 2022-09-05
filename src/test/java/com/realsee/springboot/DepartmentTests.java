package com.realsee.springboot;

import com.realsee.mapper.DepartmentMapper;
import com.realsee.mapper.EmployeeMapper;
import com.realsee.mapper.UserMapper;
import com.realsee.pojo.Department;
import com.realsee.pojo.Dog;
import com.realsee.pojo.Employee;
import com.realsee.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.util.List;

@SpringBootTest
class DepartmentTests {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Test
    public void queryAllDepartment(){
        List<Department> departments = departmentMapper.queryAllDepartment();
        for (Department item : departments) {
            System.out.println(item);
        }
    }

    @Test
    public void queryDepartmentById(){
        Department department = departmentMapper.queryDepartmentById(103);
        System.out.println(department);
    }

    @Test
    public void addDepartment(){
        Department department = new Department(106, "销售部");
        int i = departmentMapper.addDepartment(department);
        System.out.println(i);
    }
    @Test
    public void updateDepartment(){
        Department department = new Department(106, "宣传部");
        int i = departmentMapper.updateDepartment(department);
        System.out.println(i);
    }
    @Test
    public void deleteDepartment(){
        int i = departmentMapper.deleteDepartment(106);
        System.out.println(i);
    }
}
