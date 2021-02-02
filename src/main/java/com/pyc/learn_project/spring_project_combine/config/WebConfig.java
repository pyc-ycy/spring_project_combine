package com.pyc.learn_project.spring_project_combine.config;

import com.pyc.learn_project.spring_project_combine.domain.People;
import com.pyc.learn_project.spring_project_combine.domain.Pet;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

import java.text.SimpleDateFormat;

/**
 * @author 御承扬
 * @product IntelliJ IDEA
 * @project spring_project_combine
 * @file WebConfig
 * @pack com.pyc.learn_project.spring_project_combine.config
 * @date 2021/2/2
 * @time 9:28
 * @E-mail 2923616405@qq.com
 **/

@Configuration(proxyBeanMethods = false)
public class WebConfig implements WebMvcConfigurer {

    /**
     * 使用 urlPathHelper.setRemoveSemicolonContent(false); 设置不移除服务请求路径中‘;’后面的内容，即开启矩阵变量的使用
     * 要实现此功能，除了继承WebMvcConfigurer，也可以使用Bean注解的方式，注册一个 WebMvcConfigurer组件，其写法：
     * Bean
     * public WebMvcConfigurer webMvcConfigurer(){
     *     return new WebMvcConfigurer(){
     *      override
     *      public void configurePathMatch(PathMatchConfigurer configurer){
     *          UrlPathHelper urlPathHelper = new UrlPathHelper();
     *          urlPathHelper.setRemoveSemicolonContent(false);
     *          configurer.setUrlPathHelper(urlPathHelper);
     *      }
     *     }
     * }
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        urlPathHelper.setRemoveSemicolonContent(false);
        configurer.setUrlPathHelper(urlPathHelper);
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new Converter<String, Pet>() {
            @Override
            public Pet convert(String s) {
                if(!StringUtils.isEmpty(s)){
                    Pet pet = new Pet();
                    String[] split = s.split(",");
                    pet.setName(split[0]);
                    pet.setWeight(Double.parseDouble(split[1]));
                    pet.setAge(Integer.parseInt(split[2]));
                    return pet;
                }
                return null;
            }
        });
        registry.addConverter(new Converter<String, People>() {
            @Override
            public People convert(String s) {
                if(!StringUtils.isEmpty(s)){
                    People people = new People();
                    String[] split = s.split(",");
                    people.setName(split[0]);
                    people.setAge(Integer.parseInt(split[1]));
                    SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
                    try{
                        people.setBirth(format.parse(split[2]));
                    }catch (Exception e){
                        people.setBirth(null);
                    }
                    Pet pet = new Pet();
                    pet.setName(split[3]);
                    pet.setWeight(Double.parseDouble(split[4]));
                    pet.setAge(Integer.parseInt(split[5]));
                    people.setPet(pet);
                    return people;
                }
                return null;
            }
        });
    }
}
