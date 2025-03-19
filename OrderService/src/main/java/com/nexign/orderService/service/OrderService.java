package com.nexign.orderService.service;

import com.nexign.orderService.dto.Order;
import com.nexign.orderService.dto.OrderRequest;
import com.nexign.orderService.entity.OrderEntity;
import com.nexign.orderService.entity.ProductEntity;
import com.nexign.orderService.entity.UserEntity;
import com.nexign.orderService.repostitory.OrderEntityRepository;
import com.nexign.orderService.repostitory.ProductEntityRepository;
import com.nexign.orderService.repostitory.UserEntityRepository;
import com.nexign.orderService.util.OrderEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class OrderService {
    private final OrderEntityRepository orderRepository;
    private final ProductEntityRepository productRepository;
    private final UserEntityRepository userRepository;
    private final DiscountServiceClient discountServiceClient;
    private final OrderEntityMapper orderMapper;

    @Autowired
    public OrderService(OrderEntityRepository orderRepository, ProductEntityRepository productRepository, UserEntityRepository userRepository, DiscountServiceClient discountServiceClient, OrderEntityMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.discountServiceClient = discountServiceClient;
        this.orderMapper = orderMapper;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::toOrder)
                .toList();
    }

    public Optional<Order> getOrderById(Integer id) {
        return orderRepository.findById(id).map(orderMapper::toOrder);
    }

    public Order createOrder(Order orderDto) {
        if (!userRepository.existsById(orderDto.userId()) || !productRepository.existsById(orderDto.productId())) {
            throw new RuntimeException("Invalid userId or productId");
        }

        UserEntity userEntity = userRepository.findById(orderDto.userId()).orElseThrow();
        ProductEntity productEntity = productRepository.findById(orderDto.productId()).orElseThrow();

        OrderRequest request = OrderRequest.builder()
                .userType(userEntity.getType())
                .productCategory(productEntity.getCategory())
                .price(productEntity.getPrice())
                .build();

        double discount = discountServiceClient.getDiscount(request).doubleValue();

        OrderEntity entity = orderMapper.toEntity(orderDto);
        entity.setTotalPrice(productEntity.getPrice().multiply(BigDecimal.valueOf(1-discount)));
        orderRepository.save(entity);
        Logger.getLogger(OrderService.class.getName()).info("Created order: " + entity + "\n Discount: " + discount);
        return orderDto;
    }

    public boolean deleteOrder(Integer id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
