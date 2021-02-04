package com.pyc.learn_project.spring_project_combine.converter;

import com.pyc.learn_project.spring_project_combine.domain.People;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author 御承扬
 * @product IntelliJ IDEA
 * @project spring_project_combine
 * @file MyMessageConverter
 * @pack com.pyc.learn_project.spring_project_combine.converter
 * @date 2021/2/4
 * @time 10:18
 * @E-mail 2923616405@qq.com
 **/

/**
 * 自定义Converter
 * @author 彭友聪
 */
public class MyMessageConverter implements HttpMessageConverter<People> {
    @Override
    public boolean canRead(Class<?> aClass, MediaType mediaType) {
        return false;
    }

    @Override
    public boolean canWrite(Class<?> aClass, MediaType mediaType) {
        return aClass.isAssignableFrom(People.class);
    }

    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return MediaType.parseMediaTypes("application/x-pyc");
    }

    @Override
    public People read(Class<? extends People> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override
    public void write(People people, MediaType mediaType, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        String data = people.getName() + ";" + people.getAge() + ";" + people.getBirth();
        OutputStream body = httpOutputMessage.getBody();
        body.write(data.getBytes(StandardCharsets.UTF_8));

    }
}
