package tn.g3.spring.controller;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage; 
import javax.faces.context.FacesContext;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import tn.g3.spring.entity.Person;
import tn.g3.spring.entity.Contract;
import tn.g3.spring.entity.ContractOffer;
import tn.g3.spring.entity.ContractOfferPK;
import tn.g3.spring.entity.Offer;
import tn.g3.spring.entity.OfferStatus;
import tn.g3.spring.entity.OfferType;
import tn.g3.spring.entity.PersonSex;
import tn.g3.spring.entity.Person.Adress;
import tn.g3.spring.service.IContractOfferService;
import tn.g3.spring.service.IOfferService;
import tn.g3.spring.service.IOfferSimulationService;
import tn.g3.spring.service.IPersonService;


@Scope(value = "session")
@Controller(value = "userController") // Name of the bean in Spring IoC
@ELBeanName(value = "userController") // Name of the bean used by JSF
@Join(path = "/", to = "/AdminTemplate/login.jsf")
public class UserController {

	@Autowired
	IPersonService personService;

	@Autowired
	IOfferService offerService;

	@Autowired
	IOfferSimulationService offerSimulationService;
	
	@Autowired
	IContractOfferService contractOfferService;




	/*---------------------- Persons ------------------*/

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

	public Person getAuthenticatedPerson() {
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
	public Long getIdToBeUpdated() {
		return idToBeUpdated;
	}
	public void setIdToBeUpdated(Long idToBeUpdated) {
		this.idToBeUpdated = idToBeUpdated;
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

			navigateTo = "/FirstAdmin.xhtml?faces-redirect=true";
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


	private List<Person> agents; 

	public List<Person> getAgents() {
		agents = personService.getAllAgents();
		return agents;
	}

	public void setAgents(List<Person> agents) {
		this.agents = agents;
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
		this.setIdToBeUpdated(person.getIdPerson());
	}

	public void updateEmploye()
	{ personService.updatePerson(new Person(idPerson, cin, personType, firstName, lastName, phoneNumber,
			age, sex, adress, password, email, salary, startDate)); }


	/*--------------------- Offers ---------------------------------------------------------*/

	private Offer offer;
	private long idOffer; 
	private OfferType typeOffer;
	private String descriptionOffer;
	private String nameOffer;
	private String codeOffer;
	private Integer maxRedemption;

	public long getIdOffer() {
		return idOffer;
	}
	public void setIdOffer(long idOffer) {
		this.idOffer = idOffer;
	}
	public OfferType getTypeOffer() {
		return typeOffer;
	}
	public void setTypeOffer(OfferType typeOffer) {
		this.typeOffer = typeOffer;
	}
	public String getDescriptionOffer() {
		return descriptionOffer;
	}
	public void setDescriptionOffer(String descriptionOffer) {
		this.descriptionOffer = descriptionOffer;
	}
	public String getNameOffer() {
		return nameOffer;
	}
	public void setNameOffer(String nameOffer) {
		this.nameOffer = nameOffer;
	}
	public String getCodeOffer() {
		return codeOffer;
	}
	public void setCodeOffer(String codeOffer) {
		this.codeOffer = codeOffer;
	}
	public Integer getMaxRedemption() {
		return maxRedemption;
	}
	public void setMaxRedemption(Integer maxRedemption) {
		this.maxRedemption = maxRedemption;
	}


	public Offer getOffer() {
		return offer;
	}
	public void setOffer(Offer offer) {
		this.offer = offer;
	}
	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}
	public void addOffer() {
		offerService.addOffer(new Offer(typeOffer, descriptionOffer, nameOffer, codeOffer, maxRedemption));
	}


	private List<Offer> offers; 

	public List<Offer> getOffers() {
		offers = offerService.retrieveAllOffers();
		return offers;
	}

	public Offer retrieveOffer(String idOffer) {
		offer = offerService.retrieveOffer(idOffer);
		return offer;
	} 

	public Offer retrieveOfferByName(String nameOffer) {
		offer=offerService.retrieveOfferByName(nameOffer);
		return offer;
	} 

	public Offer retrieveOfferByCode(String codeOffer) {
		offer=offerService.retrieveOfferByCode(codeOffer);
		return offer;
	} 

	public List<Offer> retrieveOffersByMaxRedemption(Integer maxRedemption) {
		offers= offerService.retrieveOffersByMaxRedemption(maxRedemption);
		return offers;
	} 

	public void deleteOffer(String id)
	{

		offerService.deleteOffer(id);
	}

	public void displayOffer(Offer offer)
	{
		this.setTypeOffer(offer.getTypeOffer());
		this.setDescriptionOffer(offer.getDescriptionOffer());
		this.setNameOffer(offer.getNameOffer());
		this.setCodeOffer(offer.getCodeOffer());
		this.setMaxRedemption(offer.getMaxRedemption());
		this.setIdToBeUpdated(offer.getIdOffer());
	}

	public void updateOffer()
	{ offerService.updateOffer(new Offer(idOffer,typeOffer, descriptionOffer, nameOffer, codeOffer, maxRedemption)); }

	public OfferType[] getOfferTypes() { return OfferType.values(); }
	
	
	
	
	
	/*--------------------- ContractOffers---------------------------------------------------------*/
	
	private ContractOffer contractOffer;
	@EmbeddedId
	private ContractOfferPK contractOfferPK;
	private Contract contract; 
	private Date expireOffer;
	private OfferStatus statusOffer;
	public OfferStatus[] getOfferStates() { return OfferStatus.values(); }
	
	private List<Contract> contracts;

	public ContractOffer getContractOffer() {
		return contractOffer;
	}
	public void setContractOffer(ContractOffer contractOffer) {
		this.contractOffer = contractOffer;
	}
	public ContractOfferPK getContractOfferPK() {
		return contractOfferPK;
	}
	public void setContractOfferPK(ContractOfferPK contractOfferPK) {
		this.contractOfferPK = contractOfferPK;
	}
	public Contract getContract() {
		return contract;
	}
	public void setContract(Contract contract) {
		this.contract = contract;
	}
	public Date getExpireOffer() {
		return expireOffer;
	}
	public void setExpireOffer(Date expireOffer) {
		this.expireOffer = expireOffer;
	}
	public OfferStatus getStatusOffer() {
		return statusOffer;
	}
	public void setStatusOffer(OfferStatus statusOffer) {
		this.statusOffer = statusOffer;
	}
	
	public List<Contract> getContracts() {
		return contracts;
	}
	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}
	public List<Contract> retrieveContractsByOfferStatus(OfferStatus statusOffer) {
		contracts = contractOfferService.retrieveContractsByOfferStatus(statusOffer);
		return contracts;
	} 
	
	public List<Offer> findAllOffersByContract(Long idContract) {
		offers = contractOfferService.findAllOffersByContract(idContract);
		return offers;
	} 
	
	public List<Contract> findAllContractsByOffer(Long idOffer) {
		contracts = contractOfferService.findAllContractsByOffer(idOffer);
		return contracts;
	} 
	
	public void addContractOffer(Long idContract, Long idOffer, Date startOffer, Date expireOffer, OfferStatus statusOffer) {
		contractOfferService.addContractOffer(idContract, idOffer, startOffer, expireOffer, statusOffer);

	}
	
	public List<Offer> retrieveOffersByStartingDate(Date startOffer) {
		offers = contractOfferService.retrieveOffersByStartingDate(startOffer);
		return offers;
	} 
	
	public List<Offer> retrieveOffersByExpiringDate(Date expireOffer) {
		offers = contractOfferService.retrieveOffersByExpiringDate(expireOffer);
		return offers;
	} 
	
	public List<Contract> getContractsByOfferDate(Date startOffer,Date expireOffer) {
		contracts = contractOfferService.getContractsByOfferDate(startOffer,expireOffer);
		return contracts;
	} 
	
	public int countActiveOffers() {

		return contractOfferService.countActiveOffers();
	}
	
	public int countStoppedOffers() {

		return contractOfferService.countStoppedOffers();
	}
	
	public String activateContactOffer(ContractOfferPK contractOfferPK) {

		return contractOfferService.activateContactOffer(contractOfferPK);
	}
	
	public String desactivateContactOffer(ContractOfferPK contractOfferPK) {

		return contractOfferService.desactivateContractOffer(contractOfferPK);
	}
	
	public List<Offer> showOffersHistory() {
		offers = (List<Offer>) contractOfferService.ShowOffersHistory();
		return offers;
	} 
	
	/*--------------------- Simulations ---------------------------------------------------------*/

	
	public float calculateGift (Long idContract ) throws ParseException {

		return offerSimulationService.calculateGift(idContract);
	}

	public float calculateDiscount (Long idContract ) {

		return offerSimulationService.calculateDiscount(idContract);
	}

	/*public float calculateLoyalty (Long idContract ) {

	return offerSimulationService.calculateLoyalty(idContract);
}*/

	public double calculateScore (Long idContract ) {

		return offerSimulationService.calculateScore(idContract);
	}

}