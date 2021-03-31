package tn.g3.spring.service;
import java.util.List;
import tn.g3.spring.entity.Offer;

public interface OfferService {
	List<Offer> retrieveAllOffers(); 
	Offer addOffer(Offer o);
	void deleteOffer(String id);
	Offer updateOffer(Offer o);
	Offer retrieveOffer(String id);

}
