package com.nexign.orderService.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Value("${discount.service.url}")
    private String notificationServiceUrl;

    @Bean
    public RestClient restClient() {
        return RestClient.create(notificationServiceUrl);
    }
}