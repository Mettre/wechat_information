package com.mettre.wechat_information;

import com.mettre.jwt.JwtFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
@EnableEurekaClient   //同意注册到注册中心
@EnableFeignClients   //注解用来开启Feign功能
@EnableDiscoveryClient
public class MyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }

    @Value("${server.port}")
    String port;

    @RequestMapping("/xxx")
    public String home() {
        return "hello world from port " + port;
    }

    //过滤器
    @Bean
    public FilterRegistrationBean jwtFilter() {
        //拦截器
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new JwtFilter());
        List<String> urlPatterns = new ArrayList<String>();
        urlPatterns.add("/loginEd/*");
        registrationBean.setUrlPatterns(urlPatterns);
        return registrationBean;
    }
}
