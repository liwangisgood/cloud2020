package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {//远程调用该服务插入对象数据内容 需要方法参数前@RequestBody
        int result = paymentService.create(payment);
        log.info("*****插入结果：" + result);

        if (result > 0) {
            return new CommonResult(200, "插入数据库成功,server.port:" + port, null);
        } else {
            return new CommonResult(444, "插入数据库失败,server.port:" + port, null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        System.out.println("现在要热部署了" + id);
        if (payment != null) {
            return new CommonResult(200, "查询成功,server.port:" + port, payment);
        } else {
            return new CommonResult(444, "没有对应记录,查询ID: " + id + " server.port:" + port, null);
        }
    }


}
