package tn.g3.spring.entity;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.persistence.DiscriminatorValue;

@Entity
@DiscriminatorValue("Client")
public class Client extends Person implements Serializable {
	
	
	
	@Column(name="CIN", unique=true)
	private Integer cin;
	
	@Enumerated(EnumType.STRING)
	@Column(name="CivilStatus")
	private CivilStatus category;
	
	@Column(name="Job")
	private String job;
	
	@Column(name="Salary_TND")
	private Float salary;
	
	@Column(name="Login")
	private String login;
	
	@Column(name="Password")
	private String password;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="Warning")
	private Integer nbWarning;
	
	@Temporal (TemporalType.DATE)
	@Column(name="Start")
	private Date startDate;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="client")
	private Set<Contract> contracts;

	public Client(){}
	 
	public Client(long idPerson, List<Sinistre> sinistreList, String personType, String firstName, String lastName,
			Integer phoneNumber, Integer age, PersonSex sex, String password, Role role, Integer cin,
			CivilStatus category, String job, Float salary, String login, String password2, String email,
			Integer nbWarning, Date startDate, Set<Contract> contracts) {
		super(idPerson, sinistreList, personType, firstName, lastName, phoneNumber, age, sex, password, role);
		this.cin = cin;
		this.category = category;
		this.job = job;
		this.salary = salary;
		this.login = login;
		password = password2;
		this.email = email;
		this.nbWarning = nbWarning;
		this.startDate = startDate;
		this.contracts = contracts;
	}

	
	public Integer getCin() {
		return cin;
	}
	public void setCin(Integer cin) {
		this.cin = cin;
	}
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
	public Float getSalary() {
		return salary;
	}
	public void setSalary(Float salary) {
		this.salary = salary;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getNbWarning() {
		return nbWarning;
	}
	public void setNbWarning(Integer nbWarning) {
		this.nbWarning = nbWarning;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Set<Contract> getContracts() {
		return contracts;
	}
	public void setContracts(Set<Contract> contracts) {
		this.contracts = contracts;
	}
	
}
