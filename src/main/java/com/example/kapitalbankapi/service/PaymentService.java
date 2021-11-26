package com.example.kapitalbankapi.service;

import com.example.kapitalbankapi.controller.PaymentController;
import com.example.kapitalbankapi.entity.Order;
import com.example.kapitalbankapi.entity.Payment;
import com.example.kapitalbankapi.payload.ApiResponse;
import com.example.kapitalbankapi.repository.OrderRepository;
import com.example.kapitalbankapi.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    OrderRepository orderRepository;

    public ApiResponse getAllByOrderId(Integer id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if (!optionalOrder.isPresent()) return new ApiResponse("Order does not exists!",false);

        List<Payment> allByOrderId = paymentRepository.findAllByOrderId(id);
        return new ApiResponse("Success",true,allByOrderId);

    }
}
