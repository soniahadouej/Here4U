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


import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Type")
@Table(name="Person")
public abstract class Person implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	protected Long idPerson;
	
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

	@Embeddable
	protected class Adress {

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
	
	public Person(){}
	public Person(Long idPerson,String personType,String firstName,String lastName,Integer phoneNumber,Integer age,PersonSex sex, Adress adress){
		this.idPerson=idPerson;this.personType=personType;this.firstName=firstName;this.lastName=lastName;this.phoneNumber=phoneNumber;this.age=age;this.sex=sex;this.adress=adress;
		
	}
	public Person(long idPerson, String personType, String firstName, String lastName, Integer age, PersonSex sex) {
		super();
		this.idPerson = idPerson;
		this.personType = personType;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.sex = sex;
	}
	public Long getIdPerson() {
		return idPerson;
	}
	public void setIdPerson(Long idPerson) {
		this.idPerson = idPerson;
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
	public Adress getAdress() {
		return adress;
	}
	public void setAdress(Adress adress) {
		this.adress = adress;
	}
}
