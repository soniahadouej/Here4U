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

}

