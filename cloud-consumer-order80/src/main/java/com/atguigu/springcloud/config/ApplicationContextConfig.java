package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


//配置类@Configuration、@Bean，提供容器对象供调用
@Configuration
public class ApplicationContextConfig {

    @Bean        //提供客户端的负载均衡
    @LoadBalanced//使用该注解赋予RestTemplate负载均衡(提供)的能力(两个或多个单独的服务，提供的服务完全一样，默认为轮询)，提供Eureka负载均衡，相同注册服务名(yml文件相同，如何访问)
    public RestTemplate getRestTemplate() {
        return new RestTemplate();

        //这个模块没写完全，暂时终止^=……，可能会一直终止 41集：https://www.bilibili.com/video/BV18E411x7eT?p=44&vd_source=a624d5626dc0011dc56bfc4cc466feb4
    }

}
