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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Contract")
public class Contract implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private long idContract;
	
	@Enumerated(EnumType.STRING)
	@Column(name="Product")
	private ProductType productType;
	
	@Column(name="Description")
	private String descriptionContract;

	@Temporal (TemporalType.DATE)
	@Column(name="Start")
	private Date startContract;
	
	@Temporal (TemporalType.DATE)
	@Column(name="Expire")
	private Date finishContract;
	
	@Enumerated(EnumType.STRING)
	@Column(name="Status")
	private ContractStatus statusContract;
	
	@Enumerated(EnumType.STRING)
	@Column(name="Payment")
	private ContractPaymentType paymentType;

	@Column(name="Premium")
	private Float premiumContract;
	

	/*@OneToMany(cascade = CascadeType.ALL, mappedBy="contract")
	private Set<Sinister> sinisters;*/
	
	@ManyToOne
	Product product;
	
	@ManyToOne
	Client client;
	
	@ManyToMany(cascade = CascadeType.ALL) 
	private Set<Offer> offers;
	
	public Contract(){}
	
	public Contract(ProductType productType,String descriptionContract,Date startContract,Date finishContract,ContractStatus statusContract,ContractPaymentType paymentType,Float premiumContract){
		this.productType=productType;this.descriptionContract=descriptionContract;this.startContract=startContract;this.finishContract=finishContract;this.statusContract=statusContract;this.paymentType=paymentType;this.premiumContract=premiumContract;
		
	}
	
	public Contract(Long idContract,ProductType productType,String descriptionContract,Date startContract,Date finishContract,ContractStatus statusContract,ContractPaymentType paymentType,Float premiumContract){
		this.idContract=idContract;this.productType=productType;this.descriptionContract=descriptionContract;this.startContract=startContract;this.finishContract=finishContract;this.statusContract=statusContract;this.paymentType=paymentType;this.premiumContract=premiumContract;
		
	}
	@Override 
	public String toString(){
		return "Contract [idContract ="+idContract +",productType ="+productType +",descriptionContract="+descriptionContract+",startContract="+startContract +",finishContract="+finishContract+",ContractStatus="+ statusContract +",ContractPaymentType=" + paymentType +",premiumContract"+premiumContract +"]" ;
	}
	public long getidContract(){
		return idContract;
	}
	public void setidContract(long idContract){
		this.idContract= idContract;
	}
	public String getdescriptionContract(){
		return descriptionContract;
	}
	public void setdescriptionContract(String descriptionContract){
		this.descriptionContract= descriptionContract;
	}
	public ProductType getproductType(){
		return productType;
	}
	public void setproductType(ProductType productType){
		this.productType= productType;
	}
	public Date getstartContract(){
		return startContract;
	}
	public void setstartContract(Date startContract){
		this.startContract= startContract;
	}
	public Date getfinishContract(){
		return finishContract;
	}
	public void setfinishContract(Date finishContract){
		this.finishContract= finishContract;
	}
	public ContractStatus getstatusContract(){
		return statusContract;
	}
	public void setstatusContract(ContractStatus statusContract){
		this.statusContract= statusContract;
	}
	public ContractPaymentType getpaymentType(){
		return paymentType;
	}
	public void setpaymentType(ContractPaymentType paymentType){
		this.paymentType= paymentType;
	}
	public Float getpremiumContract(){
		return  premiumContract;
	}
	public void setpremiumContract(Float  premiumContract){
		this.premiumContract=  premiumContract;
	}
}
