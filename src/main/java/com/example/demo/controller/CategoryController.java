package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;

import com.example.demo.entity.Category;
import com.example.demo.service.CategoryService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@PostMapping
	public ResponseEntity<Category> saveCategory(@RequestBody Category category) {
		Category savedCategory = categoryService.saveCategory(category);
		return savedCategory != null ? new ResponseEntity<>(savedCategory, HttpStatus.CREATED)
				: new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable int id) {
		Category category = categoryService.getCategoryById(id);
		return category != null ? new ResponseEntity<>(category, HttpStatus.OK)
				: new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@GetMapping
	public ResponseEntity<Page<Category>> getAllCategories(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		Page<Category> categories = categoryService.getAllCategories(page, size);
		return new ResponseEntity<>(categories, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable int id, @RequestBody Category category) {
		Category updatedCategory = categoryService.updateCategory(id, category);
		return updatedCategory != null ? new ResponseEntity<>(updatedCategory, HttpStatus.OK)
				: new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCategory(@PathVariable int id) {
		categoryService.deleteCategory(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
