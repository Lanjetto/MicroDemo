package com.nexign.notificationService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NotificationRunner {
    public static void main(String[] args) {
        SpringApplication.run(NotificationRunner.class,args);
    }
}
