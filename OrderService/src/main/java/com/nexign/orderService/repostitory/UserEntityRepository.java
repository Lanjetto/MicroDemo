package com.nexign.orderService.repostitory;

import com.nexign.orderService.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityRepository extends JpaRepository<UserEntity, Integer> {
}