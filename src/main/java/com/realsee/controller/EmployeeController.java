package com.realsee.controller;

import com.realsee.dao.DepartmentDao;
import com.realsee.dao.EmployeeDao;
import com.realsee.pojo.Department;
import com.realsee.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getEmployees();
        model.addAttribute("employees", employees);
        return "emp/allEmployees";
    }

    @GetMapping("/toAdd")
    public String toAdd(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        return "emp/addEmployees";
    }

    @PostMapping("/toAdd")
    public String addEmp(Model model, Employee employee){
        Collection<Department> departments = departmentDao.getDepartments();
        employeeDao.add(employee);
        System.out.println(employee.toString());
        model.addAttribute("departments", departments);
        return "redirect:/emps";
    }

    @GetMapping("/toUpdate/{id}")
    public String toUpdate(Model model, @PathVariable("id")Integer id){
        Employee employee = employeeDao.getEmployeeById(id);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("emp", employee);
        model.addAttribute("departments", departments);
        return "emp/updateEmployees";
    }

    @RequestMapping("/updateEmp")
    public String updateEmp(Employee employee){
        employeeDao.add(employee);
        return "redirect:/emps";
    }

    @RequestMapping("/deleteEmp/{id}")
    public String deleteEmp( @PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }

}
