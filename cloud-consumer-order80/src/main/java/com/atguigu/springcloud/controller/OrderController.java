package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    //    public static final String PAYMENT_URL="http://localhost:8001";//写死的微服务名称调用
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";//调用Eureka网站显示服务注册的服务，可能多个微服务模块(yml先配置当前服务文件名配置名称)

    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        System.out.println(payment);//Payment(id=null, serial=7191),与直接调用provider服务方法(@ResponseBody参数)
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("consumer/payment/get/{id}")//开始加不加/都可以
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }


    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult getPayment2(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if (forEntity.getStatusCode().is2xxSuccessful()) {
            return forEntity.getBody();
        } else {
            return new CommonResult(444, "操作失误", null);
        }
    }


}
