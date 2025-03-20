package com.nexign.orderService.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class OrderRequest {
    private String userType;
    private String productCategory;
    private BigDecimal price;
}
