package com.pyc.learn_project.spring_project_combine.controller;

import com.pyc.learn_project.spring_project_combine.domain.People;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 御承扬
 * @product IntelliJ IDEA
 * @project spring_project_combine
 * @file RequestController
 * @pack com.pyc.learn_project.spring_project_combine.controller
 * @date 2021/2/2
 * @time 8:54
 * @E-mail 2923616405@qq.com
 **/

@Controller
public class RequestController {

    @GetMapping("/goto")
    public String gotoPage(HttpServletRequest request){
        request.setAttribute("msg","成功了....");
        request.setAttribute("code","200");
        return "forward:/success";
    }

    @ResponseBody
    @GetMapping("/success")
    public Map<String, Object> success(@RequestAttribute(value = "msg",required = false) String msg,
                       @RequestAttribute(value = "code",required = false)Integer code,
                       HttpServletRequest request){
        Object msg1 = request.getAttribute("msg");
        Map<String, Object> map = new HashMap<>(4);
        map.put("request_msg",msg1);
        map.put("annotation_msg",msg);

        Object map1 = request.getAttribute("map");
        Object model1 = request.getAttribute("model");
        Object rq = request.getAttribute("request");
        map.put("map",map1);
        map.put("model",model1);
        map.put("request",rq);
        return map;
    }

    /**
     *  原来的请求写法：/car/{path}?var=value1&var=value2,称为 query string，可以使用 PathVariable 和 RequestParam 等注解方法获取，
     *  使用 MatrixVariable 的请求写法，/var/{path}?var=value1,value2，/boss/1;age=20/2;age=20
     *  当页面开发时，Cookie被禁用了，可以考虑使用这个来获取 Session，即用URL重写：/abc;jsessionid=value 将cookie的值用矩阵变量进行传递
     *  SpringBoot默认禁用矩阵变量的，要使用就必须手动开启:修改路径匹配原则，对于路径的处理。UrlPathHelper进行解析，
     *  removeSemicolonContent（移除分号内容）支持矩阵变量的
     *  矩阵变量必须有url路径变量才能被解析
    * */
    @ResponseBody
    @GetMapping("/cars/{path}")
    public Map<String, Object> carsSell(@MatrixVariable("low") Integer low,
                        @MatrixVariable("brand") List<String> brand,
                        @PathVariable("path") String path){
        Map<String,Object> map = new HashMap<>(4);

        map.put("low",low);
        map.put("brand",brand);
        map.put("path",path);
        return map;
    }

    @ResponseBody
    @GetMapping("/boss/{bossId}/{empId}")
    public Map<String, Object> boss(@MatrixVariable(value = "age", pathVar = "bossId") Integer bossAge,
                                    @MatrixVariable(value = "age", pathVar = "empId") Integer empAge,
                                    @PathVariable String bossId,
                                    @PathVariable String empId){
        Map<String,Object> map = new HashMap<>(4);
        map.put("bossAge",bossAge);
        map.put("empAge",empAge);
        map.put("bossId",bossId);
        map.put("empId",empId);
        return map;
    }

    @GetMapping("/params")
    public String testParams(Map<String,Object> map,
                             Model model,
                             HttpServletRequest request,
                             HttpServletResponse response){
        map.put("map","MAP");
        model.addAttribute("model","MODEL");
        request.setAttribute("request","REQUEST");
        Cookie cookie = new Cookie("c1","cookie");
        cookie.setDomain("localhost");
        response.addCookie(cookie);
        return "forward:/success";
    }

    /**
     * 数据绑定：页面提交的请求数据（GET，POST）都可以和对象属性进行绑定
     * @return People
     */
    @ResponseBody
    @PostMapping("/savePeople")
    public People savePeople(People people){
        return people;
    }
}
