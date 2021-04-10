package tn.g3.spring.service;
import java.util.Date;
import java.util.List;

import tn.g3.spring.entity.CivilStatus;
import tn.g3.spring.entity.Contract;
import tn.g3.spring.entity.ContractOffer;
import tn.g3.spring.entity.ContractOfferPK;
import tn.g3.spring.entity.Offer;
import tn.g3.spring.entity.OfferStatus;
import tn.g3.spring.entity.OfferType;
import tn.g3.spring.entity.ProductType;
import tn.g3.spring.entity.SinisterType;

public interface OfferService { 
	
	List<Offer> retrieveAllOffers(); 
	Offer addOffer(Offer o);
	void deleteOffer(String id);
	Offer updateOffer(Offer o);
	Offer retrieveOffer(String id);
	 
	 /**/
	List<Offer> retrieveOffersByType(OfferType type);
	Offer retrieveOfferByName(String name);
	Offer retrieveOfferByCode(String code);
	List<Offer> retrieveOffersByMaxRedemption(Integer maxRed);
	
	/*List<ContractOffer> retrieveOffersByStartingDate(Date start);*/
	/*List<ContractOffer> retrieveOffersByExpiringDate(String expire);*/
	List<ContractOffer> retrieveOffersByStatus(OfferStatus status);
	List<ContractOffer> findAllOffersByContract(ContractOfferPK coPk);
	List<ContractOffer> findAllContractsByOffer(ContractOfferPK coPk);
	
	
	
	void applyOfferToContract(String ido, String idc);
	
	float calculateGift(Contract c, int age, CivilStatus category, float salary, Date startdate );
	float calculateDiscount(Contract c, Date startContract, int nbrSinistre, SinisterType typeSinistre,ProductType productType);
	float calculateLoyalty(Contract c,Date startContract, Date finishContract, int nbrPoints );
	
	
	

	
	
	
	
	

	

}
