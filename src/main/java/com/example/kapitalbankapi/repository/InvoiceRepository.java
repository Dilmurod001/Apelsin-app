package com.example.kapitalbankapi.repository;

import com.example.kapitalbankapi.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {
    @Query(value = "select * from invoice where issued>=due",nativeQuery = true)
    List<?> getAllByIssued();
}
