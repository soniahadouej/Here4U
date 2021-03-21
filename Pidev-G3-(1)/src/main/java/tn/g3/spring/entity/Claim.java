package tn.g3.spring.entity;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	
	
	public Claim(){}
	public Claim(Long idClaim,ClaimType categoryClaim,String descriptionClaim,Date dateClaim,ClaimStatus statusClaim){
		this.idClaim=idClaim;this.categoryClaim=categoryClaim;this.descriptionClaim=descriptionClaim;this.dateClaim=dateClaim;this.statusClaim=statusClaim;
		
	}

}