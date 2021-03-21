package tn.g3.spring.service;

import java.util.List;  

import tn.g3.spring.entity.Provision;

public interface IProvisionSerivce {


		 List<Provision> retrieveAllProvision(); 
		 Provision addProvision(Provision p);
		 void deleteProvision(String id);
		 Provision updateProvision(Provision p);
		 Provision retrieveProvision(String id);
	}



