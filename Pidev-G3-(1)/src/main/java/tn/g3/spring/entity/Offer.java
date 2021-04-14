package tn.g3.spring.entity;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import tn.g3.spring.entity.ContractOffer;

@Entity
@Table(name="Offer")
public class Offer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column(name="IdOffer")
	private long idOffer; 
	
	@Enumerated(EnumType.STRING)
	@Column(name="TypeOffer")
	private OfferType typeOffer;

	@Column(name="DescriptionOffer")
	private String descriptionOffer;

	@Column(name="NameOffer")
	private String nameOffer;
	
	@Column(name="CodeOffer")
	private String codeOffer;

	@Column(name="MaxRedemption")
	private Integer maxRedemption;
	
	@ManyToOne
	Agent agent;
	
	/*@ManyToMany(mappedBy="offers", cascade = CascadeType.ALL) 
	private Set<Contract> contracts;*/
	
	@OneToMany(mappedBy="offer",cascade = CascadeType.ALL)
	private  List<ContractOffer> contractOffers;

	public long getIdOffer() {
		return idOffer;
	}

	public void setIdOffer(long idOffer) {
		this.idOffer = idOffer;
	}

	public OfferType getTypeOffer() {
		return typeOffer;
	}

	public void setTypeOffer(OfferType typeOffer) {
		this.typeOffer = typeOffer;
	}

	public String getDescriptionOffer() {
		return descriptionOffer;
	}

	public void setDescriptionOffer(String descriptionOffer) {
		this.descriptionOffer = descriptionOffer;
	}

	public String getNameOffer() {
		return nameOffer;
	}

	public void setNameOffer(String nameOffer) {
		this.nameOffer = nameOffer;
	}

	public String getCodeOffer() {
		return codeOffer;
	}

	public void setCodeOffer(String codeOffer) {
		this.codeOffer = codeOffer;
	}

	public Integer getMaxRedemption() {
		return maxRedemption;
	}

	public void setMaxRedemption(Integer maxRedemption) {
		this.maxRedemption = maxRedemption;
	}


	public Offer(long idOffer, String descriptionOffer, String nameOffer,Integer maxRedemption) {
		super();
		this.idOffer = idOffer;
		this.descriptionOffer = descriptionOffer;
		this.nameOffer = nameOffer;
		this.maxRedemption = maxRedemption;
	}

	public Offer() {
		super();
	}

	public Offer(long idOffer, OfferType typeOffer, String descriptionOffer, String nameOffer, String codeOffer,
			Integer maxRedemption) {
		super();
		this.idOffer = idOffer;
		this.typeOffer = typeOffer;
		this.descriptionOffer = descriptionOffer;
		this.nameOffer = nameOffer;
		this.codeOffer = codeOffer;
		this.maxRedemption = maxRedemption;
	}

	public List<ContractOffer> getContractOffers() {
		return contractOffers;
	}

	public void setContractOffers(List<ContractOffer> contractOffers) {
		this.contractOffers = contractOffers;
	}

	
}




