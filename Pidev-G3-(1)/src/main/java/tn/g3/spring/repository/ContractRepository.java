package tn.g3.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.g3.spring.entity.Contract;

@Repository
public interface ContractRepository extends CrudRepository<Contract,Long> {

	@Query("select c.premiumContract from Contract c where c.person = '2L' ")
	List<Long> findByIdPerson();

	@Query("select c.NomContract from Contract c where c.person = '2L' ")
	List<String> findByIdPerson2();

	@Query("select c.idContract from Contract c where c.premiumContract = ?1 ")
	long findIdContrat(float prime);
	
	@Query("select c.idContract from Contract c where c.NomContract = ?1 ")
	long findIdContratbyNom(String nom);
}
