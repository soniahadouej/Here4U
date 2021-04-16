package tn.g3.spring.service;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.g3.spring.entity.Client;
import tn.g3.spring.repository.ClientRepository;

@Service
public class PersonServiceImpl implements IClientService {
	@Autowired
	ClientRepository personrepository;
	private static final Logger L = LogManager.getLogger(PersonServiceImpl.class);

	@Override
	public List<Client> retrieveAllPersons() {
		List<Client> persons = (List<Client>) personrepository.findAll();
		for (Client person:persons){
			L.info("person +++ : "+person);
		}
		return persons;
	}
	@Override
	public Client addPerson(Client p) {
		Client personsaved=null;
		personsaved =personrepository.save(p);
		return personsaved;
	}

	@Override
	public void deletePerson(String id) {
		personrepository.deleteById(Long.parseLong(id));
		
	}

	@Override
	public Client updatePerson(Client p) {
		Client personadded =personrepository.save(p);
		return personadded ;
	}
	@Override
	public Client retrievePerson(String id){
		Client p = personrepository.findById(Long.parseLong(id)).orElse(null);
		return p;
		
	}

}
