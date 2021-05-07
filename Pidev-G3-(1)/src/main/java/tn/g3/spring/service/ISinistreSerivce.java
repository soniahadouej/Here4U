package tn.g3.spring.service;

 
import java.util.List; 

import tn.g3.spring.entity.Sinistre;


public interface ISinistreSerivce {

	 List<Sinistre> retrieveAllSinistres(); 
	 Sinistre addSinistre(Sinistre s ,Long id);
	 void deleteSinistre(String id);
	 Sinistre updateSinistre(Sinistre s);
	 Sinistre retrieveSinistre(String id);
	 Sinistre updateDescription(Long id ,String desc);
	
	 Long getMax();
	  //recherches
	 List<Sinistre> findByDescription(String name);
	 List<Sinistre> findByYear(String year);
	 List<Sinistre> findByAny(String any);
	 Sinistre FindByIdSin(Long id);
	  
	 //AFFECTATITON
	 public void affecterSinisterPerson(Long SinId, Long persId);
	
	 void CheckStatus();
	 void SendMail();
	 
	 // ******************FEMME
	 
	 
	  float calculPrimefemme(float capital , int ageClient, int AgeMax, double taux);
	  double calculCapitalfemme(double prime , int ageClient, int AgeMax, double taux);
	  // rachat total
	  public double calculCapitalAV(double prime , int ageClient, int AgeMax, double taux);  //prime unique
	  public double calculCapitalfemmePPer(double prime , int ageClient, int AgeMax, double taux);  //prime periodique
	 
	  // HOMME
	  //float calculPrimeHomme(float capital , int ageClient, int AgeMax, double taux);
	// float calculPrimeHomme(float capital , int ageClient, int AgeMax, double taux);	
	  
	/////  public String calculVieEntiere(double prime , int ageClient, int AgeMax, double taux, Long idsin, Long idPers);
	  
	  ///////////********************* HOMME
	  double calculCapitalHomme(double prime , int ageClient, int AgeMax, double taux);
	  
	  
	  ///////////////////////////////////////////////CAPITAL DECES
	  public double CapitalCasDécesHomme(double prime , double taux, int ageClient, Long idC);
      public double CapitalCasDécesFemme(double prime , double taux, int ageClient, Long idC);
	  
	  
	  
	  public void FindByIdPer(Long id);

	  //// CREDIT SIMULATOR
	  public double CreditSimulator( Long idp, Long idc, float emprunt);
	  
	  
	  ////JOINTURE
	  public List<Sinistre> findSinisterfromClaim(Long id);
	  
	  
	  /////////////////////////////////JSF
	  	  public List<Sinistre> getAllSinistres();
	  	public int addOrUpdateSinistre(Sinistre sinistre);
	  	public void deleteSinistre1(long id) ;
	  	public List<Sinistre> getAllSinistresById();
	  
	  	
	  	
	  	public float CVE(Long idS);
	  	public float CapDeces(Long idS) ;
	  	
	  	
	  	////////////////////////////////
	  	public int countVE();
	  	public int countCD();
	  	public int countTDE();
	  	
}

