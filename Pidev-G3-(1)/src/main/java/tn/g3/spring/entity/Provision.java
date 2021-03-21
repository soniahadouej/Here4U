package tn.g3.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Provision")
public class Provision  implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="IdProvision")
	private Long idprovision ;

	@Column(name="Description")
	private String description;

	@Enumerated(EnumType.STRING)
	@Column(name="Type_Provision")
	private TypeProvision typeprovision;

	@Column(name="Price")
	private float price;

	 

	public Long getIdprovision() {
		return idprovision;
	}

	public void setIdprovision(Long idprovision) {
		this.idprovision = idprovision;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TypeProvision getTypeprovision() {
		return typeprovision;
	}

	public void setTypeprovision(TypeProvision typeprovision) {
		this.typeprovision = typeprovision;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((idprovision == null) ? 0 : idprovision.hashCode());
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + ((typeprovision == null) ? 0 : typeprovision.hashCode());
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
		Provision other = (Provision) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (idprovision == null) {
			if (other.idprovision != null)
				return false;
		} else if (!idprovision.equals(other.idprovision))
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (typeprovision != other.typeprovision)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Provision [idprovision=" + idprovision + ", description=" + description + ", typeprovision="
				+ typeprovision + ", price=" + price + "]";
	}

	public Provision(Long idprovision, String description, TypeProvision typeprovision, float price) {
		this.idprovision = idprovision;
		this.description = description;
		this.typeprovision = typeprovision;
		this.price = price;
	}

	public Provision() {}

	public Provision(String description, TypeProvision typeprovision, float price) {
		this.description = description;
		this.typeprovision = typeprovision;
		this.price = price;
	}
	

}
