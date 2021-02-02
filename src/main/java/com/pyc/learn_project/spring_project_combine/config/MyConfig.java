package com.pyc.learn_project.spring_project_combine.config;

import com.pyc.learn_project.spring_project_combine.domain.Car;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author 御承扬
 * @product IntelliJ IDEA
 * @project spring_project_combine
 * @file MyConfig
 * @pack com.pyc.learn_project.spring_project_combine.config
 * @date 2021/1/31
 * @time 10:34
 * @E-mail 2923616405@qq.com
 **/

@Configuration
@EnableConfigurationProperties(Car.class)   // 开启属性配置功能，将配置类自动注册到容器中
public class MyConfig {
}
