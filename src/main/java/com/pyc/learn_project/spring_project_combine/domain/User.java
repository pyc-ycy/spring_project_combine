package com.pyc.learn_project.spring_project_combine.domain;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 御承扬
 * @product IntelliJ IDEA
 * @project spring_project_combine
 * @file User
 * @pack com.pyc.learn_project.spring_project_combine.domain
 * @date 2021/1/31
 * @time 14:19
 * @E-mail 2923616405@qq.com
 **/

@Data
@ToString
@NoArgsConstructor  // 无参构造器
@AllArgsConstructor // 有参构造器
@EqualsAndHashCode
@Component
@ConfigurationProperties(prefix = "myuser")
public class User {
    private String name;
    private String age;
    private String sex;
}
