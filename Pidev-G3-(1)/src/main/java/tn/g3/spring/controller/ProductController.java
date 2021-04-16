package tn.g3.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.g3.spring.entity.Product;
import tn.g3.spring.service.IProductService;

@RestController
public class ProductController { 

	@Autowired
	IProductService prs;

	// http://localhost:8080/SpringMVC/servlet/retrieve-all-product
	@GetMapping("/retrieve-all-product")
	@ResponseBody
	public List<Product> getProducts() {
		List<Product> list = prs.retrieveAllProducts();
		return list;
	} 

	// http://localhost:8080/SpringMVC/servlet/retrieve-product/{product-id}
	@GetMapping("/retrieve-product/{product-id}")
	@ResponseBody
	public Product retrieveProduct(@PathVariable("product-id") String idp) {
		return prs.retrieveProduct(idp);
	} 


	// http://localhost:8080/SpringMVC/servlet/add-product 
	@PostMapping("/add-product") 
	@ResponseBody
	public Product addProduct(@RequestBody Product p) {
		Product product = prs.addProduct(p); 
		return product;
	}

	// http://localhost:8080/SpringMVC/servlet/remove-product/{product-id}
	@DeleteMapping("/remove-product/{product-id}") 
	@ResponseBody
	public void removeProduct(@PathVariable("product-id") String idp) { 
		prs.deleteProduct(idp);
	} 



	// http://localhost:8080/SpringMVC/servlet/update-product 
	@PutMapping("/update-product") 
	@ResponseBody
	public Product updateProduct(@RequestBody Product p) {
		return prs.updateProduct(p);
	}


}
