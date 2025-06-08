package com.example.projectpython.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author: Liu
 * @date: 2025/6/7
 * @description: 回答实体类
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("model_answer")
public class ModelAnswer {

    // 主键
    private Long id;

    private Long userId;

    private String question;

    private String answer;

    private LocalDateTime createdAt;

}
