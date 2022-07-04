package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/*
* 客户端服务接口，根据所显示的服务名称去调用微服务所能够暴露对外的服务方法
* 即，方法上@GetMapping，对应的地址*/
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE") //value或name值表示调用的微服务名称,字符串表示
public interface PaymentFeignService {

    @GetMapping(value = "/payment/get/{id}")//定义的接口，由哪个方法找的指定的微服务名称
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/feign/timeout")
    String paymentFeignTimeOut();

}
