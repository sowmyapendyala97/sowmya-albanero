package com.example.SpringBasicCurdOperation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBasicCurdOperation.dao.ProductDao;
import com.example.SpringBasicCurdOperation.entity.Product;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;

	public List<Product> getProducts() {
		return productDao.getProducts();
	}

	public String addProduct(Product p) {
		System.out.println(p.getId());
		return productDao.addProduct(p);
	}

	public String updateProduct(String id, Product p) {
		// TODO Auto-generated method stub
		return productDao.updateProduct(id, p);
	}

}
