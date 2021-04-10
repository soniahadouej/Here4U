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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name="Date")
	private Date dateClaim;

	
	@Column(name = "status")
	private boolean statusClaim;

	
	
	
	
	public Claim(){}
	public Claim(Long idClaim,ClaimType categoryClaim,String descriptionClaim,Date dateClaim,boolean statusClaim){
		this.idClaim=idClaim;
		this.categoryClaim=categoryClaim;
		this.descriptionClaim=descriptionClaim;
		this.dateClaim=dateClaim;
		this.statusClaim=statusClaim;
	}
	public Claim(ClaimType categoryClaim,String descriptionClaim,Date dateClaim, boolean statusClaim){
		
		this.categoryClaim=categoryClaim;
		this.descriptionClaim=descriptionClaim;
		this.dateClaim=dateClaim;
		this.statusClaim=statusClaim;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public boolean isStatusClaim() {
		return statusClaim;
	}
	public void setStatusClaim(boolean isStatusClaim) {
		this.statusClaim = isStatusClaim;
	}
	@Override
	public String toString() {
		return "Claim [idClaim=" + idClaim + ", categoryClaim=" + categoryClaim + ", descriptionClaim="
				+ descriptionClaim + ", dateClaim=" + dateClaim + ", statusClaim=" + statusClaim + "]";
	}
	
	
	
	

}