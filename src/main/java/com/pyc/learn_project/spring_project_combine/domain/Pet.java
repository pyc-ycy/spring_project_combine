package com.pyc.learn_project.spring_project_combine.domain;

import lombok.Data;
import lombok.ToString;

/**
 * @author 御承扬
 * @product IntelliJ IDEA
 * @project spring_project_combine
 * @file Pet
 * @pack com.pyc.learn_project.spring_project_combine.domain
 * @date 2021/1/31
 * @time 15:30
 * @E-mail 2923616405@qq.com
 **/

@ToString
@Data
public class Pet {
    private String name;
    private Double weight;
    private Integer age;
}
