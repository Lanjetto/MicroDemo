package com.nexign.orderService.repostitory;

import com.nexign.orderService.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderEntityRepository extends JpaRepository<OrderEntity, Integer> {
}