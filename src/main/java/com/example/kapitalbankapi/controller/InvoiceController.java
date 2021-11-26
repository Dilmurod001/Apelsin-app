package com.example.kapitalbankapi.controller;

import com.example.kapitalbankapi.payload.ApiResponse;
import com.example.kapitalbankapi.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {
    @Autowired
    InvoiceService invoiceService;

    @GetMapping
    public HttpEntity<?>getInvoiceIssued(){
        ApiResponse apiResponse =invoiceService.getInvoiceIssued();
        return  ResponseEntity.ok(apiResponse);
    }
}
