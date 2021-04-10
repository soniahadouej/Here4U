package tn.g3.spring.service;
import java.util.Date;
import java.util.List; 
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import tn.g3.spring.repository.ContractOfferRepository;
import tn.g3.spring.repository.OfferRepository;
import tn.g3.spring.entity.CivilStatus;
import tn.g3.spring.entity.Contract;
import tn.g3.spring.entity.ContractOffer;
import tn.g3.spring.entity.ContractOfferPK;
import tn.g3.spring.entity.Offer;
import tn.g3.spring.entity.OfferStatus;
import tn.g3.spring.entity.OfferType;
import tn.g3.spring.entity.ProductType;
import tn.g3.spring.entity.SinisterType;

@Service 
public class OfferServiceImpl implements OfferService {

	@Autowired
	OfferRepository offerRepository;
	
	@Autowired
	ContractOfferRepository contractOfferRepository;

	private static final Logger L= LogManager.getLogger(OfferServiceImpl.class);

	@Override
	public List<Offer> retrieveAllOffers() {
		List<Offer> offers= (List<Offer>) offerRepository.findAll();
		for(Offer offer: offers){
			L.info("offer ++ =" + offer);
		}
		return offers;
	}

	@Override
	public Offer addOffer(Offer o) {
		return offerRepository.save(o) ;
	}

	@Override
	public void deleteOffer(String id) {
		offerRepository.deleteById(Long.parseLong(id));
		
	}

	@Override
	public Offer updateOffer(Offer o) {
		return offerRepository.save(o) ;
	}

	@Override
	public Offer retrieveOffer(String id) {
		L.info("in retrieveOffer id =" + id);
		Offer o= offerRepository.findById(Long.parseLong(id)).get();
		L.info("offer returned =" + o);
		return o;
	}

	 
	@Override
	 /**/public List<Offer> retrieveOffersByType(OfferType type) {
		List<Offer> offers= (List<Offer>) offerRepository.findByType(type);
		for(Offer offer: offers){
			L.info("offer ++ =" + offer);
		}
		return offers;
	}
	
	/*@Override
	public List<ContractOffer> retrieveOffersByStartingDate(Date start) {
		List<ContractOffer> offers= (List<ContractOffer>) offerRepository.findByStartDate(start);
		for(ContractOffer offer: offers){
			L.info("offer ++ =" + offer);
		}
		return offers;
	}*/

	/*@Override
	public List<ContractOffer> retrieveOffersByExpiringDate(String expire) {
		List<ContractOffer> offers= (List<ContractOffer>) offerRepository.findByExpiringDate(expire);
		for(ContractOffer offer: offers){
			L.info("offer ++ =" + offer);
		}
		return offers;
	}*/

	@Override
	public List<ContractOffer> retrieveOffersByStatus(OfferStatus status) {
		List<ContractOffer> offers= (List<ContractOffer>) contractOfferRepository.findByStatus(status);
		for(ContractOffer offer: offers){
			L.info("offer ++ =" + offer);
		}
		return offers;
	}

	@Override
	public Offer retrieveOfferByName(String name) {
		L.info("in retrieveOffer name =" + name);
		Offer o= offerRepository.findByName(name);
		L.info("offer returned =" + o);
		return o;
	}

	@Override
	public Offer retrieveOfferByCode(String code) {
		L.info("in retrieveOffer code =" + code);
		Offer o= offerRepository.findByCode(code);
		L.info("offer returned =" + o);
		return o;
	}

	@Override
	public List<Offer> retrieveOffersByMaxRedemption(Integer maxRed) {
		List<Offer> offers= (List<Offer>) offerRepository.findByMaxRed(maxRed);
		for(Offer offer: offers){
			L.info("offer ++ =" + offer);
		}
		return offers;
		
	}

	@Override
	public List<ContractOffer> findAllOffersByContract(ContractOfferPK coPK) {
		List<ContractOffer> offers = (List<ContractOffer>) contractOfferRepository.findAllOffersByContract(coPK);
		for(ContractOffer offer: offers){
			L.info("offer ++ =" + offer);
		}
		return offers;
	}

	@Override
	public List<ContractOffer> findAllContractsByOffer(ContractOfferPK coPK) {
		List<ContractOffer> contracts = (List<ContractOffer>) contractOfferRepository.findAllContractsByOffer(coPK);
		for(ContractOffer contract: contracts){
			L.info("contract ++ =" + contract);
		}
		return contracts;
	}

	
	@Override
	public void applyOfferToContract(String ido, String idc) {
		Offer offer = offerRepository.findById(Long.parseLong(ido)).get();
		ContractOffer contract = contractOfferRepository.findById(Long.parseLong(idc)).get();
		if (!ObjectUtils.isEmpty(offer) && !ObjectUtils.isEmpty(contract))
		{
			contract.setOffer(offer);
			contractOfferRepository.save(contract);
		}
	}

	@Override
	public float calculateGift(Contract c, int age, CivilStatus category, float salary, Date startdate) {
		
		return 0;
	}

	@Override
	public float calculateDiscount(Contract c, Date startContract, int nbrSinistre, SinisterType typeSinistre,ProductType productType) {
		
		return 0;
	}

	@Override
	public float calculateLoyalty(Contract c,Date startContract, Date finishContract, int nbrPoints) {
		
		return 0;
	}

	}


