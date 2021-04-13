package tn.g3.spring.entity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;




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
	

	@Enumerated(EnumType.STRING)
	@Column(name="Currency")
	private CurrencyContrat currency;
	
	private String intent;

	@Column(name="Premium")
	private Float premiumContract;
	
	

	/*@OneToMany(cascade = CascadeType.ALL, mappedBy="contract")
	private Set<Sinister> sinisters;*/
	
	////////////////////////////////////////////////
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "idPerson",referencedColumnName="IdPerson")
	 private Person person;
	
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="transactionprice")
	private List<Transaction> transactionCredit;
	
	
	
	/* ********************************** */
	
	
	public long getIdContract() {
		return idContract;
	}

	public String getIntent() {
		return intent;
	}

	public void setIntent(String intent) {
		this.intent = intent;
	}

	public CurrencyContrat getCurrency() {
		return currency;
	}

	public void setCurrency(CurrencyContrat currency) {
		this.currency = currency;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<Transaction> getTransactionCredit() {
		return transactionCredit;
	}

	public void setTransactionCredit(List<Transaction> transactionCredit) {
		this.transactionCredit = transactionCredit;
	}

	public void setIdContract(long idContract) {
		this.idContract = idContract;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public String getDescriptionContract() {
		return descriptionContract;
	}

	public void setDescriptionContract(String descriptionContract) {
		this.descriptionContract = descriptionContract;
	}

	public Date getStartContract() {
		return startContract;
	}

	public void setStartContract(Date startContract) {
		this.startContract = startContract;
	}

	public Date getFinishContract() {
		return finishContract;
	}

	public void setFinishContract(Date finishContract) {
		this.finishContract = finishContract;
	}

	public ContractStatus getStatusContract() {
		return statusContract;
	}

	public void setStatusContract(ContractStatus statusContract) {
		this.statusContract = statusContract;
	}

	public ContractPaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(ContractPaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public Float getPremiumContract() {
		return premiumContract;
	}

	public void setPremiumContract(Float premiumContract) {
		this.premiumContract = premiumContract;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Set<Offer> getOffers() {
		return offers;
	}

	public void setOffers(Set<Offer> offers) {
		this.offers = offers;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@ManyToOne
	Product product;
	
	@ManyToOne
	Client client;
	
	@ManyToMany(cascade = CascadeType.ALL) 
	private Set<Offer> offers;
	
	
	public Contract(){}
	
	public Contract(Long idContract,ProductType productType,String descriptionContract,Date startContract,Date finishContract,ContractStatus statusContract,ContractPaymentType paymentType,Float premiumContract){
		this.idContract=idContract;this.productType=productType;this.descriptionContract=descriptionContract;this.startContract=startContract;this.finishContract=finishContract;this.statusContract=statusContract;this.paymentType=paymentType;this.premiumContract=premiumContract;
		
	}

	public Contract(long idContract, ProductType productType, String descriptionContract, Date startContract,
			Date finishContract, ContractStatus statusContract, ContractPaymentType paymentType, Float premiumContract,
			Product product, Client client, Set<Offer> offers) {
		super();
		this.idContract = idContract;
		this.productType = productType;
		this.descriptionContract = descriptionContract;
		this.startContract = startContract;
		this.finishContract = finishContract;
		this.statusContract = statusContract;
		this.paymentType = paymentType;
		this.premiumContract = premiumContract;
		this.product = product;
		this.client = client;
		this.offers = offers;
	}

	public Contract(ProductType productType, String descriptionContract, Date startContract, Date finishContract,
			ContractStatus statusContract, ContractPaymentType paymentType, Float premiumContract, Product product,
			Client client, Set<Offer> offers) {
		super();
		this.productType = productType;
		this.descriptionContract = descriptionContract;
		this.startContract = startContract;
		this.finishContract = finishContract;
		this.statusContract = statusContract;
		this.paymentType = paymentType;
		this.premiumContract = premiumContract;
		this.product = product;
		this.client = client;
		this.offers = offers;
	}

	
}
