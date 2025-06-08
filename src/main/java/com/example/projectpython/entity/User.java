package com.example.projectpython.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author: Liu
 * @date: 2025/6/7
 * @description: 用户实体类
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user")
public class User {
    // 主键
    private Long id;

    private String username;

    private String password;
}
