package tn.g3.spring.repository;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.g3.spring.entity.Person;
import tn.g3.spring.entity.Sinistre;

@Repository
public interface SinistreRepository  extends JpaRepository<Sinistre, Long> {

	

	@Query("select count(s) from Sinistre s")
    Long getMax(); 
	
	/* ************************************************************************************************* */
	//recherche par desc
	@Query("select c from Sinistre c where c.description like  %?1% ORDER By description ASC ")
    List<Sinistre> findByDescription(String desc); //The @Query annotation contains the custom JPQL querty. 

	//recherche par année
	//named query : avec param
		@Query("select c from Sinistre c where cast (c.dateOccurence as string) like %:date%")
	    List<Sinistre> findByYear(@Param("date") String date);
	
	//recherche mixte
		//indexed query
		@Query("select c from Sinistre c where CONCAT (c.status ,c.description, c.dateOccurence, c.typeSinistre, c.motifStatus )like  %?1% ")
	    List<Sinistre> findByAny(String any); 


		//recherche par status en géneral
				@Query("select c from Sinistre c where c.status = ?1 ")
			    List<Sinistre> findByStatus(String status);

		 
		//recherche par sinistre en attente
		@Query("select c from Sinistre c where c.status = 'EnAttente' ")
	    List<Sinistre> findByStatusEnAttente();

		

		//recherche par sinistre rejeté
		@Query("select c from Sinistre c where c.status = 'Rejetée' ")
	    List<Sinistre> findByStatusRejetée();

		
		//JSF
		@Query("select c from Sinistre c where c.person = '2L'  ")
	    List<Sinistre> findAllByIdSin();

		
		
		//**************************************
		//UPDATE
		@Transactional
		@Modifying(clearAutomatically = true)
		@Query("UPDATE Sinistre s SET s.person=NULL WHERE s.idSinistre=?1")
		void updateidperson(Long id);
		
		
		
		//****************SELECT ALL SINISTRES OF A SPECEFIC USER
	/*	@Query("select c from Sinistre c where  c.user_id = ?1 ")   //@Query("select c from Sinistre c where  c.user.nomUser = ?1 ") 
		List<Sinistre> findAllUsers(Long idUser);                   // List<Sinistre> findAllUsersByName(String nom);  */
		
		
		//////////////////////////TABLE MORTALITe////////////////
		@Query("select lx_f from TableMortalité t where id_table = ?1 ") //LIMIT 1
		float findBySurvivantsLxFemme(int ageClient);

		@Query("select dx_f from TableMortalité t where id_table = ?1 ")
		float findByDecesDxFemme(int deces);
		
		@Query("select lx_h from TableMortalité t where id_table = ?1 ") //LIMIT 1
		float findBySurvivantsLxHomme(int ageClient);

		@Query("select dx_h from TableMortalité t where id_table = ?1 ")
		float findByDecesDxHomme(int deces);
		

		@Query(value = "select MAX(t.id_table) from TableMortalité t  " , nativeQuery = true)
		int findAgeMax();

		
		
		
		
		/* *********************************** */
			//recherche par type sinistre 
			/*	@Query("select c from Sinistre c where c.typeSinistre ='DécesVieEntiere' ")
			    Sinistre findByTypeSinistre();
				
				@Query("select c from Sinistre c where c.typeSinistre = ?1 ")
			    Sinistre findByTypeSinistre2(String ch);*/

		//id
				@Query("select c from Sinistre c where c.idSinistre = ?1 AND c.status = 'En_Cours' ")
			    Sinistre findByIdSin(Long id);
				
				@Query("select c.person from Sinistre c where c.person = ?1 ")
			    long findByIdPerson(Long idP);
				
				@Query("select c.idContract from Contract c where c.idContract = ?1 ")
			    long findByIdContrat(Long idP);
				

				/* ******************************** JOINTURE ************** */ 
				@Query("select c from Sinistre c  JOIN c.person p Join p.claim s where s.idClaim =:idd AND s.categoryClaim= 'Sinistre' ")
				List<Sinistre> findSinisterDescriptionwithUR(@Param("idd") Long id);
				//je selectionne les user ayant un sinistre et ayant fait une reclammation
				//nhot lid mtaa la reclammation ykharajlii la description du sinistre li aamlou 
				
				 
				// *******************DELETE

				@Query("select c.person from Sinistre c where c.idSinistre = ?1 ")
			    Person findByidperson2(long ch);
				
			/*	@Query( "select c.person from Sinistre c JOIN  p.idPerson  from Person p where p.idPerson=?1 "
						)
			    Person findByidperson3(long ch);*/
				
				
				//////////////////////////////////JSF
				@Query("select c.idContract from Contract c JOIN c.person u Join u.SinistreList l where l.idSinistre =:idd AND l.typeSinistre ='DécesVieEntiere' AND c.productType = 'VieEntiere'")
				Long findcontractidbysisnVIEENTIERE(@Param("idd") Long id2 );
				
				@Query("select c.premiumContract from Contract c JOIN c.person u Join u.SinistreList l where l.idSinistre =:idd AND l.typeSinistre ='DécesVieEntiere' AND c.productType = 'VieEntiere'")
				Long findprimebysisnVIEENTIERE(@Param("idd") Long id2 );
				
				@Query("select c.premiumContract from Contract c JOIN c.person u Join u.SinistreList l where l.idSinistre =:idd AND l.typeSinistre ='CapitalDeces' AND c.productType = 'CapitalDeces'")
				Long findcontractidbysisnCapDeces(@Param("idd") Long id2 );
				
				
				////////////////////////stat
				 @Query("Select count(*) from Sinistre s WHERE s.typeSinistre = 'DécesVieEntiere'")
					public int CountSinsVE();
				    @Query("Select count(*) from Sinistre s WHERE s.typeSinistre = 'CapitalDeces'")
					public int CountSinsCD();
				    @Query("Select count(*) from Sinistre s WHERE s.typeSinistre = 'RachatTotalVieEntiere'")
					public int CountSinsTDE();


}


