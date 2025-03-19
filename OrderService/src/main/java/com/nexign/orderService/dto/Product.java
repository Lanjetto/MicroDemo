package com.nexign.orderService.dto;

import java.math.BigDecimal;

/**
 * DTO for {@link com.nexign.orderService.entity.ProductEntity}
 */
public record Product(String name, BigDecimal price) {
}