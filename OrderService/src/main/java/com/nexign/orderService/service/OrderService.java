package com.nexign.orderService.service;

import com.nexign.orderService.dto.Order;
import com.nexign.orderService.entity.OrderEntity;
import com.nexign.orderService.repostitory.OrderEntityRepository;
import com.nexign.orderService.repostitory.ProductEntityRepository;
import com.nexign.orderService.repostitory.UserEntityRepository;
import com.nexign.orderService.util.OrderEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderEntityRepository orderRepository;
    private final ProductEntityRepository productRepository;
    private final UserEntityRepository userRepository;
    private final OrderEntityMapper orderMapper;

    @Autowired
    public OrderService(OrderEntityRepository orderRepository, ProductEntityRepository productRepository, UserEntityRepository userRepository, OrderEntityMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
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
        OrderEntity entity = orderMapper.toEntity(orderDto);
        entity.setTotalPrice(productRepository.findById(orderDto.productId()).orElseThrow().getPrice());
        orderRepository.save(entity);
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
