package com.realsee.controller;

import com.realsee.mapper.DepartmentMapper;
import com.realsee.mapper.EmployeeMapper;
import com.realsee.pojo.Department;
import com.realsee.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 展示所有员工
     * @param model
     * @return
     */
    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeMapper.queryAllEmployees();
        model.addAttribute("employees", employees);
        return "emp/allEmployees";
    }

    /**
     * 跳转去到添加员工的界面
     * @param model
     * @return
     */
    @GetMapping("/toAdd")
    public String toAdd(Model model){
        List<Department> departments = departmentMapper.queryAllDepartment();
        model.addAttribute("departments", departments);
        return "emp/addEmployees";
    }

    @PostMapping("/toAdd")
    public String addEmp(Model model, Employee employee){
        Collection<Department> departments = departmentMapper.queryAllDepartment();
        employeeMapper.addEmployee(employee);
        System.out.println(employee.toString());
        model.addAttribute("departments", departments);
        return "redirect:/emps";
    }

    @GetMapping("/toUpdate/{id}")
    public String toUpdate(Model model, @PathVariable("id")Integer id){
        Employee employee = employeeMapper.queryEmployeeById(id);
        Collection<Department> departments = departmentMapper.queryAllDepartment();
        model.addAttribute("emp", employee);
        model.addAttribute("departments", departments);
        return "emp/updateEmployees";
    }

    @RequestMapping("/updateEmp")
    public String updateEmp(Employee employee){
        System.out.println(employee);
        employeeMapper.updateEmployee(employee);
        return "redirect:/emps";
    }

    @RequestMapping("/deleteEmp/{id}")
    public String deleteEmp( @PathVariable("id") Integer id){
        employeeMapper.deleteEmployee(id);
        return "redirect:/emps";
    }

}
