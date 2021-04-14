package tn.g3.spring.controller;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.g3.spring.entity.Contract;
import tn.g3.spring.entity.ContractOfferPK;
import tn.g3.spring.entity.Offer;
import tn.g3.spring.entity.OfferStatus;
import tn.g3.spring.entity.OfferType;
import tn.g3.spring.service.IContractOfferService;
import tn.g3.spring.service.IOfferService;

@RestController
public class OfferController {

	@Autowired
	IOfferService offerService;

	@Autowired
	IContractOfferService contractOfferService;

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


	// http://localhost:8080/SpringMVC/servlet/retrieve-offer-by-name/{offer-name}
	@GetMapping("/retrieve-offer-by-name/{offer-name}")
	@ResponseBody
	public Offer retrieveOfferByName(@PathVariable("offer-name") String name) {
		return offerService.retrieveOfferByName(name);
	} 

	// http://localhost:8080/SpringMVC/servlet/retrieve-offer-by-code/{offer-code}
	@GetMapping("/retrieve-offer-by-code/{offer-code}")
	@ResponseBody
	public Offer retrieveOfferByCode(@PathVariable("offer-code") String code) {
		return offerService.retrieveOfferByCode(code);
	} 

	// http://localhost:8080/SpringMVC/servlet/retrieve-offers-by-maxredemption/{offer-maxredemption}
	@GetMapping("/retrieve-offers-by-maxredemption/{offer-maxredemption}")
	@ResponseBody
	public List<Offer> retrieveOffersByMaxRedemption(@PathVariable("offer-maxredemption") Integer maxRed) {
		List<Offer> list = offerService.retrieveOffersByMaxRedemption(maxRed);
		return list;
	} 

	// http://localhost:8080/SpringMVC/servlet/retrieve-contracts-by-offer-status/{offer-status}
	@GetMapping("/retrieve-contracts-by-offer-status/{offer-status}")
	@ResponseBody
	public List<Contract> retrieveContractsByOfferStatus(@PathVariable("offer-status") OfferStatus status) {
		List<Contract> list = contractOfferService.retrieveContractsByOfferStatus(status);
		return list;
	} 

	// http://localhost:8080/SpringMVC/servlet/find-all-offers-by-contract/{contract-id}
	@GetMapping("/find-all-offers-by-contract/{contract-id}")
	@ResponseBody
	public List<Offer> findAllOffersByContract(@PathVariable("contract-id") Long idc) {
		List<Offer> list = contractOfferService.findAllOffersByContract(idc);
		return list;
	} 

	// http://localhost:8080/SpringMVC/servlet/find-contracts-by-offer/{offer-id}
	@GetMapping("/find-contracts-by-offer/{offer-id}")
	@ResponseBody
	public List<Contract> findAllContractsByOffer(@PathVariable("offer-id") Long ido) {
		List<Contract> list = contractOfferService.findAllContractsByOffer(ido);
		return list;
	} 


	// http://localhost:8080/SpringMVC/servlet/add-contract-offer/{contract-id}/{offer-id}/{start-offer}/{expire-offer}/{status-offer}
	//{"idContract":1,"idOffer":2,"startOffer":"2020-03-01","expireOffer":"2022-03-01", "statusOffer":"Expired"}

	@PostMapping("/add-contract-offer/{contract-id}/{offer-id}/{start-offer}/{expire-offer}/{status-offer}")
	@ResponseBody
	public void addContractOffer(@PathVariable("contract-id") Long idc, @PathVariable("offer-id") Long ido, @PathVariable("start-offer") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startOffer, @PathVariable("expire-offer") @DateTimeFormat(pattern = "yyyy-MM-dd") Date expireOffer, @PathVariable("status-offer") OfferStatus statusOffer) {
		 contractOfferService.addContractOffer(idc, ido, startOffer, expireOffer, statusOffer);
		
	}

	// http://localhost:8080/SpringMVC/servlet/retrieve-offers-by-start-offer/{start-offer}
	@GetMapping("retrieve-offers-by-start-offer/{start-offer}")
	@ResponseBody
	public List<Offer> retrieveOffersByStartingDate(@PathVariable("start-offer") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startOffer) {
		List<Offer> list = contractOfferService.retrieveOffersByStartingDate(startOffer);
		return list;
	} 

	// http://localhost:8080/SpringMVC/servlet/retrieve-offers-by-expire-offer/{expire-offer}
	@GetMapping("retrieve-offers-by-expire-offer/{expire-offer}")
	@ResponseBody
	public List<Offer> retrieveOffersByExpiringDate(@PathVariable("expire-offer") @DateTimeFormat(pattern = "yyyy-MM-dd") Date expireOffer) {
		List<Offer> list = contractOfferService.retrieveOffersByExpiringDate(expireOffer);
		return list;
	} 

	// http://localhost:8080/SpringMVC/servlet/get-contracts-by-date/{start-offer}/{expire-offer}
	@GetMapping("get-contracts-by-date/{start-offer}/{expire-offer}")
	@ResponseBody
	public List<Contract> getContractsByOfferDate(@PathVariable("start-offer") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startOffer, @PathVariable("expire-offer") @DateTimeFormat(pattern = "yyyy-MM-dd") Date expireOffer) {
		List<Contract> list = contractOfferService.getContractsByOfferDate(startOffer,expireOffer);
		return list;
	} 

	// http://localhost:8080/SpringMVC/servlet/count-active-offers
    @GetMapping(value = "count-active-offers")
    @ResponseBody
	public int countActiveOffers() {
		
		return contractOfferService.countActiveOffers();
	}
    
 // http://localhost:8080/SpringMVC/servlet/count-stopped-offers
    @GetMapping(value = "count-stopped-offers")
    @ResponseBody
	public int countStoppedOffers() {
		
		return contractOfferService.countStoppedOffers();
	}

    // http://localhost:8080/SpringMVC/servlet/activate-contract-offer
    	@PutMapping(value = "activate-contract-offer")
	@ResponseBody
	public String activateContactOffer(@RequestBody ContractOfferPK copk) {

		return contractOfferService.activateContactOffer(copk);
	}
    
    // http://localhost:8080/SpringMVC/servlet/desactivate-contract-offer
   	@PutMapping(value = "desactivate-contract-offer")
   	@ResponseBody
   	public String desactivateContactOffer(@RequestBody ContractOfferPK copk) {
   		
    	return contractOfferService.desactivateContractOffer(copk);
   	}
    


}
