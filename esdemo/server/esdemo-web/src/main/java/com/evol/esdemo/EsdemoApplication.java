package com.evol.esdemo;

import com.github.pagehelper.autoconfigure.PageHelperAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

//@SpringBootApplication
@SpringBootApplication(exclude = PageHelperAutoConfiguration.class)
@PropertySource(value = "classpath:application.properties", ignoreResourceNotFound = true)
public class EsdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsdemoApplication.class, args);
    }
}
