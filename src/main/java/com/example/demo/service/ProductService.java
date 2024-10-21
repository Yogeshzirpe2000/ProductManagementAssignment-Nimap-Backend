package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductReppository;

@Service("productService")
public class ProductService {

	@Autowired
	ProductReppository productReppo;

	public Product saveProduct(Product product) {
		return productReppo.save(product);
	}

	public Page<Product> getAllProducts(int page, int size) {
		return productReppo.findAll(PageRequest.of(page, size));
	}

	public Optional<Product> getProductById(int id) {
		return productReppo.findById(id);
	}

	public Product updateProduct(int id, Product product) {
		product.setId(id);
		return productReppo.save(product);
	}

	public void deleteProduct(int id) {
		productReppo.deleteById(id);
	}
}
