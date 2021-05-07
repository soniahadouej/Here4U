package tn.g3.spring.service;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.g3.spring.entity.Person;
import tn.g3.spring.repository.PersonRepository;

@Service
public class PersonServiceImpl implements IPersonService {
	@Autowired
	PersonRepository personrepository;
	private static final Logger L = LogManager.getLogger(PersonServiceImpl.class);

	@Override
	public List<Person> retrieveAllPersons() {
		List<Person> persons = (List<Person>) personrepository.findAll();
		for (Person person:persons){
			L.info("person +++ : "+person);
		}
		return persons;
	}
	@Override
	public Person addPerson(Person p) {
		Person personsaved=null;
		personsaved =personrepository.save(p);
		return personsaved;
	}

	@Override
	public void deletePerson(String id) {
		personrepository.deleteById(Long.parseLong(id));
		
	}

	@Override
	public Person updatePerson(Person p) {
		Person personadded =personrepository.save(p);
		return personadded ;
	}
	@Override
	public Person retrievePerson(String id){
		Person p = personrepository.findById(Long.parseLong(id)).orElse(null);
		return p;
		
	}
	@Override
	public Person authenticate(String email, String password) {
	return personrepository.getPersonByEmailAndPassword(email, password);

	}
	@Override
	public List<Person> getAllAgents() {
		List<Person> agents = (List<Person>) personrepository.findByPersonType();
		for (Person person:agents){
			L.info("person +++ : "+person);
		}
		return agents;
		
	}
	

}
