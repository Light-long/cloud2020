package com.tx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsul8000 {

    public static void main(String[] args) {
        SpringApplication.run(OrderConsul8000.class,args);
    }
}
