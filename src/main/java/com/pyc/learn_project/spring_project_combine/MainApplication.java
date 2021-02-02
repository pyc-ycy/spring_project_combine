package com.pyc.learn_project.spring_project_combine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 御承扬
 * @product IntelliJ IDEA
 * @project spring_project_combine
 * @file SpringProjectCombineApplication
 * @pack com.pyc.learn_project.spring_project_combine
 * @date 2021/1/30
 * @time 16:42
 * @E-mail 2923616405@qq.com
 **/

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class,args);
        System.out.println("Spring Boot Running...");
    }
}
