package tn.g3.spring.controller;
import java.util.ArrayList;
import java.util.List; 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.g3.spring.entity.SinisterStatus;
import tn.g3.spring.entity.Sinistre;
import tn.g3.spring.service.ISinistreSerivce;




@RestController

public class SinistreController {
	@Autowired
	ISinistreSerivce sr;
	
	
	//AJOUUUT
	 //  http://localhost:8000/SpringMVC/servlet/add-sinistre/id
	 /* {
	    "dateOccurence" : "2010-03-23", 
	    "description" :"Description detaillée du sinistre", 
	    "documents" : "null",
	    "typeSinistre": "DécesVieEntiere",  "RachatTotalVieEntiere" "RachatPartielVieEntiere"
	     "status" : "EnAttente" ,  "En_Cous" "Rejetée" "Validée"
	 
	      }		*/
	  @PostMapping("/add-sinistre/{id}")
	 // @ResponseBody()
	  public Sinistre addSinister(@RequestBody Sinistre s ,@PathVariable(value ="id") Long id) {
		 // System.out.println(id);
		  s.setStatus(SinisterStatus.EnAttente);
		  Sinistre sin = sr.addSinistre(s,id);
	  return sin ;
	  
	  }
	
	
	// http://localhost:8000/SpringMVC/servlet/retrieve-All-Sinistres  
		 @GetMapping("/retrieve-All-Sinistres")
		 @ResponseBody
		 public List<Sinistre> getSinister() {
		  List<Sinistre> sins = new ArrayList<>() ;
		 sr.retrieveAllSinistres().forEach(sins::add);
		 return sins;
		 } 
		 
		 //// FIND ?
		/*	// http://localhost:8000/SpringMVC/servlet/getSinisterByAny/any
		 @GetMapping("/getSinisterByAny/{any}")
		 @ResponseBody
		 public List<Sinistre> getsinisterbyAny(@PathVariable(value = "any") String any) {
		 List<Sinistre> sinistres =sr.findByAny(any);
		 return sinistres;
		 } 
		 */
		 // http://localhost:8000/SpringMVC/servlet/retrieve-sinistre/{id_sinistre}
		  @GetMapping("/retrieve-sinistre/{id_sinistre}")
		  public Sinistre retrieveUser(@PathVariable("id_sinistre") String sinisterid) {
			 
		  return sr.retrieveSinistre(sinisterid);
		  }
		  
		  	
		
		// http://localhost:8000/SpringMVC/servlet/remove-sinistre/{sinistre-id}
		   @DeleteMapping("/remove-sinistre/{sinistre-id}")
		   public void removeSinistre(@PathVariable("sinistre-id") String sinId) {
		   sr.deleteSinistre(sinId);
		   }
		   
		  
		   // http://localhost:8000/SpringMVC/servlet/modify-sinistre/id
		  /* {      "idSinistre": 5,
			    "typeSinistre": "DécesVieEntiere",  "RachatTotalVieEntiere" "RachatPartielVieEntiere"
			    "description": "Description detkkkkkkkkkkkkkkkkkkkkkkkkkkkkkinistre",
			    "dateOccurence": "2010-03-22",
			    "status": "EnAttente",
			    "documents": null } */
		   @PutMapping("/modify-sinistre/{sinistre-id}")
		    @ResponseBody
		    public Sinistre modifySinistre(@RequestBody Sinistre s, @PathVariable("sinistre-id") Sinistre sinId){
		    return sr.updateSinistre(s);
		   }
		   
		   
		   
		  		  	   ///AFFECTATION
		 //http://localhost:8000/SpringMVC/servlet/affecter-sinistre/10/10
			  @PutMapping(value = "/affecter-sinistre/{idSin}/{idUser}") 
			  public void affecterSinistrePerson(@PathVariable("idSin")Long idSin, @PathVariable("idUser")Long idUser) {
			  sr.affecterSinisterPerson(idSin, idUser);
			  }
			  		   
		   
		   
		   
		   /////////////////////////// *********CHECCK STATUS ++ send Mail
		// http://localhost:8000/SpringMVC/servlet/check-status_SendMail
		   @PutMapping("/check-status_SendMail")
		    @ResponseBody
		   public void testStatus() {
				sr.CheckStatus();	
				 sr.SendMail();
				
			}
		   
		  //  http://localhost:8000/SpringMVC/servlet/send-mail
		   @GetMapping("/send-mail")
		   @ResponseBody
		   public void testSendMail() {
			  
			}

		   
		   
		   
		   ///////////////////////CREDI SIMULATOR
		   
		//  http://localhost:8000/SpringMVC/servlet/creditsimul//0/
		   @GetMapping("/creditsimul/{idU}/{idC}")
			  @ResponseBody
			  public float creditsimul( @PathVariable("idU") Long idU , @PathVariable("idC") Long idC)  {
					float k = 0 ;
					k = (float) sr.CreditSimulator(idU, idC) ; 
					return k ;
		
}
		   
		   
		   
		   /////////////////////////////////////JOINTURE
		//  http://localhost:8000/SpringMVC/servlet/FindSinistreDescription/1
		   @GetMapping("/FindSinistreDescription/{idC}")
		    @ResponseBody
		   public List<Sinistre> findSinisterfromClaim(@PathVariable("idC") Long id)
			{ 
				List<Sinistre> k = sr.findSinisterfromClaim(id);
				return k;
				
			}
		   
		   
		   
		   
}