package com.nexign.orderService.service;

import com.nexign.orderService.dto.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.math.BigDecimal;

@Service
public class DiscountServiceClient {
    private RestClient restClient;

    @Autowired
    public DiscountServiceClient(RestClient restClient) {
        this.restClient = restClient;
    }
    public BigDecimal getDiscount(OrderRequest request) {
        return restClient.post()
                .uri("/discount")
                .contentType(MediaType.APPLICATION_JSON)
                .body(request)
                .retrieve()
                .body(BigDecimal.class);
    }
}
