package com.atguigu.springcloud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;


@RestController
@Slf4j
public class OrderZKController {

    public static final String INVOKE_URL = "http://cloud-provider-payment";//要调用的服务地址，zookeeper上的直接出来的名字

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/payment/zk")
    public String paymentInfo() {
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);//第二个参数表示返回值类型类
        System.out.println("消费者调用支付服务(zookeeper)--->result:" + result);
        return result;
    }

}



