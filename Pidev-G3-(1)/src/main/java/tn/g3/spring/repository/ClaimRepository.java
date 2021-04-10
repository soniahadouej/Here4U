package tn.g3.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.g3.spring.entity.Claim;

@Repository
public interface ClaimRepository extends CrudRepository<Claim, Long> {
	

}
