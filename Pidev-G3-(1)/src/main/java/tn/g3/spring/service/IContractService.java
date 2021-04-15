package tn.g3.spring.service;

import java.util.List;

import tn.g3.spring.entity.Contract;
import tn.g3.spring.entity.ProductType;

public interface IContractService {
	List<Contract> retrieveAllContracts();
	Contract addContract(Contract c);
	 void deleteContract(String id);
	 Contract updateContract(Contract c);
	 Contract retrieveContract(String id);
	 float calculPrimefemme(float capital , int ageClient, int AgeMax, double taux);
	 float calculPrimeHomme(float capital , int ageClient, int AgeMax, double taux);
	 float calculPrimerentefemme(float rente , int ageClient, int nombreanne, double taux);
	 float calculPrimerentehomme(float rente , int ageClient, int nombreanne, double taux);
	 float calculPrimeAuto(float sinistre,ProductType p);
}
