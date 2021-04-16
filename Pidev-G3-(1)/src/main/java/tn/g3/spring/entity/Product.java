package tn.g3.spring.entity;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Table(name="Product")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column(name="IdProduct")
	private long idProduct;
	
	@Enumerated(EnumType.STRING)
	@Column(name="Type")
	private ProductType productType;

	@Column(name="Description")
	private String descriptionProduct;

	@Temporal (TemporalType.DATE)
	@Column(name="Start")
	private Date startProduct;

	@Temporal (TemporalType.DATE)
	@Column(name="Expire")
	private Date finishProduct;

	@Enumerated(EnumType.STRING)
	@Column(name="ProductStatus")
	private ProductStatus statusProduct;
	
	@Column(name="Feedback")
	private String feedback;

	@Column(name="Name")
	private String nameProduct;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="product")
	private Set<Contract> contracts;
	
	@ManyToOne
	Agent agent;

	public long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(long idProduct) {
		this.idProduct = idProduct;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public String getDescriptionProduct() {
		return descriptionProduct;
	}

	public void setDescriptionProduct(String descriptionProduct) {
		this.descriptionProduct = descriptionProduct;
	}

	public Date getStartProduct() {
		return startProduct;
	}

	public void setStartProduct(Date startProduct) {
		this.startProduct = startProduct;
	}

	public Date getFinishProduct() {
		return finishProduct;
	}

	public void setFinishProduct(Date finishProduct) {
		this.finishProduct = finishProduct;
	}

	public ProductStatus getStatusProduct() {
		return statusProduct;
	}

	public void setStatusProduct(ProductStatus statusProduct) {
		this.statusProduct = statusProduct;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public Agent getAgent() {
		return agent;
	}

	public Product() {
		super();
	}

	public Product(long idProduct, ProductType productType, String descriptionProduct, Date startProduct,
			Date finishProduct, ProductStatus statusProduct, String feedback, String nameProduct) {
		super();
		this.idProduct = idProduct;
		this.productType = productType;
		this.descriptionProduct = descriptionProduct;
		this.startProduct = startProduct;
		this.finishProduct = finishProduct;
		this.statusProduct = statusProduct;
		this.feedback = feedback;
		this.nameProduct = nameProduct;
	}

	public Product(ProductType productType, String descriptionProduct, Date startProduct, Date finishProduct,
			ProductStatus statusProduct, String feedback, String nameProduct) {
		super();
		this.productType = productType;
		this.descriptionProduct = descriptionProduct;
		this.startProduct = startProduct;
		this.finishProduct = finishProduct;
		this.statusProduct = statusProduct;
		this.feedback = feedback;
		this.nameProduct = nameProduct;
	} 

	
	
	

}