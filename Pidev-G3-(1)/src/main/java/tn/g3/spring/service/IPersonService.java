package tn.g3.spring.service;

import java.util.List;
import tn.g3.spring.entity.Person;


public interface IPersonService {
	
	List<Person> retrieveAllPersons();
	Person addPerson(Person p);
	void deletePerson(String idp);
	Person updatePerson(Person p);
	Person retrievePerson(String idp);
	Person authenticate(String email, String password);
	List<Person> getAllAgents();

	

}
