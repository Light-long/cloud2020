package com.tx.springcloud.service;

import com.tx.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {

    /*添加一个payment*/
    int create(Payment payment);

    /*根据id获取payment*/
    Payment getPaymentById(@Param("id")Long id);
}
