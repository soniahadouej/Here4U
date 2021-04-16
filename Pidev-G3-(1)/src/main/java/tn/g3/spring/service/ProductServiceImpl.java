package tn.g3.spring.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.g3.spring.entity.Product;
import tn.g3.spring.repository.ProductRepository;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	ProductRepository productrepository;
	private static final Logger L = LogManager.getLogger(ProductServiceImpl.class);
	
	
	@Override
	public List<Product> retrieveAllProducts() {
		List<Product> products = (List<Product>)productrepository.findAll();
		for (Product product:products){
			L.info("product +++ : "+product);
		}
		return products;
	}

	@Override
	public Product addProduct(Product p) {
		Product productsaved=null;
		productsaved =productrepository.save(p);
		return productsaved;
	}

	@Override
	public void deleteProduct(String idp) {
		productrepository.deleteById(Long.parseLong(idp));
		
	}

	@Override
	public Product updateProduct(Product p) {
		Product productadded =productrepository.save(p);
		return productadded ;
	}

	@Override
	public Product retrieveProduct(String idp) {
		Product p = productrepository.findById(Long.parseLong(idp)).orElse(null);
		return p;
	}

}
