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
		   
		  
		   // http://localhost:8000/SpringMVC/servlet/modify-sinistre
		   @PutMapping("/modify-sinistre/{sinistre-id")
		    @ResponseBody
		    public Sinistre modifySinistre(@PathVariable("sinistre-id") Sinistre sinId){
		    return sr.updateSinistre(sinId);
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

		   
		   ///////////////////////////// CACUL VIE ENTIERE////////////////////////
		   // http://localhost:8000/SpringMVC/servlet/CalculVieEntiere/{prime}/{ageClient}/{AgeMax}/{idSin}
		   // http://localhost:8000/SpringMVC/servlet/CalculVieEntiere/30.354326/30/36/21
		   @GetMapping("/CalculVieEntiere/{prime}/{ageClient}/{AgeMax}/{idSin}")
		   @ResponseBody
		   public double testCalculFinal(@PathVariable(value = "prime") double prime, @PathVariable(value = "ageClient")int ageClient,
			   @PathVariable(value = "AgeMax") int AgeMax, @PathVariable(value = "idSin") Long idSin)
		   
				{double taux = 0.0624 ; 
			     double res=0;
			   
			   //RECUPERER LES SINISTRE EN ATTENTE
			   if (sr.FindByIdSin(idSin).getPerson().getSex().toString().equals("Female") ){  //cas Female
			   	if ( sr.FindByIdSin(idSin).getTypeSinistre().toString().equals("DécesVieEntiere") )
						{
			   		
			   		// if 
					 res = sr.calculCapitalfemme(prime ,ageClient, AgeMax, taux);
					 // else prime périodique
					 //res = sr.calculCapitalfemmePPer(prime ,ageClient, AgeMax, taux);
					 
						}
				else if (sr.FindByIdSin(idSin).getTypeSinistre().toString().equals("RachatTotalVieEntiere") ) // 1 seul cas de prime 
				{
					res = sr.calculCapitalAV(prime, ageClient, AgeMax, taux);
				} 
			   }
			    
			    else  
			    {
			    	if ( sr.FindByIdSin(idSin).getTypeSinistre().toString().equals("DécesVieEntiere") )
					{
				 res = sr.calculCapitalHomme(prime ,ageClient, AgeMax, taux);
					}
			    	else if (sr.FindByIdSin(idSin).getTypeSinistre().toString().equals("RachatTotalVieEntiere") )
					{
			    		res = sr.calculCapitalAV(prime, ageClient, AgeMax, taux);
					} 
			    }
			    return res;	
			   
				
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