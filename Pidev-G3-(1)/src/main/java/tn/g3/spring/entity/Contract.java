package tn.g3.spring.entity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Contract")
public class Contract implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column(name="idContract")
	private long idContract;
	
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
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="contract", fetch = FetchType.LAZY)
	private  List<ContractOffer> contractOffers;
	
	public Contract(){}
	
	public Contract(String descriptionContract,Date startContract,Date finishContract,ContractStatus statusContract,ContractPaymentType paymentType,Float premiumContract){
		this.descriptionContract=descriptionContract;this.startContract=startContract;this.finishContract=finishContract;this.statusContract=statusContract;this.paymentType=paymentType;this.premiumContract=premiumContract;
		
	}
	
	public Contract(Long idContract,String descriptionContract,Date startContract,Date finishContract,ContractStatus statusContract,ContractPaymentType paymentType,Float premiumContract){
		this.idContract=idContract;this.descriptionContract=descriptionContract;this.startContract=startContract;this.finishContract=finishContract;this.statusContract=statusContract;this.paymentType=paymentType;this.premiumContract=premiumContract;
		
	}
	@Override 
	public String toString(){
		return "Contract [idContract ="+idContract +",descriptionContract="+descriptionContract+",startContract="+startContract +",finishContract="+finishContract+",ContractStatus="+ statusContract +",ContractPaymentType=" + paymentType +",premiumContract"+premiumContract +"]" ;
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

	public Contract(long idContract, String descriptionContract, Date startContract, Date finishContract,
			ContractStatus statusContract, ContractPaymentType paymentType, Float premiumContract, Product product,
			Client client) {
		super();
		this.idContract = idContract;
		this.descriptionContract = descriptionContract;
		this.startContract = startContract;
		this.finishContract = finishContract;
		this.statusContract = statusContract;
		this.paymentType = paymentType;
		this.premiumContract = premiumContract;
		this.product = product;
		this.client = client;
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
}