package com.nexign.orderService.repostitory;

import com.nexign.orderService.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductEntityRepository extends JpaRepository<ProductEntity, Integer> {
}