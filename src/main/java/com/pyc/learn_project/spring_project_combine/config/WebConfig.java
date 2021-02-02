package com.pyc.learn_project.spring_project_combine.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

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
}
