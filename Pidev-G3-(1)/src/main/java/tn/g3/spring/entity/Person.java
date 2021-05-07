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

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Type")
@Table(name="Person")
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column(name="IdPerson")
	protected Long idPerson;
	
	@Column(name="CIN", unique=true)
	private Integer cin;
	
	@Column(name="Type",insertable=false,updatable=false )
	protected String personType;

	@Column(name="FirstName")
	protected String firstName;
	
	@Column(name="LastName")
	protected String lastName;
	
	@Column(name="Phone")
	protected Integer phoneNumber;
	
	@Column(name="Age")
	protected Integer age;

	@Enumerated(EnumType.STRING)
	@Column(name="Sex")
	protected PersonSex sex;
	
	@Embedded
	@Column(name="Adress")
	protected Adress adress;
	
	@Column(name="Password")
	private String password;
	
	@Column(name="Email")
	private String email;

	@Column(name="Salary_TND")
	private Float salary;
	
	@Temporal (TemporalType.DATE)
	@Column(name="Start")
	private Date startDate;
	
	@Embeddable
	public class Adress {

		protected String region;
		protected String city;
		protected String street;
		protected Integer postalCode;
		
		public String getRegion() {
			return region;
		}
		public void setRegion(String region) {
			this.region = region;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		
		public Integer getPostalCode() {
			return postalCode;
		}
		public void setPostalCode(Integer postalCode) {
			this.postalCode = postalCode;
		}
		public String getStreet() {
			return street;
		}
		public void setStreet(String street) {
			this.street = street;
		}
	}
	


	public Long getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(Long idPerson) {
		this.idPerson = idPerson;
	}

	public Integer getCin() {
		return cin;
	}

	public void setCin(Integer cin) {
		this.cin = cin;
	}

	public String getPersonType() {
		return personType;
	}

	public void setPersonType(String personType) {
		this.personType = personType;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public PersonSex getSex() {
		return sex;
	}

	public void setSex(PersonSex sex) {
		this.sex = sex;
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

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Person(Long idPerson, Integer cin, String personType, String firstName, String lastName, Integer phoneNumber,
			Integer age, PersonSex sex, Adress adress, String password, String email, Float salary, Date startDate) {
		super();
		this.idPerson = idPerson;
		this.cin = cin;
		this.personType = personType;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.age = age;
		this.sex = sex;
		this.adress = adress;
		this.password = password;
		this.email = email;
		this.salary = salary;
		this.startDate = startDate;
	}


	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public Person(Integer cin, String personType, String firstName, String lastName, Integer phoneNumber, Integer age,
			PersonSex sex, Adress adress, String password, String email, Float salary, Date startDate) {
		super();
		this.cin = cin;
		this.personType = personType;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.age = age;
		this.sex = sex;
		this.adress = adress;
		this.password = password;
		this.email = email;
		this.salary = salary;
		this.startDate = startDate;
	}

	

	
	
}
	
	