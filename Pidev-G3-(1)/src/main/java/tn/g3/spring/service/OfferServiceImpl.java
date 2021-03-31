package tn.g3.spring.service;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.g3.spring.repository.OfferRepository;
import tn.g3.spring.entity.Offer;

@Service
public class OfferServiceImpl implements OfferService {

	@Autowired
	OfferRepository offerRepository;

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
		L.info("in retrieveUser id =" + id);
		Offer o= offerRepository.findById(Long.parseLong(id)).get();
		L.info("offer returned =" + o);
		return o;
	}

}
