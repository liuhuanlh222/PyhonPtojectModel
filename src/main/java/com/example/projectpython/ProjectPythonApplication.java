package com.example.projectpython;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.projectpython.mapper")
public class ProjectPythonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectPythonApplication.class, args);
    }

}
