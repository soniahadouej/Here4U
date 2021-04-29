package tn.g3.spring.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Type")
@Table(name = "Persons")
public abstract class Person implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdPerson")
	protected long idPerson;

	/* ******************SINISTRE*********** */
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, mappedBy = "person")
	private List<Sinistre> SinistreList;
	

	
	/* ****************************CONTRAT****************************** */
	@OneToMany(mappedBy="person",cascade = CascadeType.ALL , fetch= FetchType.EAGER )
	private Set<Contract> contracts;
	
	
	
	/* **************************CLAIM ******************************* */
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL , fetch= FetchType.EAGER )
	@JoinColumn(name = "idClaim") //,referencedColumnName="idClaim")
	private Claim claim;

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(long idPerson) {
		this.idPerson = idPerson;
	}

	public List<Sinistre> getSinistreList() {
		return SinistreList;
	}

	public void setSinistreList(List<Sinistre> sinistreList) {
		SinistreList = sinistreList;
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

	/*public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}
*/
	@Column(name = "Type", insertable = false, updatable = false)
	protected String personType;

	@Column(name = "FirstName")
	protected String firstName;

	@Column(name = "LastName")
	protected String lastName;

	@Column(name = "Phone")
	protected Integer phoneNumber;

	@Column(name = "Age")
	protected Integer age;

	@Enumerated(EnumType.STRING)
	@Column(name = "Sex")
	protected PersonSex sex;
	
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Role role;
 
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Claim getClaim() {
		return claim;
	}

	public void setClaim(Claim claim) {
		this.claim = claim;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String email;

public Set<Contract> getContracts() {
		return contracts;
	}

	public void setContracts(Set<Contract> contracts) {
		this.contracts = contracts;
	}

	/*@Embedded
	@Column(name = "Adress")
	protected Adress adress;
*/
	/*@Embeddable
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

		public Adress(String region, String city, String street, Integer postalCode) {
			super();
			this.region = region;
			this.city = city;
			this.street = street;
			this.postalCode = postalCode;
		}

		public Adress() {
	
		}
		
	}
*/
	public Person(long idPerson, List<Sinistre> sinistreList, String personType, String firstName, String lastName,
			Integer phoneNumber, Integer age, PersonSex sex/*, Adress adress*/, String password, Role role) {
		super();
		this.idPerson = idPerson;
		SinistreList = sinistreList;
		this.personType = personType;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.age = age;
		this.sex = sex;
		//this.adress = adress;
		this.password = password;
		this.role = role;
		
	}


	public Person() {
	}

	public Person(Long idPerson, String personType, String firstName, String lastName, Integer phoneNumber, Integer age,
			PersonSex sex/*, Adress adress*/, String password, Role role) {
		this.idPerson = idPerson;
		this.personType = personType;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.age = age;
		this.sex = sex;
		//this.adress = adress;
		this.password = password;
		this.role = role;

	}
	
	
	
}
