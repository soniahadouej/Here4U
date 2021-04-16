package tn.g3.spring.controller;

import org.omg.IOP.TransactionService;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.base.rest.PayPalRESTException;


import tn.g3.spring.entity.Sinistre;
import tn.g3.spring.entity.Transaction;
import tn.g3.spring.service.ITransactionService;
import tn.g3.spring.service.PaypalService;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;


@RestController
public class PaypalController {

	@Autowired
	PaypalService service;

	@Autowired
	ITransactionService transaction;
	
	
	public static final String SUCCESS_URL = "pay/success";
	public static final String CANCEL_URL = "pay/cancel";

	
	//http://localhost:8000/SpringMVC/servlet/pay/{id_transaction}
	/*  "premiumContract" : 200, 
         "currency" : "USD",
	    "paymentType" :"PAYPAL", 
	    "intent" : "sale",
	    "descriptionContract":  "jjjj"
	    }	*/
	
	@GetMapping("/pay/{id_transaction}")
	public String payment(@PathVariable("id_transaction") int idt ) throws PayPalRESTException {
		
		Transaction c= transaction.retrieveTransactions(idt);
		Payment payment = service.createPayment(c.getTransactionAmount(), c.getTransactionprice().getCurrency() , c.getTransactionType().toString(), c.getTransactionprice().getIntent(), c.getTransactionprice().getDescriptionContract(), "http://localhost:8000/" + CANCEL_URL,
				"http://localhost:8000/" + SUCCESS_URL);
				//(c.getPremiumContract(), c.getCurrency() , c.getPaymentType(), c.getIntent(), c.getDescriptionContract()
		for(Links link:payment.getLinks()) {
			if(link.getRel().equals("approval_url")) {
				//return "success" ;
				return "redirect:"+link.getHref();
			}
		}
		//return "redirect:/"; 
		return "paypal";
	}

	@GetMapping(value = CANCEL_URL) //cas derreur
	public String cancelPay() {
		return "cancel";
	}

	@GetMapping(value = SUCCESS_URL) // cas de sucess
	public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
		try {
			Payment payment = service.executePayment(paymentId, payerId);
			System.out.println(payment.toJSON());
			if (payment.getState().equals("approved")) {
				return "success";
			}
		} catch (PayPalRESTException e) {
			System.out.println(e.getMessage());
		}
		return "redirect:/";
	}

}
