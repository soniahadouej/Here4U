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
	public Date getStartOffer() {
		return startOffer;
	}
	public void setStartOffer(Date startOffer) {
		this.startOffer = startOffer;
	}
	public Date getFinishOffer() {
		return finishOffer;
	}
	public void setFinishOffer(Date finishOffer) {
		this.finishOffer = finishOffer;
	}
	public OfferStatus getStatusOffer() {
		return statusOffer;
	}
	public void setStatusOffer(OfferStatus statusOffer) {
		this.statusOffer = statusOffer;
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
	public Integer getMaxRedemptionOffer() {
		return maxRedemptionOffer;
	}
	public void setMaxRedemptionOffer(Integer maxRedemptionOffer) {
		this.maxRedemptionOffer = maxRedemptionOffer;
	}
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	public Set<Contract> getContracts() {
		return contracts;
	}
	public void setContracts(Set<Contract> contracts) {
		this.contracts = contracts;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agent == null) ? 0 : agent.hashCode());
		result = prime * result + ((codeOffer == null) ? 0 : codeOffer.hashCode());
		result = prime * result + ((contracts == null) ? 0 : contracts.hashCode());
		result = prime * result + ((descriptionOffer == null) ? 0 : descriptionOffer.hashCode());
		result = prime * result + ((finishOffer == null) ? 0 : finishOffer.hashCode());
		result = prime * result + (int) (idOffer ^ (idOffer >>> 32));
		result = prime * result + ((maxRedemptionOffer == null) ? 0 : maxRedemptionOffer.hashCode());
		result = prime * result + ((nameOffer == null) ? 0 : nameOffer.hashCode());
		result = prime * result + ((startOffer == null) ? 0 : startOffer.hashCode());
		result = prime * result + ((statusOffer == null) ? 0 : statusOffer.hashCode());
		result = prime * result + ((typeOffer == null) ? 0 : typeOffer.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Offer other = (Offer) obj;
		if (agent == null) {
			if (other.agent != null)
				return false;
		} else if (!agent.equals(other.agent))
			return false;
		if (codeOffer == null) {
			if (other.codeOffer != null)
				return false;
		} else if (!codeOffer.equals(other.codeOffer))
			return false;
		if (contracts == null) {
			if (other.contracts != null)
				return false;
		} else if (!contracts.equals(other.contracts))
			return false;
		if (descriptionOffer == null) {
			if (other.descriptionOffer != null)
				return false;
		} else if (!descriptionOffer.equals(other.descriptionOffer))
			return false;
		if (finishOffer == null) {
			if (other.finishOffer != null)
				return false;
		} else if (!finishOffer.equals(other.finishOffer))
			return false;
		if (idOffer != other.idOffer)
			return false;
		if (maxRedemptionOffer == null) {
			if (other.maxRedemptionOffer != null)
				return false;
		} else if (!maxRedemptionOffer.equals(other.maxRedemptionOffer))
			return false;
		if (nameOffer == null) {
			if (other.nameOffer != null)
				return false;
		} else if (!nameOffer.equals(other.nameOffer))
			return false;
		if (startOffer == null) {
			if (other.startOffer != null)
				return false;
		} else if (!startOffer.equals(other.startOffer))
			return false;
		if (statusOffer != other.statusOffer)
			return false;
		if (typeOffer != other.typeOffer)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Offer [idOffer=" + idOffer + ", typeOffer=" + typeOffer + ", descriptionOffer=" + descriptionOffer
				+ ", startOffer=" + startOffer + ", finishOffer=" + finishOffer + ", statusOffer=" + statusOffer
				+ ", nameOffer=" + nameOffer + ", codeOffer=" + codeOffer + ", maxRedemptionOffer=" + maxRedemptionOffer
				+ ", agent=" + agent + ", contracts=" + contracts + "]";
	}
	
	
	public Offer(long idOffer, OfferType typeOffer, String descriptionOffer, Date startOffer, Date finishOffer,
			OfferStatus statusOffer, String nameOffer, String codeOffer, Integer maxRedemptionOffer, Agent agent,
			Set<Contract> contracts) {
		super();
		this.idOffer = idOffer;
		this.typeOffer = typeOffer;
		this.descriptionOffer = descriptionOffer;
		this.startOffer = startOffer;
		this.finishOffer = finishOffer;
		this.statusOffer = statusOffer;
		this.nameOffer = nameOffer;
		this.codeOffer = codeOffer;
		this.maxRedemptionOffer = maxRedemptionOffer;
		this.agent = agent;
		this.contracts = contracts;
	}
	public Offer() {

		super();
	}
	
	
	
	
}




