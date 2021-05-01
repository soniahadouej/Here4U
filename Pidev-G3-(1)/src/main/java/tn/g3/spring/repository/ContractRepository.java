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


}
