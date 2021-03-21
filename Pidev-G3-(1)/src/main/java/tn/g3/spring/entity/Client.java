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
	public Client(Long idPerson,String personType,String firstName,String lastName,Integer phoneNumber,Integer age,PersonSex sex, Adress adress,Integer cin,CivilStatus category,String job,Float salary,String login,String password,String email,Integer nbWarning,Date startDate){
		super(idPerson,personType,firstName,lastName,phoneNumber,age,sex,adress);
		this.cin=cin;this.category=category;this.job=job;this.salary=salary;this.login=login;this.password=password;this.email=email;this.nbWarning=nbWarning;this.startDate=startDate;
		
	}
	
}
