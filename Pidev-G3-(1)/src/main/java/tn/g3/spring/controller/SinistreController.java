package tn.g3.spring.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.g3.spring.entity.Sinistre;
import tn.g3.spring.service.ISinistreService; 

@RestController
public class SinistreController { 

	@Autowired
	ISinistreService sr;

	// http://localhost:8080/SpringMVC/servlet/retrieve-all-sinistre
	@GetMapping("/retrieve-all-sinistre")
	@ResponseBody
	public List<Sinistre> getProducts() {
		List<Sinistre> list = sr.retrieveAllSinistres();
		return list;
	} 

	// http://localhost:8080/SpringMVC/servlet/retrieve-sinistre/{sinistre-id}
	@GetMapping("/retrieve-sinistre/{sinistre-id}")
	@ResponseBody
	public Sinistre retrieveSinistre(@PathVariable("sinistre-id") String id) {
		return sr.retrieveSinistre(id);
	} 


	// http://localhost:8080/SpringMVC/servlet/add-sinistre 
	@PostMapping("/add-sinistre") 
	@ResponseBody
	public Sinistre addSinistre(@RequestBody Sinistre s) {
		Sinistre sinistre = sr.addSinistre(s); 
		return sinistre;
	}

	// http://localhost:8080/SpringMVC/servlet/remove-sinistre/{sinistre-id}
	@DeleteMapping("/remove-sinistre/{sinistre-id}") 
	@ResponseBody
	public void removeSinistre(@PathVariable("sinistre-id") String id) { 
		sr.deleteSinistre(id);
	} 



	// http://localhost:8080/SpringMVC/servlet/update-sinistre 
	@PutMapping("/update-sinistre") 
	@ResponseBody
	public Sinistre updateProduct(@RequestBody Sinistre p) {
		return sr.updateSinistre(p);
	}


}
