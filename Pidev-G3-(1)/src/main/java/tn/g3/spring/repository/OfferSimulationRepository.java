package tn.g3.spring.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.g3.spring.entity.CivilStatus;
import tn.g3.spring.entity.Offer;
import tn.g3.spring.entity.ProductType;

@Repository
public interface OfferSimulationRepository extends JpaRepository<Offer, Long> {


	@Query (value="SELECT client_id_person  fROM contract c JOIN person p on c.client_id_person = p.id_person WHERE c.id_contract= :contract_id ", nativeQuery=true)
	Long getClientIdFromContract( @Param("contract_id") Long idc);
	
	@Query (value="SELECT age  fROM person p JOIN contract c on c.client_id_person = p.id_person WHERE c.id_contract= :contract_id ", nativeQuery=true)
	int getClientAgeFromContract( @Param("contract_id") Long idc);

	@Query(value="SELECT type FROM product p JOIN Contract c on c.product_id_product= p.id_product WHERE c.id_contract= :contract_id", nativeQuery=true)
	ProductType getProductCategoryFromContract(@Param("contract_id") Long idc);  

	@Query(value = "SELECT count(*) FROM contract c WHERE c.client_id_person=:client_id ",nativeQuery=true)
	public int countClientContracts(@Param("client_id")Long idcl);   

	@Query(value = "SELECT count(*) FROM sinistre s WHERE s.client_id_person=:client_id ",nativeQuery=true)
	public int countClientSinistres(@Param("client_id")Long idcl);

	@Query(value="SELECT civil_status FROM person p JOIN Contract c on c.client_id_person= p.id_person WHERE c.id_contract= :contract_id", nativeQuery=true)
	CivilStatus getClientCategoryFromContract(@Param("contract_id")Long idc);

	@Query (value="SELECT start fROM person p JOIN contract c on c.client_id_person = p.id_person WHERE c.id_contract= :contract_id ", nativeQuery=true)
	Date getStartDateClientFromContract(@Param("contract_id")Long idc);
	

}