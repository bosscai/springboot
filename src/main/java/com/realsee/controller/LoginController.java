package com.realsee.controller;

import com.realsee.mapper.UserMapper;
import com.realsee.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserMapper mapper;

    @RequestMapping("/user/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model, HttpSession session) {
        User user = mapper.login(username, password);
        if (user != null){
            session.setAttribute("loginUser", username);
            return "dashboard";
        } else {
            model.addAttribute("msg", "用户名或账号错误！");
            return "index";
        }
    }

    @RequestMapping("/user/logout")
    public String logout(HttpSession session) {
       session.invalidate();
       return "redirect:/index.html";
    }
}
