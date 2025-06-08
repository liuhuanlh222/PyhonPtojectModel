package com.example.projectpython.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.projectpython.dto.Result;
import com.example.projectpython.dto.UserHolder;
import com.example.projectpython.entity.ModelAnswer;
import com.example.projectpython.entity.User;
import com.example.projectpython.mapper.ModelAnswerMapper;
import com.example.projectpython.service.ModelAnswerService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

/**
 * @author: Liu
 * @date: 2025/6/7
 * @description:
 */
@Service
public class ModelAnswerServiceImpl extends ServiceImpl<ModelAnswerMapper, ModelAnswer> implements ModelAnswerService {

    @Override
    public Result getQuestionByUserId(long id) {
        List<ModelAnswer> ModelAnswers = query().eq("user_id", id).list();
        return Result.ok(ModelAnswers);
    }

    @Override
    public Result askQuestion(long id, String question) {
        String url = "http://localhost:6006/chat";
        String prompt = question;
        String json = String.format("{\"prompt\":\"%s\"}", prompt);

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            return Result.fail("请求失败");
        }

        if (response.statusCode() == 200) {
            String body = response.body();
            // 反序列化
            ObjectMapper objectMapper = new ObjectMapper();
            String answer;
            try {
                JsonNode jsonNode = objectMapper.readTree(body);
                answer = jsonNode.get("response").asText();
            } catch (Exception e) {
                return Result.fail("解析返回值失败");
            }
            String cleanText = answer.replace("\\n", "\n"); // 将 \n 替换为实际换行

            ModelAnswer modelAnswer = new ModelAnswer();
            modelAnswer.setUserId(id);
            modelAnswer.setQuestion(prompt);
            modelAnswer.setAnswer(cleanText);
            saveOrUpdate(modelAnswer);

            return Result.ok(cleanText);

        } else {
            return Result.fail("请求失败");
        }
    }
}
