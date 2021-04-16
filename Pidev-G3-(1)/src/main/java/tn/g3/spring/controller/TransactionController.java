package tn.g3.spring.controller;


import java.io.IOException;  
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.time.LocalDateTime;

import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.g3.spring.entity.*;
import tn.g3.spring.repository.*;
import tn.g3.spring.service.*;
import tn.g3.spring.controller.*;






@RestController
@RequestMapping("/transaction")
public class TransactionController { 

	@Autowired
	TransactionServiceImpl transService;
	

	@Autowired
	IContractService contract;

	@Autowired
	ContractServiceImpl cr;

	@Autowired
	ContractRepository crr;
	@Autowired
	   private Smsservice smsservice;

	/*@Autowired
	ProjectRepository  projectRepository;
	 */
	@Autowired
	PersonRepository userRepository;
	
	/*@Autowired
	TwillioController twilioCon;*/


	//http://localhost:8000/SpringMVC/servlet/transaction/all
	@GetMapping("/all")
	@ResponseBody
	public List<Transaction> getTransaction (){
		List<Transaction> list =  transService.retrieveAllTransactions();
		return list;
	}


	// http://localhost:8000/SpringMVC/servlet/transaction/all/1
	@GetMapping("/all/{id}")
	@ResponseBody
	public Transaction getTransaction (@PathVariable("id")int id){
		Transaction t =transService.retrieveTransactions(id);
		return t;

	}
	
	/*
	 * http://localhost:8000/SpringMVC/servlet/transaction/project/{name}
	@GetMapping("/project/{name}")
	@ResponseBody
	public List<Project> findByProjectnameOrderByProjectdateAsc (@PathVariable("name")String name){
	  return projectRepository.findByProjectnameOrderByProjectdateAsc(name);
	}
	 */
	//Conversion
	
	public Date convertToDateViaSqlTimestamp(LocalDateTime dateToConvert) {
		return java.sql.Timestamp.valueOf(dateToConvert);
	}


	//as an investor
	// http://localhost:8000/SpringMVC/servlet/transaction/GiveMoney/{idContract}/{nbreC}/{amount}
	@GetMapping("/GiveMoney/{idContract}") // /{nbreC}/{amount}")
	@ResponseBody
	public ResponseEntity<Object> payWithCoupon (@PathVariable("idContract")Long idC , Smsrequest smsrequest) { //, @PathVariable("nbreC") int nbreC,@PathVariable("amount")float amount){
		Contract c=  contract.retrieveContract(idC);
		Date d=convertToDateViaSqlTimestamp(LocalDateTime.now());
		//float sum=amount * nbreC;
		        
		Transaction t =new Transaction(d ,c.getPaymentType().toString());
		t.setTransactionprice(c);
 		
		t.setTransactionAmount(c.getPremiumContract());
		transService.addTransaction(t);
		String status=smsservice.sendsms(smsrequest);
		   if("sent".equals(status)||"queued".equals(status))
	       {
	       	return new ResponseEntity<Object>("sent successfully",HttpStatus.OK);
	       }
		   return new ResponseEntity<Object>("failed to send message",HttpStatus.NOT_FOUND);
		//twilioCon.sendotp("+21626233576");
	}

}