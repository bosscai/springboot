package com.realsee.mapper;

import com.realsee.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    List<User> queryAllUsers();

    User queryUserById(@Param("id") Integer id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);

    User login(@Param("name") String username, @Param("password") String password);
}
