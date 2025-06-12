package com.example.projectpython.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.projectpython.dto.Result;
import com.example.projectpython.dto.UserHolder;
import com.example.projectpython.entity.User;
import com.example.projectpython.mapper.UserMapper;
import com.example.projectpython.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author: Liu
 * @date: 2025/6/7
 * @description: 用户业务实现类
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    /**
     * 登陆方法
     */
    @Override
    public Result login(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        User user1 = query().eq("username", username).eq("password", password).one();
        if (user1 == null) {
            return Result.fail("手机号或密码错误");
        }
        UserHolder.saveUser(user);
        return Result.ok(user1.getId());

    }

    @Override
    public Result register(User user) {
        String username = user.getUsername();
        //根据用户名查询用户
        User user1 = query().eq("username", username).one();
        //判断是否为空
        if (user1 != null) {
            return Result.fail("该手机号已注册");
        }
        //不为空，保存用户
        save(user);
        //返回注册成功信息
        return Result.ok("注册成功");
    }
}
