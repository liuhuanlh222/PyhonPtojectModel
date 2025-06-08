package com.example.projectpython.dto;

import com.example.projectpython.entity.User;

/**
 * @author LH
 * @version 1.0
 * @description 保存用户
 * @date 2024/12/10 11:47
 */
public class UserHolder {
    private static final ThreadLocal<User> tl = new ThreadLocal<>();

    public static void saveUser(User user) {
        tl.set(user);
    }

    public static User getUser() {
        return tl.get();
    }

    public static void removeUser() {
        tl.remove();
    }
}
