package com.essg.web.manage.config;

import com.essg.web.manage.handler.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 配置拦截器，使生效
 */
@Component
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //多个拦截器组成一个拦截器链
        //addPatterns 用于添加拦截器规则
        //excludePathPatterns 用于排除拦截
        registry.addInterceptor(loginInterceptor);
        super.addInterceptors(registry);
    }

}
