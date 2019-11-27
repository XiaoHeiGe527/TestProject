package com.dmm.config;

import com.dmm.common.api.version.string.ApiHandlerMappingString;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;


/**
 * 配置WebMvcRegistrationsConfig 注册拦截器实例到容器中
 * @author: Dmm
 * @date: 2019/4/18 11:03
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

//    @Override
//    @Bean
//    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
//
//        RequestMappingHandlerMapping handlerMapping = new ApiHandlerMapping();
//
//        handlerMapping.setOrder(0);
//        handlerMapping.setInterceptors(getInterceptors());
//
//        return handlerMapping;
//    }

    @Override
    @Bean
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {

        RequestMappingHandlerMapping apiHandlerMappingString = new ApiHandlerMappingString();

        apiHandlerMappingString.setOrder(0);
        apiHandlerMappingString.setInterceptors(getInterceptors());
        return apiHandlerMappingString;
    }


}
