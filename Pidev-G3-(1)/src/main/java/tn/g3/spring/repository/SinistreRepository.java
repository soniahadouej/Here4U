package tn.g3.spring.repository;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.g3.spring.entity.Sinistre;

@Repository
public interface SinistreRepository  extends CrudRepository<Sinistre, Long> {

	

	@Query("select count(s) from Sinistre s")
    Long getMax(); 
	
	
	//recherche par desc
	@Query("select c from Sinistre c where c.description like  %?1% ORDER By description ASC ")
    List<Sinistre> findByDescription(String desc); //The @Query annotation contains the custom JPQL querty. 

	//recherche par année
	//named query : avec param
		@Query("select c from Sinistre c where cast (c.dateOccurence as string) like %:date%")
	    List<Sinistre> findByYear(@Param("date") String date);
	
	//recherche mixte
		//indexed query
		@Query("select c from Sinistre c where CONCAT (c.status ,c.description, c.dateOccurence )like  %?1% ")
	    List<Sinistre> findByAny(String any); 


		//recherche par sinistre en attente
		@Query("select c from Sinistre c where c.status = 'EnAttente' ")
	    List<Sinistre> findByStatusEnAttente();

		

		//recherche par sinistre rejeté
		@Query("select c from Sinistre c where c.status = 'Rejetée' ")
	    List<Sinistre> findByStatusRejetée();

		
		
		//**************************************
		//UPDATE
		@Transactional
		@Modifying(clearAutomatically = true)
		@Query("UPDATE Sinistre s SET s.description=?2 WHERE s.idSinistre=?1")
		void updateStatus (Long id, String newStatus );
		
		
		
		//****************SELECT ALL SINISTRES OF A SPECEFIC USER
	/*	@Query("select c from Sinistre c where  c.user_id = ?1 ")   //@Query("select c from Sinistre c where  c.user.nomUser = ?1 ") 
		List<Sinistre> findAllUsers(Long idUser);                   // List<Sinistre> findAllUsersByName(String nom);  */
		
}
