package tn.g3.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import tn.g3.spring.entity.Claim;
import tn.g3.spring.entity.ClaimType;

public interface ClaimRepository extends CrudRepository <Claim,Long> {
	
	List<Claim> findBystatusClaim (boolean statusClaim);
	List<Claim> findBycategoryClaim (ClaimType categoryClaim);

}
