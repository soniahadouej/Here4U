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
@Table(name="Userr")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private long iduser;
	
	@Column(name="FirstName")
	private String firstName;
	
	@Column(name="LastName")
	private String lastName;
	
	@Column(name="Phone")
	private Integer phoneNumber;
	
	@Column(name="Age")
	private Integer age;

	@Column(name="Email")
	private String email;

	@Column(name="Password")
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(name="Role")
	private Role role;
	public User(){}
	public User(String firstName,String lastName,Integer phoneNumber,Integer age,String Email,String Password ,Role role ){
		this.firstName=firstName;this.lastName=lastName;this.phoneNumber=phoneNumber;this.age=age;this.email=Email ;this.password=Password;this.role=role;
}
	public User(int iduser,String firstName,String lastName,Integer phoneNumber,Integer age ,String Email,String Password,Role role ){
		this.iduser=iduser;this.firstName=firstName;this.lastName=lastName;this.phoneNumber=phoneNumber;this.age=age;this.email=Email ;this.password=Password;this.role=role;
}
	public long getiduser(){
		return iduser;
	}
	public void setidperson(long iduser){
		this.iduser= iduser;
	}
	public String getfirstname(){
		return firstName;
	}
	public void setfirstname(String firstname){
		this.firstName= firstname;
	}
	public String getlastname(){
		return lastName;
	}
	public void setlastname(String lastname){
		this.lastName= lastname;
	}
	public Integer getphoneNumber(){
		return phoneNumber;
	}
	public void setphoneNumber(Integer phoneNumber){
		this.phoneNumber= phoneNumber;
	}
	

	public String getemail(){
		return email;
	}
	public void setemail(String EMAIL){
		this.email= EMAIL;
	}
	public String getpassword(){
		return password;
	}
	public void setpassword(String PWD){
		this.password= PWD;
	}
	public Integer getAge(){
		return age;
	}
	public void setage(Integer age){
		this.age= age;
	}
	public Role getRole(){
		return role;
	}
	public void setRole(Role role){
		this.role= role;
	}
}
