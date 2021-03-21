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
@Table(name="Offer")
public class Offer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private long idOffer;
	
	@Enumerated(EnumType.STRING)
	@Column(name="Type")
	private OfferType typeOffer;

	@Column(name="Description")
	private String descriptionOffer;
	
	@Temporal (TemporalType.DATE)
	@Column(name="Start")
	private Date startOffer;

	@Temporal (TemporalType.DATE)
	@Column(name="Expire")
	private Date finishOffer;

	@Enumerated(EnumType.STRING)
	@Column(name="Status")
	private OfferStatus statusOffer;

	@Column(name="Name")
	private String nameOffer;
	
	@Column(name="Code")
	private String codeOffer;

	@Column(name="MaxRedemption")
	private Integer maxRedemptionOffer;
	
	@ManyToOne
	Agent agent;
	
	@ManyToMany(mappedBy="offers", cascade = CascadeType.ALL) 
	private Set<Contract> contracts;
	
	public Offer(){}
	public Offer(Long idOffer,OfferType typeOffer,String descriptionOffer,Date startOffer,Date finishOffer, OfferStatus statusOffer,String nameOffer,String codeOffer,Integer maxRedemptionOffer){
		this.idOffer=idOffer;this.typeOffer=typeOffer;this.descriptionOffer=descriptionOffer;this.startOffer=startOffer;this.finishOffer=finishOffer;this.statusOffer=statusOffer;this.nameOffer=nameOffer;this.codeOffer=codeOffer;this.maxRedemptionOffer=maxRedemptionOffer;
		
	}
}
