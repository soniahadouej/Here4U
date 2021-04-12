package tn.g3.spring.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.g3.spring.entity.Contract;

@Repository
public interface ContractRepository extends CrudRepository<Contract, Long>{

}
