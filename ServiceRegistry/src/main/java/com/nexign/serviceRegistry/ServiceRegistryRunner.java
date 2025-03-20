package com.nexign.serviceRegistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistryRunner {
    public static void main(String[] args) {
        SpringApplication.run(ServiceRegistryRunner.class, args);
    }
}
