package com.homework.java.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
    @GetMapping(value = "/hello")
    public ModelAndView getTime() {
        return new ModelAndView("hello");
    }
}
