package tn.g3.spring.repository; 
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
/*import org.springframework.data.repository.query.Param;*/
import org.springframework.stereotype.Repository;
import tn.g3.spring.entity.Offer;
import tn.g3.spring.entity.OfferType;

@Repository 
public interface OfferRepository extends JpaRepository<Offer, Long> {


	/**/@Query("select o FROM Offer o WHERE o.typeOffer= ?1")
	List<Offer> findByType(OfferType type);
	
	/*@Query("SELECT o FROM ContractOffer o WHERE cast(o.startOffer as string) like %:date%" )
	List<ContractOffer> findByStartDate( @Param("date") String start);
		
	@Query("SELECT o FROM ContractOffer o WHERE cast(o.expireOffer as string) like %:date% " )
	List<ContractOffer> findByExpiringDate( @Param("date") String expire);
	
	@Query("SELECT o FROM ContractOffer o WHERE o.statusOffer= ?1" )
	List<ContractOffer> findByStatus(OfferStatus status);*/
	
	@Query("SELECT o FROM Offer o WHERE o.nameOffer like  %?1% ")
	Offer findByName(String name);
	
	@Query("SELECT o FROM Offer o WHERE o.codeOffer like  %?1% ") 
	Offer findByCode(String code);

	@Query("select o FROM Offer o WHERE o.maxRedemption= ?1")
	List<Offer> findByMaxRed(Integer maxRed);
	
	
	/*@Query("select o from ContractOffer o where  o.contractOfferPK.idContract = ?1 ")  
	List<ContractOffer> findAllOffersByContract(ContractOfferPK coPK); 
	
	@Query("select c from ContractOffer c where  c.contractOfferPK.idOffer = ?1 ")  
	List<ContractOffer> findAllContractsByOffer(ContractOfferPK coPK); */

}
