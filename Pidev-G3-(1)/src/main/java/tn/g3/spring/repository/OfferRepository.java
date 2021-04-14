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
	
	@Query("SELECT o FROM Offer o WHERE o.nameOffer like  %?1% ")
	Offer findByName(String name);
	
	@Query("SELECT o FROM Offer o WHERE o.codeOffer like  %?1% ") 
	Offer findByCode(String code);

	@Query("select o FROM Offer o WHERE o.maxRedemption= ?1")
	List<Offer> findByMaxRed(Integer maxRed);
	

}
