package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Product;
@Repository("productReppo")
public interface ProductReppository extends JpaRepository<Product, Integer>{

}
