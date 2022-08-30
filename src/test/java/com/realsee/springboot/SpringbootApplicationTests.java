package com.realsee.springboot;

import com.realsee.pojo.Dog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class SpringbootApplicationTests {

    @Autowired
    private Dog dog;
    @Autowired
    private DataSource dataSource;

    @Test
    void contextLoads() {
        System.out.println(dog.toString());
    }

    @Test
    public void dataSource(){
        try {
            System.out.println(dataSource.getConnection());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
