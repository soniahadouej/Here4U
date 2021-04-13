package tn.g3.spring.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.g3.spring.entity.Contract;
import tn.g3.spring.entity.Sinistre;
import tn.g3.spring.repository.ContractRepository;

@Transactional
@Service
public class ContractServiceImpl implements IContractService {

	@Autowired
	ContractRepository cr ;
	@Override
	public Contract retrieveContract(Long id) {

	 Contract c = cr.findById(id).get();
		return c;

	}
	
}
