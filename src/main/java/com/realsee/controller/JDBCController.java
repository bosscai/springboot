package com.realsee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> userList(){
        return null;
    }
}
