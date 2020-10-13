package com.zhuodewen.www.dubboconsumer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security")
public class SpringSecurityController {


    /*Spring Security登录返回*/
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

}
