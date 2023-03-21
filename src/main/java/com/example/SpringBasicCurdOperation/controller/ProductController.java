package com.example.SpringBasicCurdOperation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBasicCurdOperation.entity.Product;
import com.example.SpringBasicCurdOperation.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping(value ="/getProducts")
	public List<Product> getProducts() {
		return productService.getProducts();
		}
	
	
	@GetMapping(value ="/getProducts/{pName}")
	public String getVowelsInString(@PathVariable("pName") String ProductName) {
		return ProductName;
		//return productService.getProducts();
		}
	
	
	@PostMapping("/addProduct")
	public String addProduct(@RequestBody Product p){
		
		return productService.addProduct(p);
	}
	
	@PutMapping("/updateProduct/{id}")
	public String updateProduct(@PathVariable("id") String id , @RequestBody Product p){
		
		return productService.updateProduct(id,p);
	}

}
