package tn.g3.spring.repository;




import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import tn.g3.spring.entity.Contract;
import tn.g3.spring.entity.ProductType;


@Repository
public interface ContractRepository extends CrudRepository<Contract, Long>{
	@Query("select lx_f from TableMortalité ") //LIMIT 1
	float findBySurvivantsLxFemme(int ageClient);

	@Query("select dx_f from TableMortalité ")
	float findByDecesDxFemme(int deces);
	
	@Query("select lx_h from TableMortalité  ") //LIMIT 1
	float findBySurvivantsLxHomme(int ageClient);

	@Query("select dx_h from TableMortalité  ")
	float findByDecesDxHomme(int deces);
	
	@Query("SELECT COUNT(*) FROM Contract c WHERE c.productType=:productType ")
	float getc(@Param("productType")ProductType productType);


	
}
