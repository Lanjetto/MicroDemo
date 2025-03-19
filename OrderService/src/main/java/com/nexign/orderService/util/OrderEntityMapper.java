package com.nexign.orderService.util;

import com.nexign.orderService.dto.Order;
import com.nexign.orderService.entity.OrderEntity;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderEntityMapper {
    OrderEntityMapper INSTANCE = Mappers.getMapper(OrderEntityMapper.class);
    @Mapping(source = "productId", target = "product.id")
    @Mapping(source = "userId", target = "user.id")
    OrderEntity toEntity(Order order);

    @InheritInverseConfiguration(name = "toEntity")
    Order toOrder(OrderEntity orderEntity);
}