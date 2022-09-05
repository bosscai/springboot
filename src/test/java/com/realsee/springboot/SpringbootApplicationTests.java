package com.realsee.springboot;

import com.realsee.mapper.DepartmentMapper;
import com.realsee.mapper.EmployeeMapper;
import com.realsee.mapper.UserMapper;
import com.realsee.pojo.Department;
import com.realsee.pojo.Dog;
import com.realsee.pojo.Employee;
import com.realsee.pojo.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class SpringbootApplicationTests {

    @Autowired
    private Dog dog;
    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserMapper mapper;

    @Test
    void contextLoads() {
        System.out.println(dog.toString());
    }

    @Test
    public void queryAllUser(){
        List<User> users = mapper.queryAllUsers();
        for (User item : users) {
            System.out.println(item.toString());
        }
    }

    @Test
    public void queryUserById(){
        User user = mapper.queryUserById(7);
        System.out.println(user.toString());
    }

    @Test
    public void dataSource(){
        User user1 = new User(7, "hcz", "369852");
        int i;
        i = mapper.addUser(user1);
        System.out.println(i);
    }

    @Test
    public void updateUser(){
        int hello = mapper.updateUser(new User(7, "hello", "world!"));
        System.out.println(hello);
    }

    @Test
    public void deleteUser(){
        int deleteUser = mapper.deleteUser(8);
        System.out.println(deleteUser);
    }

    @Test
    public void login(){
        User user = mapper.login("18515429930", "123456");
        System.out.println(user);
    }

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    DepartmentMapper departmentMapper;
    @Test
    public void allEmployee(){
        for (Employee employee : employeeMapper.queryAllEmployees()) {
            System.out.println(employee.toString());
        }
    }
    @Test
    public void getEmployeeById(){
        Employee employee = employeeMapper.queryEmployeeById(1003);
        System.out.println(employee);
    }

    @Test
    public void allDepartment(){
        List<Department> departments = departmentMapper.queryAllDepartment();
        for (Department item : departments) {
            System.out.println(item.toString());
        }
    }

}
