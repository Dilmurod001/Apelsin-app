package com.example.kapitalbankapi.controller;

import com.example.kapitalbankapi.payload.ApiResponse;
import com.example.kapitalbankapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    //Get all orders by Customer id
    @GetMapping("{id}")
    public HttpEntity<?>getByCustomer(@PathVariable Integer id){
     ApiResponse apiResponse = orderService.getByCustomer(id);
     return ResponseEntity.ok(apiResponse);
    }

    //Get all orders by date between
    @GetMapping("/ByDate")
    public HttpEntity<?>getAllOrderByDate(@RequestParam Date dateFrom,@RequestParam Date dateTo){
        ApiResponse apiResponse = orderService.getAllOrderByDate(dateFrom,dateTo);
        return ResponseEntity.ok(apiResponse);
    }

    //Get Last orders by customer name
    @GetMapping("/lastOrder")
    public HttpEntity<?> getLastOrders(){
        ApiResponse apiResponse = orderService.getLastOrders();
        return ResponseEntity.ok(apiResponse);
    }

}
