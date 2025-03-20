package com.nexign.notificationService.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationListener {
    @RabbitListener(queues = "${rabbitmq.queue}")
    public void receiveOrder(String order) {
        System.out.println("Received order: " + order);
    }
}
