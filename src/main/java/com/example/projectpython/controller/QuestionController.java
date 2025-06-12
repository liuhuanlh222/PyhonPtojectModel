package com.example.projectpython.controller;

import com.example.projectpython.dto.Result;
import com.example.projectpython.service.ModelAnswerService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Liu
 * @date: 2025/6/7
 * @description: 提问问题接口
 */
@RestController
@RequestMapping("/question")
public class QuestionController {

    @Resource
    private ModelAnswerService modelAnswerService;

    // 提问
    @GetMapping("/ask")
    public Result askQuestion(@RequestParam(value = "id") long id, @RequestParam(value = "question") String question) {
        return modelAnswerService.askQuestion(id, question);
    }

    // 获取提问与回答
    @GetMapping("/get")
    public Result getQuestion(@RequestParam(value = "id") long id) {
        return modelAnswerService.getQuestionByUserId(id);
    }
}
