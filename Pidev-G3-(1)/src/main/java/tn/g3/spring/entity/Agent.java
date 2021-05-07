package tn.g3.spring.entity;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.DiscriminatorValue;

import java.util.Date;
import java.util.Set;

@Entity
@DiscriminatorValue("Agent")
public class Agent extends Person implements Serializable {
	 
	private static final long serialVersionUID = 1L;

	@Enumerated(EnumType.STRING)
	@Column(name="Grade")
	private GradeType typeGrade;
	
	@Column(name="Delay")
	private Integer delay;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="agent")
	private Set<Product> products;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="agent")
	private Set<Offer> offers;
	

	public GradeType getTypeGrade() {
		return typeGrade;
	}

	public void setTypeGrade(GradeType typeGrade) {
		this.typeGrade = typeGrade;
	}

	public Integer getDelay() {
		return delay;
	}

	public void setDelay(Integer delay) {
		this.delay = delay;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Set<Offer> getOffers() {
		return offers;
	}

	public void setOffers(Set<Offer> offers) {
		this.offers = offers;
	}

	public Agent(Long idPerson, Integer cin, String personType, String firstName, String lastName, Integer phoneNumber,
			Integer age, PersonSex sex, Adress adress, String password, String email, Float salary, Date startDate,
			GradeType typeGrade, Integer delay, Set<Product> products, Set<Offer> offers) {
		super(idPerson, cin, personType, firstName, lastName, phoneNumber, age, sex, adress, password, email, salary,
				startDate);
		this.typeGrade = typeGrade;
		this.delay = delay;
		this.products = products;
		this.offers = offers;
	}

	public Agent(Long idPerson, Integer cin, String personType, String firstName, String lastName, Integer phoneNumber,
			Integer age, PersonSex sex, Adress adress, String password, String email, Float salary, Date startDate) {
		super(idPerson, cin, personType, firstName, lastName, phoneNumber, age, sex, adress, password, email, salary,
				startDate);
	}




	
}
