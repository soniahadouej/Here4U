package tn.g3.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.g3.spring.entity.Contract;

public interface ContractRepository extends CrudRepository<Contract,Long> {



}
