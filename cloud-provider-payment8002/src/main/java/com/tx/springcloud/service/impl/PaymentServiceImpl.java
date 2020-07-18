package com.tx.springcloud.service.impl;

import com.tx.springcloud.dao.PaymentDao;
import com.tx.springcloud.entity.Payment;
import com.tx.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
