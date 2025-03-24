package com.nexign.discountService.service;

import com.nexign.discountService.dto.DiscountRequest;
import com.nexign.discountService.dto.DiscountResponse;
import com.nexign.discountService.repository.DiscountRuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class DiscountService {
    private final DiscountRuleRepository discountRepository;


    @Autowired
    public DiscountService(DiscountRuleRepository discountRepository) {
        this.discountRepository = discountRepository;
    }

    public DiscountResponse calculateDiscount(DiscountRequest request) {
        String userType = request.getUserType();
        String productCategory = request.getProductCategory();
        BigDecimal price = request.getPrice();

        return discountRepository.findFirstByUserTypeAndProductCategoryAndMinOrderAmountLessThanEqual(
                        userType, productCategory, price)
                .map(rule -> {
                    BigDecimal discount = rule.getDiscountType().equals("PERCENT")
                            ? price.multiply(rule.getDiscountValue())
                            : rule.getDiscountValue();
                    return new DiscountResponse(discount);
                })
                .orElse(new DiscountResponse(BigDecimal.ZERO));
    }
}
