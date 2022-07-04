package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper//8002的
public interface PaymentDao8002 {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
