package tn.g3.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.g3.spring.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

	Person getPersonByEmailAndPassword(String email, String password);

	@Query (value="SELECT * FROM `person` WHERE `type` LIKE 'Client'", nativeQuery=true)
	List<Person> findByPersonType();
	

	
}
