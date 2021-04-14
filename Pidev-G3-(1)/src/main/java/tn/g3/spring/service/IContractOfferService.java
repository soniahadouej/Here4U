package tn.g3.spring.service;
import java.util.Date;
import java.util.List;
import tn.g3.spring.entity.Contract;
import tn.g3.spring.entity.ContractOffer;
import tn.g3.spring.entity.ContractOfferPK;
import tn.g3.spring.entity.Offer;
import tn.g3.spring.entity.OfferStatus;

public interface IContractOfferService {
	
	List<Offer> retrieveOffersByStartingDate(Date startOffer);
	List<Offer> retrieveOffersByExpiringDate(Date expireOffer);
	List<Offer> findAllOffersByContract(Long idc);
	
	List<Contract> retrieveContractsByOfferStatus(OfferStatus status);
	List<Contract> findAllContractsByOffer(Long ido);
	List<Contract> getContractsByOfferDate(Date startOffer,Date expireOffer);
	
	void addContractOffer(Long idc, Long ido, Date startOffer, Date expireOffer, OfferStatus statusOffer);
	public int countActiveOffers();
	public int countStoppedOffers();
	ContractOffer getContractOfferPK(ContractOfferPK copk);
	public String activateContactOffer (ContractOfferPK copk);
    public String desactivateContractOffer (ContractOfferPK copk);
	
	
	
	
	
}
