package com.realsee.dao;

import com.realsee.pojo.Department;
import com.realsee.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {

    private static Map<Integer, Employee> employees = null;

    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<>();
        employees.put(1001, new Employee(1001, "AA", "985980971@qq.com", 1, new Department(101, "教学部"), null));
        employees.put(1002, new Employee(1002, "BB", "985980971@qq.com", 1, new Department(101, "市场部"), null));
        employees.put(1003, new Employee(1003, "CC", "985980971@qq.com", 1, new Department(101, "教研部"), null));
        employees.put(1004, new Employee(1004, "DD", "985980971@qq.com", 1, new Department(101, "运行部"), null));
        employees.put(1005, new Employee(1005, "EE", "985980971@qq.com", 1, new Department(101, "教学部"), null));
    }

    public Collection<Employee> getEmployees(){
        return employees.values();
    }

    public Employee getEmployeeById(int id){
        return employees.get(id);
    }

    private static Integer initId = 1006;

    //增加一个员工
    public void add(Employee employee){
        if (employee.getId() == null){
            employee.setId(initId++);
        }
        employees.put(employee.getId(), employee);
    }

    public void delete(int id){
        employees.remove(id);
        System.out.println(employees.toString());
    }
}
