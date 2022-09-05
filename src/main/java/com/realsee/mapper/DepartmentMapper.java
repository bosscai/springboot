package com.realsee.mapper;

import com.realsee.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DepartmentMapper {

    List<Department> queryAllDepartment();

    Department queryDepartmentById(@Param("id") Integer id);

    int addDepartment(Department department);

    int updateDepartment(Department department);

    int deleteDepartment(int id);
}
