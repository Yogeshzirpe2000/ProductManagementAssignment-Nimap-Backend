package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Category;
@Repository("categoryReppo")
public interface CategoryReppository extends JpaRepository<Category, Integer>{

}
