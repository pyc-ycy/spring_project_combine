package com.pyc.learn_project.spring_project_combine.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 御承扬
 * @product IntelliJ IDEA
 * @project spring_project_combine
 * @file Car
 * @pack com.pyc.learn_project.spring_project_combine.domain
 * @date 2021/1/31
 * @time 10:18
 * @E-mail 2923616405@qq.com
 **/
/*只有在容器中的组件，才会拥有Spring Boot提供的强大功能*/
//@Component
@ConfigurationProperties(prefix = "mycar")
public class Car {
    private String brand;
    private Integer price;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
