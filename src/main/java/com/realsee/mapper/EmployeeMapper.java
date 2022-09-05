package com.realsee.mapper;

import com.realsee.pojo.Employee;
import com.realsee.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EmployeeMapper {

    List<Employee> queryAllEmployees();

    Employee queryEmployeeById(@Param("id") Integer id);

    int addEmployee(Employee employee);

    int updateEmployee(Employee employee);

    int deleteEmployee(int id);
}
