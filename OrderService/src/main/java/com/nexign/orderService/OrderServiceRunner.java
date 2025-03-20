package com.nexign.orderService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderServiceRunner {
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceRunner.class, args);
    }
}
