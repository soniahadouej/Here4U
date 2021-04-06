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
	
	
	// http://localhost:8000/SpringMVC/servlet/retrieve-All-Sinistres  
		 @GetMapping("/retrieve-All-Sinistres")
		 @ResponseBody
		 public List<Sinistre> getSinister() {
		  List<Sinistre> sins = new ArrayList<>() ;
		 sr.retrieveAllSinistres().forEach(sins::add);
		 return sins;
		 } 
		 
			// http://localhost:8000/SpringMVC/servlet/getSinisterByAny/any
		 @GetMapping("/getSinisterByAny/{any}")
		 @ResponseBody
		 public List<Sinistre> getsinisterbyAny(@PathVariable(value = "any") String any) {
		 List<Sinistre> sinistres =sr.findByAny(any);
		 return sinistres;
		 } 
		 
		 // http://localhost:8000/SpringMVC/servlet/retrieve-sinistre/{id_sinistre}
		  @GetMapping("/retrieve-sinistre/{id_sinistre}")
		  public Sinistre retrieveUser(@PathVariable("id_sinistre") String sinisterid) {
			 
		  return sr.retrieveSinistre(sinisterid);
		  }
		  

		 // Ajouter sinister : http://localhost:8000/SpringMVC/servlet/add-sinistre
		 /* {
		    "dateOccurence" : "2010-03-23", 
		    "description" :"neeeew 2", 
		    "documents" : "null",
		    "typeSinistre": "Vie",
		     "status" : "Rejetée"
		      }		*/
		  @PostMapping("/add-sinistre")
		 // @ResponseBody()
		  public Sinistre addSinister(@RequestBody Sinistre s) {
			  Sinistre sin = sr.addSinistre(s);
		  return sin ;
		  
		  }
		
		// http://localhost:8000/SpringMVC/servlet/remove-sinistre/{sinistre-id}
		   @DeleteMapping("/remove-sinistre/{sinistre-id}")
		   public void removeSinistre(@PathVariable("sinistre-id") String sinId) {
		   sr.deleteSinistre(sinId);
		   }
		   
		  
		   // http://localhost:8000/SpringMVC/servlet/modify-sinistre
		   @PutMapping("/modify-sinistre")
		    @ResponseBody
		    public Sinistre modifySinistre(@RequestBody Sinistre sinistre){
		    return sr.updateSinistre(sinistre);
		   }
}
