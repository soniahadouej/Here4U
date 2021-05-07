package tn.g3.spring.service;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.g3.spring.entity.Contract;
import tn.g3.spring.entity.ContractOffer;
import tn.g3.spring.entity.ContractOfferPK;
import tn.g3.spring.entity.Offer;
import tn.g3.spring.entity.OfferStatus;
import tn.g3.spring.repository.ContractOfferRepository;
import tn.g3.spring.repository.ContractRepository;
import tn.g3.spring.repository.OfferRepository;
import tn.g3.spring.repository.PersonRepository;
@Service
public class ContractOfferServiceImpl implements IContractOfferService{

	@Autowired
	ContractOfferRepository contractOfferRepository;
	
	@Autowired
	OfferRepository offerRepository;
	
	@Autowired
	ContractRepository contractRepository;
	
	@Autowired
	PersonRepository personRepository;
	
	private static final Logger L= LogManager.getLogger(ContractOfferServiceImpl.class);
	
	
	@Override
	public List<Offer> retrieveOffersByStartingDate(Date start) {
		List<Offer> offers= (List<Offer>) contractOfferRepository.findOfferByStartDate(start);
		for(Offer offer: offers){
			L.info("offer ++ =" + offer);
		}
		return offers;
	}

	@Override
	public List<Offer> retrieveOffersByExpiringDate(Date expire) {
		List<Offer> offers= (List<Offer>) contractOfferRepository.findOfferByExpiringDate(expire);
		for(Offer offer: offers){
			L.info("offer ++ =" + offer);
		}
		return offers;
	}

	@Override
	public List<Contract> retrieveContractsByOfferStatus(OfferStatus status) {
		List<Contract> contracts= (List<Contract>) contractOfferRepository.findContractByOfferStatus(status);
		for(Contract contract: contracts){
			L.info("contract ++ =" + contract);
		}
		return contracts;
	}
	
	@Override
	public List<Offer> findAllOffersByContract(Long idc) {
		List<Offer> offers = (List<Offer>) contractOfferRepository.findAllOffersByContract(idc);
		for(Offer offer: offers){
			L.info("offer ++ =" + offer);
		}
		return offers;
	}

	@Override
	public List<Contract> findAllContractsByOffer(Long ido) {
		List<Contract> contracts = (List<Contract>) contractOfferRepository.findAllContractsByOffer(ido);
		for(Contract contract: contracts){
			L.info("contract ++ =" + contract);
		}
		return contracts;
	}
	
	

	@Override
	public List<Contract> getContractsByOfferDate(Date startOffer, Date expireOffer) {
		List<Contract> contracts = (List<Contract>) contractOfferRepository.getContractByOfferDate(startOffer,expireOffer);
		for(Contract contract: contracts){
			L.info("contract ++ =" + contract);
		}
		return contracts;
	}

	@Override
	public int countActiveOffers() {
		return contractOfferRepository.countActiveOffers() ;
	}

	@Override
	public int countStoppedOffers() {
		return contractOfferRepository.countStoppedOffers() ;
	}

	@Override
	public void addContractOffer(Long idc, Long ido, Date startOffer, Date expireOffer, OfferStatus statusOffer) {
		ContractOfferPK contractOfferPK = new ContractOfferPK();
		contractOfferPK.setIdContract(idc);
		contractOfferPK.setIdOffer(ido);
		contractOfferPK.setStartOffer(startOffer);
		
		ContractOffer contractOffer = new ContractOffer();
		contractOffer.setContractOfferPK(contractOfferPK);
		contractOffer.setExpireOffer(expireOffer);
		contractOffer.setStatusOffer(statusOffer);	
		
		contractOfferRepository.save(contractOffer);	
	}
	
	@Override
	public ContractOffer getContractOfferPK(ContractOfferPK copk) {
		 return contractOfferRepository.findById(copk).get();		
	}
	@Override
	public String activateContactOffer(ContractOfferPK copk) {
		ContractOffer co= getContractOfferPK(copk);
		if (!co.getStatusOffer().equals(OfferStatus.Active))
		{   
			co.setStatusOffer(OfferStatus.Active);
			contractOfferRepository.save(co);
			return "activated";
		}
		else  return "already activated ";

	}

	@Override
	public String desactivateContractOffer(ContractOfferPK copk) {
		ContractOffer co = getContractOfferPK(copk);
		if (co.getStatusOffer().equals(OfferStatus.Active))
		{   
			co.setStatusOffer(OfferStatus.Stopped);
			contractOfferRepository.save(co);
			return "desactivated";
		}
		else 
			return "already desactivated ";
		
	}
	
	@Transactional
	@Override
	public List<Offer> ShowOffersHistory() {
		 List <Offer> expiredOffers = (List<Offer>) contractOfferRepository.getExpiredOffers();
		return expiredOffers;
	}

	

	
	

}
