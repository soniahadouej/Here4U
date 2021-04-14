package tn.g3.spring.service;
import java.util.Date;
import java.util.List;
import tn.g3.spring.entity.CivilStatus;
import tn.g3.spring.entity.Contract;
import tn.g3.spring.entity.Offer;
import tn.g3.spring.entity.OfferType;
import tn.g3.spring.entity.ProductType;
import tn.g3.spring.entity.SinisterType;

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
	
	/**/
	float calculateGift(Contract c, int age, CivilStatus category, float salary, Date startdate );
	float calculateDiscount(Contract c, Date startContract, int nbrSinistre, SinisterType typeSinistre,ProductType productType);
	float calculateLoyalty(Contract c,Date startContract, Date finishContract, int nbrPoints );
	
	
	

	
	
	
	
	

	

}
