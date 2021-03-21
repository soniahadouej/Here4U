package tn.g3.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;


import javax.persistence.DiscriminatorValue;

@Entity
@DiscriminatorValue("Life")
public class Product1 extends Product implements Serializable {

	
	@Column(name="Details")
	private String detailsProd1;
	
	public Product1(){}
	public Product1(Long idProduct,String productType,String descriptionProduct,Date startProduct,Date finishProduct,ProductStatus statusProduct,String feedback,String nameProduct,String detailsProd1){
		super(idProduct,productType,descriptionProduct,startProduct,finishProduct,statusProduct,feedback,nameProduct);
		this.detailsProd1=detailsProd1;
		
	}

}
