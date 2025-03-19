package com.nexign.discountService.controller;

import com.nexign.discountService.dto.DiscountRequest;
import com.nexign.discountService.dto.DiscountResponse;
import com.nexign.discountService.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
public class DiscountRuleController {

    private final DiscountService discountService;


    @PostMapping("/discount")
    public ResponseEntity<BigDecimal> calculateDiscount(@RequestBody DiscountRequest request) {
        return ResponseEntity.ok(discountService.calculateDiscount(request).getDiscountAmount());
    }

}
