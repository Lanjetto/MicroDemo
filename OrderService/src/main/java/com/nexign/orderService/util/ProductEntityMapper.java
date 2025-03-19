package com.nexign.orderService.util;

import com.nexign.orderService.dto.Product;
import com.nexign.orderService.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductEntityMapper {
    ProductEntity toEntity(Product product);
    Product toProduct(ProductEntity productEntity);
}