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
import tn.g3.spring.service.IContractService;


@RestController
public class ContractController {
	
	
		@Autowired
		IContractService cs;
		
		// http://localhost:8080/SpringMVC/servlet/retrieve-all-contract
		@GetMapping("/retrieve-all-contract")
		@ResponseBody
		public List<Contract> getContracts() {
		List<Contract> list = cs.retrieveAllContracts();
		return list;
		} 

		// http://localhost:8080/SpringMVC/servlet/retrieve-Contract/{contract-id}
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

		// http://localhost:8080/SpringMVC/servlet/remove-contract/{contract-id}
		@DeleteMapping("/remove-contract/{contract-id}") 
		@ResponseBody
		public void removeContract(@PathVariable("contract-id") String id) { 
		cs.deleteContract(id);
		} 

	

		// http://localhost:8080/SpringMVC/servlet/update-Contract 
		@PutMapping("/update-Contract") 
		@ResponseBody
		public Contract updateContract(@RequestBody Contract contract) {
		return cs.updateContract(contract);
		}


}
