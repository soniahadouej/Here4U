package tn.g3.spring.service;

 
import java.util.List; 

import tn.g3.spring.entity.Sinistre;


public interface ISinistreSerivce {

	 List<Sinistre> retrieveAllSinistres(); 
	 Sinistre addSinistre(Sinistre s);
	 void deleteSinistre(String id);
	 Sinistre updateSinistre(Sinistre s);
	 Sinistre retrieveSinistre(String id);
	
	 Long getMax();
	  //recherches
	 List<Sinistre> findByDescription(String name);
	 List<Sinistre> findByYear(String year);
	 List<Sinistre> findByAny(String any);
	  
	 //update
	//void updateStatus(Long id, String newStatus);
	
	 void CheckStatus();
	 void SendMail();
	 
	 // ******************FEMME
	  float calculPrimefemme(float capital , int ageClient, int AgeMax, double taux);
	  double calculCapitalfemme(double prime , int ageClient, int AgeMax, double taux);
	  // rachat total
	  public double calculCapitalfemmeAV(double prime , int ageClient, int AgeMax, double taux);
	 
	  // HOMME
	  float calculPrimeHomme(float capital , int ageClient, int AgeMax, double taux);
	// float calculPrimeHomme(float capital , int ageClient, int AgeMax, double taux);	
	  
	  public String calculVieEntiere(double prime , int ageClient, int AgeMax, double taux, String typeSin, Long idPers);

}

