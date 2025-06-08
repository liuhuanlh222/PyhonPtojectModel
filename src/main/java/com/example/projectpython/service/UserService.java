package com.example.projectpython.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.projectpython.dto.Result;
import com.example.projectpython.entity.User;

/**
 * @author: Liu
 * @date: 2025/6/7
 * @description: 用户业务层
 */
public interface UserService extends IService<User> {

    //登陆
    Result login(User user);

    //注册
    Result register(User user);
}
