package tn.g3.spring.controller;

import java.util.Date;


import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;

import tn.g3.spring.entity.Contract;
import tn.g3.spring.entity.ContractPaymentType;
import tn.g3.spring.entity.ContractStatus;
import tn.g3.spring.entity.ProductType;
import tn.g3.spring.entity.Role;
import tn.g3.spring.entity.User;
import tn.g3.spring.service.IContractService;
import tn.g3.spring.service.IUserService;

@Scope(value = "session")
@Controller(value = "userController") // Name of the bean in Spring IoC
@ELBeanName(value = "userController") // Name of the bean used by JSF
@Join(path = "/", to = "/home.jsf")
public class usercontrollerinp {
	@Autowired
	IUserService userService;
	@Autowired
	IContractService cs;

	private String login; private String password; private User user;
	private Boolean loggedIn;
	
	
	
	public String doLogin() {
		String navigateTo = "null";
		User u=userService.authenticate(login, password);
		if (u != null && u.getRole() == Role.AGENT) {
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
		public String getlogin(){
			return login;
		}
		public void setlogin(String login){
			this.login= login;
		}
		public String getpassword(){
			return password;
		}
		public void setpassword(String PWD){
			this.password= PWD;
		}
		public User getuser(){
			return user;
		}
		public void setuser(User user){
			this.user= user;
		}
		public boolean getloggedIn(){
			return loggedIn;
		}
		public void setloggedIn(boolean loggedIn){
			this.loggedIn= loggedIn;
		}
		private ProductType productType;
		private String descriptionContract;
		private Date startContract;
		private Date finishContract;
		private ContractStatus statusContract;
		private ContractPaymentType paymentType;
		private Float premiumContract;
		public void addContract() {
			cs.addContract(new Contract(productType, descriptionContract, startContract, finishContract, statusContract,paymentType,premiumContract));
			}
	
		public String getdescriptionContract(){
			return descriptionContract;
		}
		public void setdescriptionContract(String descriptionContract){
			this.descriptionContract= descriptionContract;
		}
		public ProductType getproductType(){
			return productType;
		}
		public void setproductType(ProductType productType){
			this.productType= productType;
		}
		public Date getstartContract(){
			return startContract;
		}
		public void setstartContract(Date startContract){
			this.startContract= startContract;
		}
		public Date getfinishContract(){
			return finishContract;
		}
		public void setfinishContract(Date finishContract){
			this.finishContract= finishContract;
		}
		public ContractStatus getstatusContract(){
			return statusContract;
		}
		public void setstatusContract(ContractStatus statusContract){
			this.statusContract= statusContract;
		}
		public ContractPaymentType getpaymentType(){
			return paymentType;
		}
		public void setpaymentType(ContractPaymentType paymentType){
			this.paymentType= paymentType;
		}
		public Float getpremiumContract(){
			return  premiumContract;
		}
		public void setpremiumContract(Float  premiumContract){
			this.premiumContract=  premiumContract;
		}
		/*private List<Contract> contracts;
		
		public List<Contract> getcontracts(){
			return  contracts;
		}
		public void setcontracts( List<Contract> contract){
			this.contracts=  contract;
		}*/

		/*public List<Contract> getContracts() {
		contracts= cs.retrieveAllContracts();
		return contracts;
		}*/
		public List<Contract> getContracts() {
			List<Contract> contracts = cs.retrieveAllContracts();
			return contracts;
		}
		public void removeContract( String id) { 
			cs.deleteContract(id);
			} 
		public long getContractIdToBeUpdated() {
			return contractIdToBeUpdated;
		}
		public void setContractIdToBeUpdated(long contractIdToBeUpdated) {
			this.contractIdToBeUpdated = contractIdToBeUpdated;
		}
		private long contractIdToBeUpdated;
		public void displayContract(Contract c)
		{
		this.setdescriptionContract(c.getdescriptionContract());
		this.setproductType(c.getproductType());
		this.setstartContract(c.getstartContract());
		this.setfinishContract(c.getfinishContract());
		this.setstatusContract(c.getstatusContract());
		this.setpaymentType(c.getpaymentType());
		this.setpremiumContract(c.getpremiumContract());
		this.setContractIdToBeUpdated(c.getidContract());
		}
		public Contract updateContract() {
			return cs.updateContract(new Contract(contractIdToBeUpdated,productType, descriptionContract, startContract, finishContract, statusContract,paymentType,premiumContract));
			}
		
		public ProductType[] getProductTypes() { return ProductType.values(); }
		
		public ContractStatus[] getContractStatuss() { return ContractStatus.values(); }
		
		private float capital; 
		private int ageclient;
		private int agem ;
		private float taux ;
		
		
		 public float calculPrimevief()  {
			 float k= 0 ;
				k =(float) cs.calculPrimefemme(capital, ageclient,agem,taux ) ; 
				return k ;
				
		 }
		  public float calculPrimevieh()  {
				float k = 0 ;
				k =(float) cs.calculPrimeHomme(capital, ageclient,agem,taux) ; 
				return k ;
	
}
		 
		public float getCapital() {
			return capital;
		}
		public void setCapital(float capital) {
			this.capital = capital;
		}
		public int getAgeclient() {
			return ageclient;
		}
		public void setAgeclient(int ageclient) {
			this.ageclient = ageclient;
		}
		public int getagem() {
			return agem;
		}
		public void setagem(int ageMax) {
			agem = ageMax;
		}
		public float getTaux() {
			return taux;
		}
		public void setTaux(float taux) {
			this.taux = taux;
		}
		public float getrente() {
			return rente;
		}
		public void setrente(float capital1) {
			this.rente = capital1;
		}
		public int getAgeclient1() {
			return ageclient1;
		}
		public void setAgeclient1(int ageclient1) {
			this.ageclient1 = ageclient1;
		}
		public int getAgem1() {
			return agem1;
		}
		public void setAgem1(int agem1) {
			this.agem1 = agem1;
		}
		public float getTaux1() {
			return taux1;
		}
		public void setTaux1(float taux1) {
			this.taux1 = taux1;
		}
		private float rente; 
		private int ageclient1;
		private int agem1 ;
		private float taux1;
		public float calculPrimerente( )  {
				float k = 0 ;
				k =(float) cs.calculPrimerentehomme(rente,ageclient1,agem1 ,taux1) ; 
				return k ;}
		public float calculPrimerentef( )  {
				float k = 0 ;
				k =(float) cs.calculPrimerentefemme(rente,ageclient1,agem1 ,taux1) ; 
				return k ;
		 }

		private float sinistre;
		private ProductType product;
		public float getsinistre() {
			return sinistre;
		}
		public void setsinistre(float sinistre) {
			this.sinistre = sinistre;
		}
		
		public float calculprimeauto( )  {
			float k ;
			k =(float) cs.calculPrimeAuto(sinistre,product) ;
			return k ; 
}
		public ProductType getProduct() {
			return product;
		}
		public void setProduct(ProductType product) {
			this.product = product;
		}
}


