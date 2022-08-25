package com.realsee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("/user/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model, HttpSession session) {
        if (password.equals("123456")){
            session.setAttribute("loginUser", username);
            return "dashboard";
        } else {
            model.addAttribute("msg", "用户名或账号错误！");
            return "index";
        }
    }
}
