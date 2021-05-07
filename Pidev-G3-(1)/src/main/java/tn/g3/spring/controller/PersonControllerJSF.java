package tn.g3.spring.controller;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage; 
import javax.faces.context.FacesContext;
import javax.persistence.Embedded;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import tn.g3.spring.entity.Person;
import tn.g3.spring.entity.PersonSex;
import tn.g3.spring.entity.Person.Adress;
import tn.g3.spring.service.IPersonService;
@Scope(value = "session")
@Controller(value = "personControllerJSF") // Name of the bean in Spring IoC
@ELBeanName(value = "personControllerJSF") // Name of the bean used by JSF
@Join(path = "/", to = "/AdminTemplate/login.jsf")
public class PersonControllerJSF {

	@Autowired
	IPersonService personService;

	private Person person;
	private Boolean loggedIn;
	private Person authenticatedPerson;
	private Long idToBeUpdated;
	
	private Long idPerson;
	private Integer cin; 
	private String personType; 
	private String firstName;
	private String lastName;
	private Integer phoneNumber;
	private Integer age; 
	private PersonSex sex;
	@Embedded
	private Adress adress;
	
	private String password;
	private String email; 
	private Float salary;
	private Date startDate;
	
	public Person getAuthenticatedUser() {
		return authenticatedPerson;
	}
	public void setAuthenticatedPerson(Person authenticatedPerson) {
		this.authenticatedPerson = authenticatedPerson;
	}
	public IPersonService getPersonService() {
		return personService;
	}
	public void setPersonService(IPersonService personService) {
		this.personService = personService;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Boolean getLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(Boolean loggedIn) {

		this.loggedIn = loggedIn;
	}
	public long getidToBeUpdated() {
		return idToBeUpdated;
	}
	public void setidToBeUpdated(long employeIdToBeUpdated) {
		this.idToBeUpdated = employeIdToBeUpdated;
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
	public Adress getAdress() {
		return adress;
	}
	public void setAdress(Adress adress) {
		this.adress = adress;
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
	
	
	
	public String doLogin() {
		String navigateTo = "null";
		Person authenticatedPerson=personService.authenticate(email, password);
		if (authenticatedPerson != null && ( authenticatedPerson).getPersonType() == "Agent") {	

			navigateTo = "/AdminTemplate/home.xhtml?faces-redirect=true";
			loggedIn = true; }
		else {
			FacesMessage facesMessage =

					new FacesMessage("Login Failed: please check your username/password and try again.");

			FacesContext.getCurrentInstance().addMessage("form:btn",facesMessage);
		}
		return navigateTo;
	}

	public String doLogout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login.xhtml?faces-redirect=true";

	}

	public void addEmploye() {
		personService.addPerson(new Person(cin, personType, firstName, lastName, phoneNumber,
				age, sex, adress, password, email, salary, startDate));
	}


	private List<Person> agents; // ajouter le getter et le setter

	public List<Person> getAgents() {
	agents = personService.getAllAgents();
	return agents;
	}
	
	public void deletePerson(String id)
	{
		
	personService.deletePerson(id);
	}
	
	public void displayPerson(Person person)
	{
		this.setCin(person.getCin());
		this.setPersonType(person.getPersonType());
		this.setFirstName(person.getFirstName());
		this.setLastName(person.getLastName());
		this.setPhoneNumber(person.getPhoneNumber());
		this.setAge(person.getAge());
		this.setSex(person.getSex());
		this.setAdress(person.getAdress());
		this.setPassword(person.getPassword());
		this.setEmail(person.getEmail());
		this.setSalary(person.getSalary());
		this.setStartDate(person.getStartDate());
		this.setidToBeUpdated(person.getIdPerson());
	}
	
	public void updateEmploye()
	{ personService.updatePerson(new Person(idPerson, cin, personType, firstName, lastName, phoneNumber,
			age, sex, adress, password, email, salary, startDate)); }
}
