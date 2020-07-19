package com.tx.springcloud.controller;

import com.tx.springcloud.entity.CommonResult;
import com.tx.springcloud.entity.Payment;
import com.tx.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("result="+result);
        if (result > 0) {
            return new CommonResult(200,"插入数据库成功,serverPort: "+serverPort,result);
        } else {
            return new CommonResult(404,"插入数据库失败",null);
        }
    }

    @GetMapping(value = "/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("payment="+payment);
        if (!StringUtils.isEmpty(payment)) {
            return new CommonResult(200,"查询成功,serverPort: "+serverPort,payment);
        } else {
            return new CommonResult(404,"没有对应记录"+id,null);
        }
    }

    @GetMapping("/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        services.forEach(service-> log.info("service = " + service));

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.forEach(instance->log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getUri()));

        return this.discoveryClient;
    }

}
