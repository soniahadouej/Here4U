package tn.g3.spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.g3.spring.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);

    
    Boolean existsByUsername(String username);
}

/*	@Query( "Select u from User u where u.firstname is not null")
	List<User>findByFirstnameNotNull();
	
	//recherche par role
	@Query("SELECT u From user u WHERE r.role =:role")
	List<User> retrieveUsersByRole(@Param("role") Role role);

	

	//recherche par nom
	@Query("Select u from User u where u.firstname like :name")
	List<User> findByFirstnameLike(String name);
	
	
	//recherche par email
	@Query("Select u from User u where u.email like :email")
	List<User>findByEmail(String email);

	

	@Query(value="SELECT count(*) from User")
	List<User> RetrieveAllUser(); 
	
	
	//recherche par desc
    @Query("select u from User u where u.description like  %?1% ORDER By description ASC ")
	 List<User> findByDescription(String desc); 
	
    //recherche par annÃ©e
		
	@Query("select u from User u where cast (c.dateOccurence as string) like %:date%")
    List<User> findByYear(@Param("date") String date);
		
	/*@Query("SELECT u From User u WHERE u.status =:Insured")
	List<User> findSinisterByRoleInsured();*/
