package tn.g3.spring.entity;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class ContractOfferPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name="IdContract")
	private long idContract;
	
	
	@Column(name="IdOffer")
	private long idOffer;
	
	@Temporal (TemporalType.DATE)
	@Column(name="StartOffer")
	private Date startOffer;

	public long getIdContract() {
		return idContract;
	}

	public void setIdContract(long idContract) {
		this.idContract = idContract;
	}

	public long getIdOffer() {
		return idOffer;
	}

	public void setIdOffer(long idOffer) {
		this.idOffer = idOffer;
	}

	public Date getStartOffer() {
		return startOffer;
	}

	public void setStartOffer(Date startOffer) {
		this.startOffer = startOffer;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idContract ^ (idContract >>> 32));
		result = prime * result + (int) (idOffer ^ (idOffer >>> 32));
		result = prime * result + ((startOffer == null) ? 0 : startOffer.hashCode());
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
		ContractOfferPK other = (ContractOfferPK) obj;
		if (idContract != other.idContract)
			return false;
		if (idOffer != other.idOffer)
			return false;
		if (startOffer == null) {
			if (other.startOffer != null)
				return false;
		} else if (!startOffer.equals(other.startOffer))
			return false;
		return true;
	}

	public ContractOfferPK() {
		super();
	}

	public ContractOfferPK(long idContract, long idOffer, Date startOffer) {
		super();
		this.idContract = idContract;
		this.idOffer = idOffer;
		this.startOffer = startOffer;
	}

}
