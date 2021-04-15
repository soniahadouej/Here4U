package tn.g3.spring.service;

import java.util.List;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.g3.spring.entity.Contract;
import tn.g3.spring.entity.ProductType;
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
	
	
	@Override
	public float calculPrimefemme(float capital , int ageClient, int AgeMax, double taux){
		int k;
		float prime = 0;
		for (k =0; k < AgeMax - ageClient; k++) {
			float dxk= contractrepository.findByDecesDxFemme(ageClient+k); 	

			float lx = contractrepository.findBySurvivantsLxFemme(ageClient);
			double v = Math.pow( 1/ (1+taux) ,  k + (1/2)  );

			prime = (float) (capital * v) *  ( dxk / lx) ;

		}
		L.info("PRIME+++++++++ =" + prime) ;
		return prime;
	}
	
	@Override
	public float calculPrimeHomme(float capital , int ageClient, int AgeMax, double taux){
		int k;
		float prime = 0;
		for (k =0; k < AgeMax - ageClient; k++) {
			float dxk= contractrepository.findByDecesDxHomme(ageClient+k); 	

			float lx = contractrepository.findBySurvivantsLxHomme(ageClient);
			double v = Math.pow( 1/ (1+taux) ,  k + (1/2)  );

			prime = (float) (capital * v) *  ( dxk / lx) ;

		}
		L.info("PRIME+++++++++ =" + prime) ;
		return prime;
	}
	@Override
	public float calculPrimerentefemme(float rente , int ageClient, int nombreanne, double taux){
		int k;
		float prime = 0;
		for (k =0; k < nombreanne; k++) {
			float lxk= contractrepository.findBySurvivantsLxFemme(ageClient+k); 	

			float lx = contractrepository.findBySurvivantsLxFemme(ageClient);
			double v = Math.pow( 1/ (1+taux) ,  k + (1/2)  );

			prime = (float) (rente * v) *  ( lxk / lx) ;

		}
		L.info("PRIME+++++++++ =" + prime) ;
		return prime;
	}
	@Override
	public float calculPrimerentehomme(float rente , int ageClient, int nombreanne, double taux){
		int k;
		float prime = 0;
		for (k =0; k < nombreanne; k++) {
			float lxk= contractrepository.findBySurvivantsLxHomme(ageClient+k); 	

			float lx = contractrepository.findBySurvivantsLxHomme(ageClient);
			double v = Math.pow( 1/ (1+taux) ,  k + (1/2)  );

			prime = (float) (rente * v) *  ( lxk / lx) ;

		}
		L.info("PRIME+++++++++ =" + prime) ;
		return prime;
	}
	
	@Override
	public float calculPrimeAuto( float sinistre,ProductType p){
		float prime ;
		float fraicontract =0.04f;
		float k=contractrepository.getc(p);
		prime=(float) ((sinistre/k));
		return (prime+fraicontract*prime);
		
	}
	
}
