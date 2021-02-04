package com.pyc.learn_project.spring_project_combine.controller;

import com.pyc.learn_project.spring_project_combine.domain.People;
import com.pyc.learn_project.spring_project_combine.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.crypto.Data;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    @ResponseBody
    @GetMapping("/test/people")
    public People getPeople(){
        People people = new People();
        people.setName("Bob");
        people.setAge(22);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse("1997-05-21",new ParsePosition(0));
        people.setBirth(date);
        return people;
    }
}
