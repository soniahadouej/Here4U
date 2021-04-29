package tn.g3.spring.entity;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.DiscriminatorValue;
import java.util.Date;
import java.util.Set;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@DiscriminatorValue("Agent")
public class Agent extends Person implements Serializable {
	
	@Column(name="CIN", unique=true)
	private Integer cin;
	
	@Enumerated(EnumType.STRING)
	@Column(name="Grade")
	private GradeType typeGrade;
	
	@Temporal (TemporalType.DATE)
	@Column(name="Start")
	private Date hiringDate;
	
	@Column(name="Salary_TND")
	private Float salary;
	
	@Column(name="Delay")
	private Integer delay;
	
	@Column(name="Warning")
	private Integer warning;
	
	@Column(name="Login")
	private String login;
	
	@Column(name="Password")
	private String password;
	
	@Column(name="Email")
	private String email;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="agent")
	private Set<Product> products;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="agent")
	private Set<Offer> offers;
	
	public Agent(){}
	
	
}
