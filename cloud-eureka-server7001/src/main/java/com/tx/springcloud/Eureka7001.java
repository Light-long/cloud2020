package com.tx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import sun.swing.SwingUtilities2;

@SpringBootApplication
@EnableEurekaServer
public class Eureka7001 {

    public static void main(String[] args) {
        SpringApplication.run(Eureka7001.class,args);
    }
}
