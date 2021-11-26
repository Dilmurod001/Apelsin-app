package com.example.kapitalbankapi.component;

import com.example.kapitalbankapi.entity.*;
import com.example.kapitalbankapi.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.security.Timestamp;
import java.util.Date;

@Component
public class Dataloader implements CommandLineRunner {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    DetailRepository detailRepository;
    @Autowired
    InvoiceRepository invoiceRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    ProductRepository productRepository;


    @Value("${spring.sql.init.mode}")
    private String initMode;

    @Override
    public void run(String... args) throws Exception {


        if (initMode.equals("always")) {
            Customer customer = customerRepository.save(new Customer("Dilmurod", "Uzbekistan", "Nurafshon 40-uy", "900075764"));
            Customer customer2 = customerRepository.save(new Customer("Sardor", "Uzbekistan", "Darxan-14", "998995979"));
            Customer customer3 = customerRepository.save(new Customer("Erkin", "Uzbekistan", "Kuchluk-11", "949221292"));
            Order order = orderRepository.save(new Order(new Date(), customer));
            Order order2 = orderRepository.save(new Order(new Date(), customer2));
            Order order3 = orderRepository.save(new Order(new Date(), customer3));

            Invoice invoice = invoiceRepository.save(new Invoice(order, 15, new Date(), new Date()));
            Invoice invoice2 = invoiceRepository.save(new Invoice(order2, 15, new Date(), new Date()));
            Invoice invoice3 = invoiceRepository.save(new Invoice(order3, 15, new Date(), new Date()));

            Category category = categoryRepository.save(new Category("Phone"));
            Category category2 = categoryRepository.save(new Category("Laptop"));
            Product product = productRepository.save(new Product("Iphone", "Iphone 11 pro", 1200, category));
            Product product2 = productRepository.save(new Product("Macbook", "Macbook m5 pro", 2200, category2));
            Detail detail = detailRepository.save(new Detail(order, product, 4));
            Detail detail2 = detailRepository.save(new Detail(order2, product2, 3));

            paymentRepository.save(new Payment(new Date(), 5d, invoice));
            paymentRepository.save(new Payment(new Date(), 3d, invoice2));
            paymentRepository.save(new Payment(new Date(), 4d, invoice3));


        }
    }
}
