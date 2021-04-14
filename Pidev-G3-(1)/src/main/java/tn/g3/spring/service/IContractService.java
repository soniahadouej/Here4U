package tn.g3.spring.service;
import java.util.List;
import tn.g3.spring.entity.Contract;

public interface IContractService {
	
	List<Contract> retrieveAllContracts();
	Contract addContract(Contract c);
	void deleteContract(String id);
	Contract updateContract(Contract c);
	Contract retrieveContract(String id);
}