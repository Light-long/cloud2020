package com.tx.springcloud.controller;

import com.tx.springcloud.entity.CommonResult;
import com.tx.springcloud.entity.Payment;
import com.tx.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping(value = "/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/create")
    public CommonResult create(Payment payment) {
        int result = paymentService.create(payment);
        log.info("result="+result);
        if (result > 0) {
            return new CommonResult(200,"插入数据库成功",result);
        } else {
            return new CommonResult(404,"插入数据库失败",null);
        }
    }

    @GetMapping(value = "/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("payment="+payment);
        if (!StringUtils.isEmpty(payment)) {
            return new CommonResult(200,"查询成功",payment);
        } else {
            return new CommonResult(404,"没有对应记录"+id,null);
        }
    }
}
