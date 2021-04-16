package tn.g3.spring.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.g3.spring.entity.Sinistre;
import tn.g3.spring.repository.SinistreRepository;

@Service
public class SinisterServiceImpl implements ISinistreService {

	@Autowired
	SinistreRepository snrepository;
	private static final Logger L = LogManager.getLogger(SinisterServiceImpl.class);
	@Override
	public List<Sinistre> retrieveAllSinistres() {
		List<Sinistre> sinisters = (List<Sinistre>)snrepository.findAll();
		for (Sinistre sinister:sinisters){
			L.info("sinister +++ : "+sinister);
		}
		return sinisters;
	}
	@Override
	public Sinistre addSinistre(Sinistre s) {
		Sinistre sinistersaved=null;
		sinistersaved =snrepository.save(s);
		return sinistersaved;
	}
	@Override
	public void deleteSinistre(String id) {
		snrepository.deleteById(Long.parseLong(id));
		
	}
	@Override
	public Sinistre updateSinistre(Sinistre s) {
		Sinistre sinisteradded =snrepository.save(s);
		return sinisteradded ;
	}
	@Override
	public Sinistre retrieveSinistre(String id) {
		Sinistre s = snrepository.findById(Long.parseLong(id)).orElse(null);
		return s;
	}
}

	