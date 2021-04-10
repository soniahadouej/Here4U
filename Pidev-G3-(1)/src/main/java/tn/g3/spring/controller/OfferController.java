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

import tn.g3.spring.entity.ContractOffer;
import tn.g3.spring.entity.ContractOfferPK;
import tn.g3.spring.entity.Offer;
import tn.g3.spring.entity.OfferStatus;
import tn.g3.spring.entity.OfferType;
import tn.g3.spring.service.OfferService;

@RestController
public class OfferController {
	@Autowired
	OfferService offerService;
	
	// http://localhost:8080/SpringMVC/servlet/retrieve-all-offers
	@GetMapping("/retrieve-all-offers")
	@ResponseBody
	public List<Offer> getOffers() {
	List<Offer> list = offerService.retrieveAllOffers();
	return list;
	} 
	
	// http://localhost:8080/SpringMVC/servlet/retrieve-offer/{offer-id}
	@GetMapping("/retrieve-offer/{offer-id}")
	@ResponseBody
	public Offer retrieveOffer(@PathVariable("offer-id") String offerId) {
	return offerService.retrieveOffer(offerId);
	} 
	
	/* {
	
	"idOffer" :"1",
	"typeOffer" :"Gift",
	"descriptionOffer" :"new Offer", 
    "nameOffer" :"Hello", 
    "codeOffer" : "Abc19g23",
    "maxRedemption": "3"
      }		*/
	
	// http://localhost:8080/SpringMVC/servlet/add-offer
	@PostMapping("/add-offer")
	@ResponseBody
	public Offer addOffer(@RequestBody Offer o) {
	Offer offer = offerService.addOffer(o); 
	return offer;
	}

	// http://localhost:8080/SpringMVC/servlet/remove-offer/{offer-id}
	@DeleteMapping("/remove-offer/{offer-id}") 
	@ResponseBody
	public void removeOffer(@PathVariable("offer-id") String offerId) { 
	offerService.deleteOffer(offerId);
	} 
	
/* {
	"typeOffer" :"Discount",
	"descriptionOffer" :"new Offer", 
    "nameOffer" :"Hello", 
    "codeOffer" : "Abc19g23",
    "maxRedemption": "3"
      }		*/
	
	// http://localhost:8080/SpringMVC/servlet/update-offer 
	@PutMapping("/update-offer") 
	@ResponseBody
	public Offer updateOffer(@RequestBody Offer offer) {
	return offerService.updateOffer(offer);
	}
	
	// http://localhost:8080/SpringMVC/servlet/retrieve-offers-by-type/{offer-type}
		@GetMapping("/retrieve-offers-by-type/{offer-type}")
		@ResponseBody
		public List<Offer> retrieveOffersByType(@PathVariable("offer-type") OfferType type) {
		List<Offer> list = offerService.retrieveOffersByType(type);
		return list;
		} 
	
		
		// http://localhost:8089/SpringMVC/servlet/retrieve-offer-by-name/{offer-name}
		@GetMapping("/retrieve-offer-by-name/{offer-name}")
		@ResponseBody
		public Offer retrieveOfferByName(@PathVariable("offer-name") String name) {
		return offerService.retrieveOfferByName(name);
		} 
		
		// http://localhost:8089/SpringMVC/servlet/retrieve-offer-by-code/{offer-code}
		@GetMapping("/retrieve-offer-by-code/{offer-code}")
		@ResponseBody
		public Offer retrieveOfferByCode(@PathVariable("offer-code") String code) {
		return offerService.retrieveOfferByCode(code);
		} 
		
		// http://localhost:8089/SpringMVC/servlet/retrieve-offers-by-maxredemption/{offer-maxredemption}
		@GetMapping("/retrieve-offers-by-maxredemption/{offer-maxredemption}")
		@ResponseBody
		public List<Offer> retrieveOffersByMaxRedemption(@PathVariable("offer-maxredemption") Integer maxRed) {
		List<Offer> list = offerService.retrieveOffersByMaxRedemption(maxRed);
		return list;
		} 
		
		// http://localhost:8089/SpringMVC/servlet/retrieve-offers-by-status/{contract_offer-status}
		@GetMapping("/retrieve-offers-by-status/{contract_offer-status}")
		@ResponseBody
		public List<ContractOffer> retrieveOffersByStatus(@PathVariable("contractoffer-status") OfferStatus status) {
		List<ContractOffer> list = offerService.retrieveOffersByStatus(status);
		return list;
		} 
		
		// http://localhost:8089/SpringMVC/servlet/find-offers-by-contract/{contract_offer-contract-id}
		@GetMapping("/find-offers-by-contract/{contract_offer-contract-id}")
		@ResponseBody
		public List<ContractOffer> findAllOffersByContract(@PathVariable("contract_offer-contract-id") ContractOfferPK coPk) {
		List<ContractOffer> list = offerService.findAllOffersByContract(coPk);
		return list;
		} 
	
		// http://localhost:8089/SpringMVC/servlet/find-contracts-by-offer/{contract_offer-offer-id}
		@GetMapping("/find-contracts-by-offer/{contract_offer-offer-id}")
		@ResponseBody
		public List<ContractOffer> findAllContractsByOffer(@PathVariable("contract_offer-offer-id") ContractOfferPK coPk) {
		List<ContractOffer> list = offerService.findAllContractsByOffer(coPk);
		return list;
		} 
		
		// http://localhost:8089/SpringMVC/servlet/apply-offer-to-contract/{contract_offer-offer-id}/{contract_offer-contract-id}
		@PutMapping("/apply-offer-to-contract/{contract_offer-offer-id}/{contract_offer-contract-id}") 
		@ResponseBody
		public void applyOfferToContract(String ido, String idc) { 
		offerService.applyOfferToContract(ido, idc);
		} 
}
