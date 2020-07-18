package com.tx.springcloud.dao;

import com.tx.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {

    /*添加一个payment*/
    int create(Payment payment);

    /*根据id获取payment*/
    Payment getPaymentById(@Param("id")Long id);
}
