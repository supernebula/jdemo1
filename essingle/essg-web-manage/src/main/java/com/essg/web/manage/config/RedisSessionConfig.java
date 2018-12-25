package com.essg.web.manage.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.session.data.redis.config.annotation.web.http.RedisHttpSessionConfiguration;

public class RedisSessionConfig {
    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private int port;
    @Value("${spring.redis.password}")
    private String password;
    @Value("${spring.redis.timeout}")
    private int timeout;
    @Value("${app.env}")
    private String env;
    @Autowired
    private RedisHttpSessionConfiguration redisHttpSessionConfiguration;
}
