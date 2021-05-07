package tn.g3.spring.entity;

import java.io.File;
import javax.persistence.PreRemove;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PreRemove;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="Sinistre")
@DynamicUpdate
public class Sinistre implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="IdSinistre")
	private Long idSinistre ;
	
    @Enumerated(EnumType.STRING)
    @Column(name="TypeSinistre")
	SinisterType typeSinistre;
     
	private String description;
	@Temporal(TemporalType.DATE)
    @Column(name="DateOccurence")
	private Date dateOccurence;
	
	@Enumerated(EnumType.STRING)
    @Column(name="Status")
	SinisterStatus status;
	
	
	@Enumerated(EnumType.STRING)
    @Column(name="Motif")
	SinisterMotif motifStatus;
	
	private boolean actif;
	
	@Column(name="Documents" ,length = Integer.MAX_VALUE , nullable = true )
	private byte[] documents ;
	 
	@Column(name="Reglementation")
	private float reglemntation ;
	
	
	
	
	/* ************************ */

	 public boolean isActif() {
		return actif;
	}




	public void setActif(boolean actif) {
		this.actif = actif;
	}




	public float getReglemntation() {
		return reglemntation;
	}




	public void setReglemntation(float reglemntation) {
		this.reglemntation = reglemntation;
	}



	@ManyToOne//( cascade = CascadeType.ALL , fetch= FetchType.EAGER  )
//	 @JoinColumn(name = "idPerson" , referencedColumnName = "IdPerson")
	 @JsonIgnore
	 private Person person;
	 
	 
		@PreRemove
		private void preRemove() {
			setPerson(null);
		}
	
	 


	public Person getPerson() {
		return person;
	}



	public void setPerson(Person person) {
		this.person = person;
	}


	public Long getIdSinistre() {
		return idSinistre;
	}



	public void setIdSinistre(Long idSinistre) {
		this.idSinistre = idSinistre;
	}



	public SinisterType getTypeSinistre() {
		return typeSinistre;
	}



	public void setTypeSinistre(SinisterType typeSinistre) {
		this.typeSinistre = typeSinistre;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Date getDateOccurence() {
		return dateOccurence;
	}



	public void setDateOccurence(Date dateOccurence) {
		this.dateOccurence = dateOccurence;
	}



	public SinisterStatus getStatus() {
		return status;
	}



	public void setStatus(SinisterStatus status) {
		this.status = status;
	}



	public SinisterMotif getMotifStatus() {
		return motifStatus;
	}



	public void setMotifStatus(SinisterMotif motifStatus) {
		this.motifStatus = motifStatus;
	}



 



	public byte[] getDocuments() {
		return documents;
	}


	public void setDocuments(byte[] documents) {
		this.documents = documents;
	}


	@Override
	public String toString() {
		return "Sinistre [idSinistre=" + idSinistre + ", typeSinistre=" + typeSinistre + ", description=" + description
				+ ", dateOccurence=" + dateOccurence + ", status=" + status + ", motifStatus=" + motifStatus
				+ ", documents=" + documents + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOccurence == null) ? 0 : dateOccurence.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((documents == null) ? 0 : documents.hashCode());
		result = prime * result + ((idSinistre == null) ? 0 : idSinistre.hashCode());
		result = prime * result + ((motifStatus == null) ? 0 : motifStatus.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((typeSinistre == null) ? 0 : typeSinistre.hashCode());
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
		Sinistre other = (Sinistre) obj;
		if (dateOccurence == null) {
			if (other.dateOccurence != null)
				return false;
		} else if (!dateOccurence.equals(other.dateOccurence))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (documents == null) {
			if (other.documents != null)
				return false;
		} else if (!documents.equals(other.documents))
			return false;
		if (idSinistre == null) {
			if (other.idSinistre != null)
				return false;
		} else if (!idSinistre.equals(other.idSinistre))
			return false;
		if (motifStatus != other.motifStatus)
			return false;
		if (status != other.status)
			return false;
		if (typeSinistre != other.typeSinistre)
			return false;
		return true;
	}



	public Sinistre() {
		super();
	}



	public Sinistre(SinisterType typeSinistre, String description, Date dateOccurence, SinisterStatus status,
			byte[] documents) {
		super();
		this.typeSinistre = typeSinistre;
		this.description = description;
		this.dateOccurence = dateOccurence;
		this.status = status;
		this.documents = documents;
	}



	public Sinistre(SinisterType typeSinistre, String description, Date dateOccurence, SinisterStatus status,
			SinisterMotif motifStatus,  byte[] documents) {
		super();
		this.typeSinistre = typeSinistre;
		this.description = description;
		this.dateOccurence = dateOccurence;
		this.status = status;
		this.motifStatus = motifStatus;
		this.documents = documents;
	}



	public Sinistre(Long idSinistre, SinisterType typeSinistre, String description, Date dateOccurence,
			SinisterStatus status, SinisterMotif motifStatus,  byte[] documents) {
		super();
		this.idSinistre = idSinistre;
		this.typeSinistre = typeSinistre;
		this.description = description;
		this.dateOccurence = dateOccurence;
		this.status = status;
		this.motifStatus = motifStatus;
		this.documents = documents;
	}



	public Sinistre(SinisterType typeSinistre, String description, Date dateOccurence, SinisterStatus status,
			SinisterMotif motifStatus,  byte[] documents, Person person) {
		super();
		this.typeSinistre = typeSinistre;
		this.description = description;
		this.dateOccurence = dateOccurence;
		this.status = status;
		this.motifStatus = motifStatus;
		this.documents = documents;
		this.person = person;
	}

	
	public Sinistre(SinisterType typeSinistre, String description, Date dateOccurence, SinisterStatus status,
			  byte[] documents, Person person) {
		super();
		this.typeSinistre = typeSinistre;
		this.description = description;
		this.dateOccurence = dateOccurence;
		this.status = status;
		this.documents = documents;
		this.person = person;
	}

	public Sinistre(Long idSinistre,SinisterType typeSinistre, String description, Date dateOccurence, SinisterStatus status,
			  byte[] documents, Person person) {
		super();
		this.idSinistre = idSinistre;
		this.typeSinistre = typeSinistre;
		this.description = description;
		this.dateOccurence = dateOccurence;
		this.status = status;
		this.documents = documents;
		this.person = person;
	}
	


	public Sinistre(Long idSinistre, SinisterType typeSinistre, String description, Date dateOccurence,
			SinisterStatus status, SinisterMotif motifStatus,  byte[] documents, Person person) {
		super();
		this.idSinistre = idSinistre;
		this.typeSinistre = typeSinistre;
		this.description = description;
		this.dateOccurence = dateOccurence;
		this.status = status;
		this.motifStatus = motifStatus;
		this.documents = documents;
		this.person = person;
	}




	public Sinistre(Long idSinistre, SinisterType typeSinistre, String description, Date dateOccurence,
			SinisterStatus status, SinisterMotif motifStatus,byte[] documents, float reglemntation,
			Person person) {
		super();
		this.idSinistre = idSinistre;
		this.typeSinistre = typeSinistre;
		this.description = description;
		this.dateOccurence = dateOccurence;
		this.status = status;
		this.motifStatus = motifStatus;
		this.actif = actif;
		this.documents = documents;
		this.reglemntation = reglemntation;
		this.person = person;
	}
	
	public Sinistre(Long idSinistre, SinisterType typeSinistre, String description, Date dateOccurence,
			SinisterStatus status, SinisterMotif motifStatus, float reglemntation,
			Person person) {
		super();
		this.idSinistre = idSinistre;
		this.typeSinistre = typeSinistre;
		this.description = description;
		this.dateOccurence = dateOccurence;
		this.status = status;
		this.motifStatus = motifStatus;

		this.reglemntation = reglemntation;
		this.person = person;
	}
	
	
	


}
