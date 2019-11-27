package com.dmm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


/**
 * @author DMM
 * @create 2019/7/9
 */
@SpringBootApplication
//@EnableAsync//开启异步调用

public class ConfigApplication extends WebMvcConfigurationSupport {

    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class,args);
    }

//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        //重写
//        //创建fastjson的消息转换器
//        FastJsonHttpMessageConverter fastJsonHttpMessageConverter=new FastJsonHttpMessageConverter();
//        //创建fastjson的配置对象
//        FastJsonConfig fastJsonConfig =new FastJsonConfig();
//        //进行格式化
//        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
//
//        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
//        converters.add(fastJsonHttpMessageConverter);
//    }
}

