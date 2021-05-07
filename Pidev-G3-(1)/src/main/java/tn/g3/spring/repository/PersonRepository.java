package tn.g3.spring.repository;

import java.util.List; 

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

 
import tn.g3.spring.entity.Person;
@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{


	//recherche par id
	@Query("select p from Person p where p.idPerson ='2L'")
	Person findByIdPerson();

	@Query("select p.salary from Person p where p.idPerson =?1")
	  float findBySalary(Long id);
	
	
	public Person getPersonByEmailAndPassword(String login, String password) ;


	 
}