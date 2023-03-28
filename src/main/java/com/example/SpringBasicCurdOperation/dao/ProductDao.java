package com.example.SpringBasicCurdOperation.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.SpringBasicCurdOperation.entity.Product;

@Repository
public class ProductDao {

	public static List<Product> pList = new ArrayList<>();

	static {
		Product p1 = new Product();
		p1.setId("1");
		p1.setProductName("Baloons");
		pList.add(p1);

		Product p2 = new Product();
		p2.setId("2");
		p2.setProductName("cars");
		pList.add(p2);

		Product p3 = new Product();
		p3.setId("3");
		p3.setProductName("printers");
		pList.add(p3);
	}

	public List<Product> getProducts() {
		return pList;
	}

	public String addProduct(Product p) {
		String val = null;
		Product pObj;
		if (p != null && p.getId() != null && p.getProductName() != null) {
			pObj = new Product();
			System.out.println(p.getId());
			pObj.setId(p.getId());
			pObj.setProductName(p.getProductName());
			System.out.println(p.getProductName());
			pList.add(p);
			val = "Product added Succesfully";
		} else {
			val = "unable to add product.please verify the product details ";
		}
		return val;

	}

	public String updateProduct(String id, Product p) {
		Optional<Product> product = pList.stream().filter(prod -> prod.getId().equals(id)).findFirst();
		if (product.isPresent()) {

			product.get().setId(p.getId());
			product.get().setProductName(p.getProductName());
			;

		}
		return "updated sucessfully";
	}
}
