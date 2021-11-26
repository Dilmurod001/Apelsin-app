package com.example.kapitalbankapi.controller;

import com.example.kapitalbankapi.payload.ApiResponse;
import com.example.kapitalbankapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    //Get all customers name who not order 2020
    @GetMapping("/NotOrdered2020")
    public HttpEntity<?>getAllByNotOrder(){
        ApiResponse apiResponse = customerService.getAllByNotOrder();
        return ResponseEntity.ok(apiResponse);
    }

    //Get all customers name who order 2020
    @GetMapping("/Ordered2020")
    public HttpEntity<?>getAllByOrder(){
        ApiResponse apiResponse = customerService.getAllByOrder();
        return ResponseEntity.ok(apiResponse);
    }


}
