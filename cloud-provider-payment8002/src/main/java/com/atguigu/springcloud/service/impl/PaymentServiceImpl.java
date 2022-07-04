package com.atguigu.springcloud.service.impl;



import com.atguigu.springcloud.dao.PaymentDao8002;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao8002 paymentDao8002;

    public int create(Payment payment) {
        return paymentDao8002.create(payment);
    }

    public Payment getPaymentById(Long id) {
        return paymentDao8002.getPaymentById(id);
    }
}
