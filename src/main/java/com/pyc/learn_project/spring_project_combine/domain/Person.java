package com.pyc.learn_project.spring_project_combine.domain;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 御承扬
 * @product IntelliJ IDEA
 * @project spring_project_combine
 * @file Person
 * @pack com.pyc.learn_project.spring_project_combine.domain
 * @date 2021/1/31
 * @time 15:29
 * @E-mail 2923616405@qq.com
 **/

@Component
@ConfigurationProperties(prefix = "person")
@ToString
@Data
public class Person {
    private String userName;
    private Boolean boss;
    private Date birth;
    private Integer age;
    private Pet pet;
    private String[] interests;
    private List<String> animal;
    private Map<String, Object> score;
    private Set<Double> salarys;
    private Map<String, List<Pet>> allPets;
}
