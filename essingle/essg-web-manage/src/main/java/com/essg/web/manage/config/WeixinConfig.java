package com.essg.web.manage.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Spring boot document
 * https://docs.spring.io/spring-boot/docs/1.5.18.RELEASE/reference/htmlsingle/#using-boot-configuration-classes
 * 从application.properties读取配置信息
 */
@Configuration
//@Import(WeixinConfigA.class)
public class WeixinConfig {

    //private String weixinAccountJson;

    @Value("qq.weixin.appid")
    private String appId;

    @Value("qq.weixin.appsecret")
    private String appSecret;


}
