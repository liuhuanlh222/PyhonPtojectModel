package com.example.projectpython.controller;

import com.example.projectpython.dto.Result;
import com.example.projectpython.entity.User;
import com.example.projectpython.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Liu
 * @date: 2025/6/7
 * @description: 登陆和注册
 */
@RestController
@RequestMapping("user")
public class LoginController {

    @Resource
    private UserService userService;

    // 登陆接口
    @PostMapping("/login")
    public Result getUser(@RequestBody User user) {
        return userService.login(user);
    }

    // 注册接口
    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        return userService.register(user);
    }
}
