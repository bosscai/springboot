package com.realsee.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;

import java.io.Serializable;
import java.util.Date;

@Controller
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {
    private Integer id;
    private String name;
    private String email;
    private Integer sex; //0代表女
    private Department department;
    private Date birth;
}
