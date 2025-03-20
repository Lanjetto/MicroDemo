package com.nexign.discountService.repository;

import com.nexign.discountService.entity.DiscountRule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.Optional;

public interface DiscountRuleRepository extends JpaRepository<DiscountRule, Integer> {
    Optional<DiscountRule> findFirstByUserTypeAndProductCategoryAndMinOrderAmountLessThanEqual(
            String userType, String productCategory, BigDecimal minOrderAmount);
}