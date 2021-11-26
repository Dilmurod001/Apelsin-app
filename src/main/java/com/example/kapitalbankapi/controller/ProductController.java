package com.example.kapitalbankapi.controller;

import com.example.kapitalbankapi.payload.ApiResponse;
import com.example.kapitalbankapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    ProductService productService;

    //Get all info about sold product by customer id
    @GetMapping("{id}")
    public HttpEntity<?> getProductInfoByCustomer(@PathVariable Integer id){
        ApiResponse apiResponse = productService.getProductInfoByCustomer(id);
        return ResponseEntity.ok(apiResponse);
    }

    //Get all products which sold more than 10quantity
    @GetMapping
    public HttpEntity<?> getProducts(){
        ApiResponse apiResponse = productService.getProducts();
        return ResponseEntity.ok(apiResponse);
    }

    //Get products name which sold more than 8quantity in one time by customer
    @GetMapping("/getAllWhereQuantityMax")
    public HttpEntity<?> getAllByQuantity(){
        ApiResponse apiResponse = productService.getAllByQuantity();
        return ResponseEntity.ok(apiResponse);
    }

    //Get 10 expensive products
    @GetMapping("/getTenExpensive")
    public HttpEntity<?> getTenExpensive(){
        ApiResponse apiResponse = productService.getTenExpensive();
        return ResponseEntity.ok(apiResponse);
    }



}
