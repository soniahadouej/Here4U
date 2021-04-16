package tn.g3.spring.service;
import java.util.List;
import tn.g3.spring.entity.Offer;
import tn.g3.spring.entity.OfferType;


public interface IOfferService { 
	
	List<Offer> retrieveAllOffers(); 
	Offer addOffer(Offer o);
	void deleteOffer(String id);
	Offer updateOffer(Offer o);
	Offer retrieveOffer(String id); 
	
	List<Offer> retrieveOffersByType(OfferType type);
	Offer retrieveOfferByName(String name);
	Offer retrieveOfferByCode(String code);
	List<Offer> retrieveOffersByMaxRedemption(Integer maxRed);
	
	
	
	

	
	
	
	
	

	

}
