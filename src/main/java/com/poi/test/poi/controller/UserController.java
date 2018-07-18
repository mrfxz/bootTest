package com.poi.test.poi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class UserController {
    @RequestMapping("/hi")
    public String hello(){
        System.out.print("hi");
        return "welcome.html";
    }
}
