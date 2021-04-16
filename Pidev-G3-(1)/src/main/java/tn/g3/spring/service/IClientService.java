package tn.g3.spring.service;

import java.util.List;

import tn.g3.spring.entity.Client;

public interface IClientService {
	
	List<Client> retrieveAllPersons();
	Client addPerson(Client p);
	void deletePerson(String idp);
	Client updatePerson(Client p);
	Client retrievePerson(String idp);

}
