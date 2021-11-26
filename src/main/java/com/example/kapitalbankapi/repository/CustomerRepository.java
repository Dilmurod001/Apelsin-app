package com.example.kapitalbankapi.repository;


import com.example.kapitalbankapi.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    @Query(value = "select c.name,c.id from orders o natural join customer c where o.date not between '2020-01-01' and '2020-12-31'",nativeQuery = true)
    List<?>getAllByNotOrder2020();

    @Query(value = "select o.customer_id,sum(d.quantity) from customer c natural join orders o natural join detail d where o.date>='2020-01-01' and o.date<='2020-12-31'  group by o.customer_id",nativeQuery = true)
    List<?>getAllOrder2020();
}
