package com.rajesh.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rajesh.model.Product;
import com.rajesh.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	
	public List<Product> getAllProducts() {
		return repository.findAll();
	}

	public Product getProductById(int id) {
		return repository.findById(id).orElse(null);
	}

	public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
		product.setImageName(imageFile.getOriginalFilename());
		product.setImageType(imageFile.getContentType());
		product.setImageDate(imageFile.getBytes());
		return repository.save(product);
	}

	public Product updateProduct(int id, Product product, MultipartFile imageFile) throws IOException {
		product.setImageDate(imageFile.getBytes());
		product.setImageName(imageFile.getOriginalFilename());
		product.setImageType(imageFile.getContentType());
		return repository.save(product);
		
	}

	public void deleteProduct(int id) {
		repository.deleteById(id);
		
	}

	public List<Product> seaarchProducts(String keyword) {
		return repository.searchProducts(keyword);
	}
}
