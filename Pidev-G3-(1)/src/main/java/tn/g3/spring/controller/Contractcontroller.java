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

import tn.g3.spring.entity.Contract;
import tn.g3.spring.entity.ProductType;
import tn.g3.spring.service.IContractService;


@RestController
public class Contractcontroller {
	
	
		@Autowired
		IContractService cs;
		// http://localhost:8081/SpringMVC/servlet/retrieve-all-contract
		@GetMapping("/retrieve-all-contract")
		@ResponseBody
		public List<Contract> getContracts() {
		List<Contract> list = cs.retrieveAllContracts();
		return list;
		} 

		// http://localhost:8081/SpringMVC/servlet/retrieve-Contract/{contract-id}
		@GetMapping("/retrieve-Contract/{contract-id}")
		@ResponseBody
		public Contract retrieveContract(@PathVariable("contract-id") String id) {
		return cs.retrieveContract(id);
		} 

		
		// http://localhost:8081/SpringMVC/servlet/add-contract
		@PostMapping("/add-contract")
		@ResponseBody
		public Contract addContract(@RequestBody Contract c) {
		Contract contract = cs.addContract(c); 
		return contract;
		}

		// http://localhost:8081/SpringMVC/servlet/remove-contract/{contract-id}
		@DeleteMapping("/remove-contract/{contract-id}") 
		@ResponseBody
		public void removeContract(@PathVariable("contract-id") String id) { 
		cs.deleteContract(id);
		} 

	

		// http://localhost:8081/SpringMVC/servlet/update-Contract 
		@PutMapping("/update-Contract") 
		@ResponseBody
		public Contract updateContract(@RequestBody Contract contract) {
		return cs.updateContract(contract);
		}
		 @GetMapping("/calculprimevief/{cap}/{age}/{agem}/{taux}")
		  @ResponseBody
		  public float calculPrimevief( @PathVariable("cap") float capital , @PathVariable("age")int ageClient,@PathVariable("agem") int AgeMax,@PathVariable("taux") double taux  )  {
				float k = 0 ;
				k =(float) cs.calculPrimefemme(capital, ageClient,AgeMax,taux) ; 
				return k ;
	
}
		 @GetMapping("/calculprimevieh/{cap}/{age}/{agem}/{taux}")
		  @ResponseBody
		  public float calculPrimevieh( @PathVariable("cap") float capital , @PathVariable("age")int ageClient,@PathVariable("agem") int AgeMax,@PathVariable("taux") double taux  )  {
				float k = 0 ;
				k =(float) cs.calculPrimeHomme(capital, ageClient,AgeMax,taux) ; 
				return k ;
	
}
		 @GetMapping("/calculprimerente/{rente}/{age}/{agem}/{taux}")
		  @ResponseBody
		  public float calculPrimerente( @PathVariable("rente") float rente , @PathVariable("age")int ageClient,@PathVariable("agem") int nombreanne,@PathVariable("taux") double taux  )  {
				float k = 0 ;
				k =(float) cs.calculPrimerentehomme(rente, ageClient,nombreanne,taux) ; 
				return k ;
	
}
		 @GetMapping("/calculprimerentef/{rente}/{age}/{agem}/{taux}")
		  @ResponseBody
		  public float calculPrimerentef( @PathVariable("rente") float rente , @PathVariable("age")int ageClient,@PathVariable("agem") int nombreanne,@PathVariable("taux") double taux  )  {
				float k = 0 ;
				k =(float) cs.calculPrimerentefemme(rente, ageClient,nombreanne,taux) ; 
				return k ; 
	
}
		 @GetMapping("/calculprimeauto/{sinistre}/{product}")
		  @ResponseBody
		  public float calculprimeauto( @PathVariable("sinistre")float sinistre ,@PathVariable("product") ProductType producttype)  {
				float k ;
				k =(float) cs.calculPrimeAuto(sinistre,producttype) ;
				return k ; 
		 }
		 
}
