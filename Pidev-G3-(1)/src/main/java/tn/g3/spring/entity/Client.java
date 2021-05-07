package tn.g3.spring.entity;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

import java.util.Date;
import java.util.Set;
import javax.persistence.DiscriminatorValue;

@Entity
@DiscriminatorValue("Client")
public class Client extends Person implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@Enumerated(EnumType.STRING)
	@Column(name="CivilStatus")
	private CivilStatus category;
	
	@Column(name="Job")
	private String job;
	
	@Column(name="Warning")
	private Integer warning;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="client")
	private Set<Contract> contracts;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="client")
	private Set<Sinistre> sinistres;

	public CivilStatus getCategory() {
		return category;
	}

	public void setCategory(CivilStatus category) {
		this.category = category;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Integer getWarning() {
		return warning;
	}

	public void setWarning(Integer warning) {
		this.warning = warning;
	}

	public Set<Contract> getContracts() {
		return contracts;
	}

	public void setContracts(Set<Contract> contracts) {
		this.contracts = contracts;
	}

	public Set<Sinistre> getSinistres() {
		return sinistres;
	}

	public void setSinistres(Set<Sinistre> sinistres) {
		this.sinistres = sinistres;
	}

	public Client(Long idPerson, Integer cin, String personType, String firstName, String lastName, Integer phoneNumber,
			Integer age, PersonSex sex, Adress adress, String password, String email, Float salary, Date startDate,
			CivilStatus category, String job, Integer warning, Set<Contract> contracts, Set<Sinistre> sinistres) {
		super(idPerson, cin, personType, firstName, lastName, phoneNumber, age, sex, adress, password, email, salary,
				startDate);
		this.category = category;
		this.job = job;
		this.warning = warning;
		this.contracts = contracts;
		this.sinistres = sinistres;
	}

	public Client(Long idPerson, Integer cin, String personType, String firstName, String lastName, Integer phoneNumber,
			Integer age, PersonSex sex, Adress adress, String password, String email, Float salary, Date startDate) {
		super(idPerson, cin, personType, firstName, lastName, phoneNumber, age, sex, adress, password, email, salary,
				startDate);
	}

	
	}


	

