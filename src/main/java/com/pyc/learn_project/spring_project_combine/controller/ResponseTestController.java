package com.pyc.learn_project.spring_project_combine.controller;

import com.pyc.learn_project.spring_project_combine.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 御承扬
 * @product IntelliJ IDEA
 * @project spring_project_combine
 * @file ResponseTestController
 * @pack com.pyc.learn_project.spring_project_combine.controller
 * @date 2021/2/2
 * @time 16:57
 * @E-mail 2923616405@qq.com
 **/

@Controller
public class ResponseTestController {

    final Person person;

    public ResponseTestController(Person person) {
        this.person = person;
    }

    @ResponseBody
    @GetMapping("/test/person")
    public Person getPerson(){
        return person;
    }
}
