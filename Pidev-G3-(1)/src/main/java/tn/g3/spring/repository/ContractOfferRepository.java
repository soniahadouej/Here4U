package tn.g3.spring.repository;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.g3.spring.entity.Contract;
import tn.g3.spring.entity.ContractOffer;
import tn.g3.spring.entity.ContractOfferPK;
import tn.g3.spring.entity.Offer;
import tn.g3.spring.entity.OfferStatus;

@Repository
public interface ContractOfferRepository extends JpaRepository<ContractOffer, ContractOfferPK > {
	
	@Query("select DISTINCT o from Offer o join o.contractOffers co join co.contract c where c.idContract= ?1 ")
	public List<Offer> findAllOffersByContract(Long idc);
	
	@Query("select DISTINCT c from Contract c join c.contractOffers co join co.offer o where o.idOffer= ?1")
    public List<Contract> findAllContractsByOffer(Long ido);
	
	@Query("SELECT c FROM Contract c join c.contractOffers co WHERE co.statusOffer= ?1" )
	public List<Contract> findContractByOfferStatus(OfferStatus status);
	
	@Query("Select c from Contract c join c.contractOffers co where co.contractOfferPK.startOffer>=:start and co.expireOffer<=:finish ")
	public List<Contract> getContractByOfferDate(@Param("start") Date startOffer,@Param("finish")Date expireOffer);

	@Query("SELECT o FROM Offer o join o.contractOffers co WHERE co.contractOfferPK.startOffer = ?1" )
	public List<Offer> findOfferByStartDate( Date startOffer);
		
	@Query("SELECT o FROM Offer o join o.contractOffers co WHERE co.expireOffer = ?1" )
	public List<Offer> findOfferByExpiringDate( Date expireOffer);
	
	@Query("SELECT count(*) FROM Offer o join o.contractOffers co where co.statusOffer= 'Active' ")
    public int countActiveOffers();

	@Query("SELECT count(*) FROM Offer o join o.contractOffers co where co.statusOffer= 'Stopped' ")
	public int countStoppedOffers();

	@Query("SELECT o FROM Offer o join o.contractOffers co where co.statusOffer= 'Expired' ")
	public List<Offer> getExpiredOffers();
	
	
}
