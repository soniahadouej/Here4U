package tn.g3.spring.service;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.g3.spring.entity.Contract;
import tn.g3.spring.repository.ContractRepository;

@Service
public class ContractService implements IContractService{
	@Autowired
	ContractRepository contractrepository;
	private static final Logger L = LogManager.getLogger(ContractService.class);

	@Override
	public List<Contract> retrieveAllContracts() {
		List<Contract> contracts = (List<Contract>)contractrepository.findAll();
		for (Contract contract:contracts){
			L.info("contract +++ : "+contract);
		}
		return contracts;
	}
	@Override
	public Contract addContract(Contract c) {
		Contract contractsaved=null;
		contractsaved =contractrepository.save(c);
		return contractsaved;
	}

	@Override
	public void deleteContract(String id) {
		contractrepository.deleteById(Long.parseLong(id));
		
	}

	@Override
	public Contract updateContract(Contract c) {
		Contract contractadded =contractrepository.save(c);
		return contractadded ;
	}
	@Override
	public Contract retrieveContract(String id){
		Contract c = contractrepository.findById(Long.parseLong(id)).orElse(null);
		return c;
		
	}

}