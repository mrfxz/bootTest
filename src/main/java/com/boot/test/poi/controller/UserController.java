package com.boot.test.poi.controller;
import com.boot.test.poi.pojo.UserPojo;
import com.boot.test.poi.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/hello")
public class UserController {
    @Resource
    private UserService userService;
    @RequestMapping("/hi")
    @ResponseBody
    public List<UserPojo> hello(UserPojo user){
        List<UserPojo> list =  userService.selectList(user);
        System.out.print(list);
        return list;
    }
}
