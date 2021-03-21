package tn.g3.spring.entity;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;


import javax.persistence.DiscriminatorValue;

@Entity
@DiscriminatorValue("Health")
public class Product2 extends Product implements Serializable {


	@Column(name="Details")
	private String detailsProd2;
	
	public Product2(){}
	
	public Product2(Long idProduct,String productType,String descriptionProduct,Date startProduct,Date finishProduct,ProductStatus statusProduct,String feedback,String nameProduct,String detailsProd2){
		super(idProduct,productType,descriptionProduct,startProduct,finishProduct,statusProduct,feedback,nameProduct);
		this.detailsProd2=detailsProd2;
		
	}
}
