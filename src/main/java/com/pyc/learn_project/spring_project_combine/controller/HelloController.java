package com.pyc.learn_project.spring_project_combine.controller;

import com.pyc.learn_project.spring_project_combine.domain.Car;
import com.pyc.learn_project.spring_project_combine.domain.Person;
import com.pyc.learn_project.spring_project_combine.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 御承扬
 * @product IntelliJ IDEA
 * @project spring_project_combine
 * @file HelloController
 * @pack com.pyc.learn_project.spring_project_combine.controller
 * @date 2021/1/30
 * @time 16:46
 * @E-mail 2923616405@qq.com
 **/

@Slf4j
@RestController
public class HelloController {

    final Car car;

    final User user;

    final Person person;

    public HelloController(Car car, User user, Person person) {
        this.car = car;
        this.user = user;
        this.person = person;
    }

    /**
     * @return Car
     */
    @RequestMapping("/car")
    public Car car(){
        return car;
    }

    /**
     * @return String
     */
    @RequestMapping("/hello")
    public String handle01(){
        return "Hello, Spring Boot2!";
    }

    /**
     * @return User
     */
    @RequestMapping("/test_user")
    public User user(){
        log.info("请求调用......");
        return user;
    }

    /**
     * @return Person
     */
    @RequestMapping("/person")
    public Person person(){
        return person;
    }

    /**
    * RequestMapping(value = "/user",method = RequestMethod.GET)
    * **/
    @GetMapping("/user")
    public String getUser(){
        return "GET-张三";
    }

    /**
     * RequestMapping(value = "/user",method = RequestMethod.POST)
     * **/

    @PostMapping("/user")
    public String saveUser(){
        return "POST-张三";
    }


    /**
    * RequestMapping(value = "/user",method = RequestMethod.PUT)
    */
    @PutMapping("/user")
    public String putUser(){
        return "PUT-张三";
    }

    /**
    *RequestMapping(value = "/user",method = RequestMethod.DELETE)
    * */
    @DeleteMapping("/user")
    public String deleteUser(){
        return "DELETE-张三";
    }

    /**
     * RequestMapping(value = "/user", method = RequestMethod.PATCH)
     * @return String
     */
    @PatchMapping("/user")
    public String patchUser(){
        return "PATCH-PYC";
    }

    @GetMapping("/car/{id}/owner/{username}")
    public Map<String,Object> getCar(@PathVariable("id") Integer id,
                                     @PathVariable("username") String name,
                                     @PathVariable Map<String,String> pathVariables,
                                     @RequestHeader("Host") String host,
                                     @RequestHeader Map<String,String> header,
                                     @RequestParam("age") Integer age,
                                     @RequestParam("inters") List<String> inters,
                                     @RequestParam Map<String,String> params){


        Map<String,Object> map = new HashMap<>();

        map.put("id",id);
        map.put("name",name);
        map.put("pathVariables",pathVariables);
        map.put("host",host);
        map.put("headers",header);
        map.put("age",age);
        map.put("inters",inters);
        map.put("params",params);
        return map;
    }
}
