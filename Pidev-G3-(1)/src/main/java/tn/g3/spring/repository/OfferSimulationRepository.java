package tn.g3.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.g3.spring.entity.Offer;
import tn.g3.spring.entity.Product;
import tn.g3.spring.entity.Client;

@Repository
public interface OfferSimulationRepository extends JpaRepository<Offer, Long> {


	@Query (value="SELECT client_id_person  fROM contract c JOIN person p on c.client_id_person = p.id_person WHERE c.id_contract= :contract_id ", nativeQuery=true)
	Client getClientFromContract( @Param("contract_id") Long idc);

	@Query(value="SELECT product_id_product as product_id_product FROM Contract c JOIN Product p on c.product_id_product= p.id_product WHERE c.id_contract= :contract_id", nativeQuery=true)
	Product getProductFromContract(@Param("contract_id") Long idc);  

	@Query(value = "SELECT count(*) FROM Contract c WHERE c.client_id_person=:client_id ",nativeQuery=true)
	public int countClientContracts(@Param("client_id")Long idcl);   

	@Query(value = "SELECT count(*) FROM `Sinistre` s WHERE s.client_id_person=:client_id ",nativeQuery=true)
	public int countClientSinistres(@Param("client_id")Long idcl); 

}