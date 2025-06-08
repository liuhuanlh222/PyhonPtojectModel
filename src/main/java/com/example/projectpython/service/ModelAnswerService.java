package com.example.projectpython.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.projectpython.dto.Result;
import com.example.projectpython.entity.ModelAnswer;

/**
 * @author: Liu
 * @date: 2025/6/7
 * @description:
 */
public interface ModelAnswerService extends IService<ModelAnswer> {
    Result getQuestionByUserId(long id);

    Result askQuestion(long id, String question);
}
