package tn.g3.spring.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.g3.spring.entity.ContractOffer;
import tn.g3.spring.entity.ContractOfferPK;
import tn.g3.spring.entity.OfferStatus;

@Repository
public interface ContractOfferRepository extends JpaRepository<ContractOffer, Long> {
	
	/*@Query("SELECT o FROM ContractOffer o WHERE cast(o.startOffer as string) like %:date%" )
	List<ContractOffer> findByStartDate( @Param("date") String start);
		
	@Query("SELECT o FROM ContractOffer o WHERE cast(o.expireOffer as string) like %:date% " )
	List<ContractOffer> findByExpiringDate( @Param("date") String expire);*/
	
	@Query("SELECT co FROM ContractOffer co WHERE co.statusOffer= ?1" )
	List<ContractOffer> findByStatus(OfferStatus status);
	
	@Query("select co from ContractOffer co where  co.contractOfferPK.idContract = ?1 ")  
	List<ContractOffer> findAllOffersByContract(ContractOfferPK coPK); 
	
	@Query("select co from ContractOffer co where  co.contractOfferPK.idOffer = ?1 ")  
	List<ContractOffer> findAllContractsByOffer(ContractOfferPK coPK); 
}
