package com.nexign.discountService.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class DiscountRequest {
    private String userType;
    private String productCategory;
    private BigDecimal price;
}

