package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryReppository;
import java.util.List;

@Service("categoryService")
public class CategoryService{
	@Autowired
	CategoryReppository categoryReppo;

	public Category saveCategory(Category category) {
        return categoryReppo.save(category);
    }

	public Category getCategoryById(int id) {
        return categoryReppo.findById(id).orElse(null);
    }

	public Page<Category> getAllCategories(int page, int size) {
        return categoryReppo.findAll(PageRequest.of(page, size));
    }

	public Category updateCategory(int id, Category category) {
        category.setId(id);
        return categoryReppo.save(category);
    }
	
	public void deleteCategory(int id) {
		categoryReppo.deleteById(id);
    }
}
