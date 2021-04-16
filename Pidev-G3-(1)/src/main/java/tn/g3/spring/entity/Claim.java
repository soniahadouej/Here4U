package tn.g3.spring.entity;
import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Claim")
public class Claim implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private long idClaim;

	@Enumerated(EnumType.STRING)
	@Column(name="Type")
	private ClaimType categoryClaim;
	
	@Column(name="Description")
	private String descriptionClaim;

	@Temporal (TemporalType.DATE)
	@Column(name="Date")
	private Date dateClaim;

	@Enumerated(EnumType.STRING)
	@Column(name="Status")
	private ClaimStatus statusClaim;
	
	
	//////******************************************************************//////////
	
	@JsonIgnore
	@OneToOne(mappedBy="claim" )
	private Person person;
	
	
	public Claim(Long idClaim,ClaimType categoryClaim,String descriptionClaim,Date dateClaim,ClaimStatus statusClaim){
		this.idClaim=idClaim;this.categoryClaim=categoryClaim;this.descriptionClaim=descriptionClaim;this.dateClaim=dateClaim;this.statusClaim=statusClaim;
		
	}

	
	
	
	public Claim() {
		super();
	}
	public long getIdClaim() {
		return idClaim;
	}
	public void setIdClaim(long idClaim) {
		this.idClaim = idClaim;
	}
	public ClaimType getCategoryClaim() {
		return categoryClaim;
	}
	public void setCategoryClaim(ClaimType categoryClaim) {
		this.categoryClaim = categoryClaim;
	}
	public String getDescriptionClaim() {
		return descriptionClaim;
	}
	public void setDescriptionClaim(String descriptionClaim) {
		this.descriptionClaim = descriptionClaim;
	}
	public Date getDateClaim() {
		return dateClaim;
	}
	public void setDateClaim(Date dateClaim) {
		this.dateClaim = dateClaim;
	}
	public ClaimStatus getStatusClaim() {
		return statusClaim;
	}
	public void setStatusClaim(ClaimStatus statusClaim) {
		this.statusClaim = statusClaim;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Claim(long idClaim, ClaimType categoryClaim, String descriptionClaim, Date dateClaim,
			ClaimStatus statusClaim, Person person) {
		super();
		this.idClaim = idClaim;
		this.categoryClaim = categoryClaim;
		this.descriptionClaim = descriptionClaim;
		this.dateClaim = dateClaim;
		this.statusClaim = statusClaim;
		this.person = person;
	}




	
	
	
}