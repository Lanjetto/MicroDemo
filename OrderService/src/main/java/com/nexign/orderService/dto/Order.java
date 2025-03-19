package com.nexign.orderService.dto;

/**
 * DTO for {@link com.nexign.orderService.entity.OrderEntity}
 */
public record Order(Integer userId, Integer productId) {
}