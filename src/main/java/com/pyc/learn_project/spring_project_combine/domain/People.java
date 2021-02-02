package com.pyc.learn_project.spring_project_combine.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author 御承扬
 * @product IntelliJ IDEA
 * @project spring_project_combine
 * @file People
 * @pack com.pyc.learn_project.spring_project_combine.domain
 * @date 2021/2/2
 * @time 14:00
 * @E-mail 2923616405@qq.com
 **/

@Data
public class People {
    private String name;
    private Integer age;
    private Date birth;
    private Pet pet;
}
