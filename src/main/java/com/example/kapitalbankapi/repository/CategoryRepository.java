package com.example.kapitalbankapi.repository;

import com.example.kapitalbankapi.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
