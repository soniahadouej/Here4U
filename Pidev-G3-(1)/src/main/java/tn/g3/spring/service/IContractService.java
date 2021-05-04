package tn.g3.spring.service;

import java.util.List;

import tn.g3.spring.entity.Contract;

public interface IContractService {
	Contract retrieveContract(Long id);
	List<Long> findByIdPerson() ;
	public List<String> findByIdPerson2();
	public Long findIdContrat(float prime);
	public Long findIdContratByNom(String s);
}
