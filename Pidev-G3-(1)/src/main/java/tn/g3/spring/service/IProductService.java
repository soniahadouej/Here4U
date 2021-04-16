package tn.g3.spring.service;

import java.util.List;

import tn.g3.spring.entity.Product;

public interface IProductService {

	List<Product> retrieveAllProducts();
	Product addProduct(Product p);
	void deleteProduct(String idp);
	Product updateProduct(Product p);
	Product retrieveProduct(String idp);
}
