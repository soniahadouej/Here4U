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


import javax.persistence.DiscriminatorColumn;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Type")
@Table(name="Product")
public abstract class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	protected long idProduct;
	
	@Column(name="Type",insertable=false,updatable=false)
	protected String productType;

	@Column(name="Description")
	protected String descriptionProduct;

	@Temporal (TemporalType.DATE)
	@Column(name="Start")
	protected Date startProduct;

	@Temporal (TemporalType.DATE)
	@Column(name="Expire")
	protected Date finishProduct;

	@Enumerated(EnumType.STRING)
	@Column(name="ProductStatus")
	protected ProductStatus statusProduct;
	
	@Column(name="Feedback")
	protected String feedback;

	@Column(name="Name")
	protected String nameProduct;
	
	/*@OneToMany(cascade = CascadeType.ALL, mappedBy="product")
	private Set<Contract> contracts;
	*/
	@ManyToOne
	Agent agent;
	
	public Product(){}
	public Product(Long idProduct,String productType,String descriptionProduct,Date startProduct,Date finishProduct,ProductStatus statusProduct,String feedback,String nameProduct){
		this.idProduct=idProduct;this.productType=productType;this.descriptionProduct=descriptionProduct;this.startProduct=startProduct;this.finishProduct=finishProduct;this.statusProduct=statusProduct;this.feedback=feedback;this.nameProduct=nameProduct;
		
	}

}