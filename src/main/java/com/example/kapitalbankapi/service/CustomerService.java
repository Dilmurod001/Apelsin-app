package com.example.kapitalbankapi.service;

import com.example.kapitalbankapi.payload.ApiResponse;
import com.example.kapitalbankapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public ApiResponse getAllByNotOrder() {
        List<?> notOrder2020 = customerRepository.getAllByNotOrder2020();
        return new ApiResponse("Success",true,notOrder2020);

    }

    public ApiResponse getAllByOrder() {
        List<?> allOrder2020 = customerRepository.getAllOrder2020();
        return new ApiResponse("Success",true,allOrder2020);

    }
}
