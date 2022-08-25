package com.realsee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @RequestMapping("test")
    public String hello(Model model){
        model.addAttribute("msg", "Hello Spring Boot");
        return "test";
    }
    @RequestMapping({"index", "index.html", "/"})
    public String index(){
        return "index";
    }
}
