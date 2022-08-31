package com.realsee.controller;

import com.realsee.dao.DepartmentDao;
import com.realsee.dao.EmployeeDao;
import com.realsee.mapper.UserMapper;
import com.realsee.pojo.Department;
import com.realsee.pojo.Employee;
import com.realsee.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/queryUserList")
    public List<User> queryUserList(){
        List<User> users = userMapper.queryAllUsers();
        for (User item : users) {
            System.out.println(item);
        }
        return users;
    }
    @RequestMapping("/queryUserById/{id}")
    public User queryUserList(@PathVariable("id") Integer id){
        return userMapper.queryUserById(id);
    }

}
