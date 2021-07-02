package com.zxh.dev.controller;

import com.zxh.dev.bean.User;
import com.zxh.dev.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("user")
public class TestController {
    @Resource
    private UserService userService;

    @GetMapping("/selectOne")
    public User selectOne(Integer id) {
        return this.userService.selectById(id);
    }
}
