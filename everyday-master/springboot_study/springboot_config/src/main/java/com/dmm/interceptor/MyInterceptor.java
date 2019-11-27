package com.dmm.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 拦截器
 * WebMvcConfigurerAdapter 过时了
 * @author DMM
 * @create 2019/7/22
 */
@Configuration
public class MyInterceptor extends WebMvcConfigurationSupport {

    @Override
    public void addInterceptors(InterceptorRegistry registry){

        HandlerInterceptor handlerInterceptor=new HandlerInterceptor() {
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                System.out.println("杜明明");
                return true;
            }

            public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

            }

            public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

            }
        };
        registry.addInterceptor(handlerInterceptor).addPathPatterns("/**");

    }


}

