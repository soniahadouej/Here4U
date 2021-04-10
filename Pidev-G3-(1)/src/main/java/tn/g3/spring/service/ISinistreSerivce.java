package tn.g3.spring.service;

 
import java.util.List; 

import tn.g3.spring.entity.Sinistre;


public interface ISinistreSerivce {

	 List<Sinistre> retrieveAllSinistres(); 
	 Sinistre addSinistre(Sinistre s ,Long id);
	 void deleteSinistre(String id);
	 Sinistre updateSinistre(Sinistre s);
	 Sinistre retrieveSinistre(String id);
	
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
	  
	  
	  
	  
	  
	  
	  
	  public void FindByIdPer(Long id);

	  //// CREDIT SIMULATOR
	  public double CreditSimulator(Long idp, Long idc);
	  
	  
	  ////JOINTURE
	  public List<Sinistre> findSinisterfromClaim(Long id);
	  
}

