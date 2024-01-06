package com.homework.java.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
    @GetMapping(value = "/test")
    public ModelAndView getTime() {
        return new ModelAndView((model, request, response) -> {
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write("""
                    <!DOCTYPE html>
                    <html lang="uk" xmlns:th="http://www.thymeleaf.org">
                    <head>
                        <meta charset="UTF-8">
                        <title>Тест</title>
                        <style>
                            body {
                                display: flex;
                                justify-content: center;
                                align-items: center;
                                height: calc(100vh - 16px);
                                background-color: #202123;
                                gap: 50px;
                            }
                                        
                            .message {
                                font-size: 60px;
                                color: #c5c5d2;
                            }
                        </style>
                    </head>
                    <body>
                        <p class="message">Тестова сторінка</p>
                    </body>
                    </html>""");
        });
    }
}
