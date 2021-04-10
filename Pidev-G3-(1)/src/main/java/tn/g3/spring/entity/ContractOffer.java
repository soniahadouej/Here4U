package tn.g3.spring.entity;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import tn.g3.spring.entity.Contract;
import tn.g3.spring.entity.Offer;
import tn.g3.spring.entity.ContractOfferPK;

@Entity
public class ContractOffer implements Serializable{

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ContractOfferPK contractOfferPK;
	
	@ManyToOne
    @JoinColumn(name = "idContract", referencedColumnName = "ID", insertable=false, updatable=false)
	private Contract contract; 
	
	@ManyToOne
    @JoinColumn(name = "idOffer", referencedColumnName = "IdOffer", insertable=false, updatable=false)
	private Offer offer;
	
	@Temporal (TemporalType.DATE)
	@Column(name="ExpireOffer")
	private Date expireOffer;
	
	@Enumerated(EnumType.STRING)
	@Column(name="StatusOffer")
	private OfferStatus statusOffer;

	public ContractOfferPK getContractOfferPK() {
		return contractOfferPK;
	}

	public void setContractOfferPK(ContractOfferPK contractOfferPK) {
		this.contractOfferPK = contractOfferPK;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	public Date getExpireOffer() {
		return expireOffer;
	}

	public void setExpireOffer(Date expireOffer) {
		this.expireOffer = expireOffer;
	}

	public OfferStatus getStatusOffer() {
		return statusOffer;
	}

	public void setStatusOffer(OfferStatus statusOffer) {
		this.statusOffer = statusOffer;
	}

	public ContractOffer() {
		super();
	}

	public ContractOffer(ContractOfferPK contractOfferPK, Contract contract, Offer offer, Date expireOffer,
			OfferStatus statusOffer) {
		super();
		this.contractOfferPK = contractOfferPK;
		this.contract = contract;
		this.offer = offer;
		this.expireOffer = expireOffer;
		this.statusOffer = statusOffer;
	}


}
