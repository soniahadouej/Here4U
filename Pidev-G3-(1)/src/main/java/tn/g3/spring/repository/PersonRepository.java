package tn.g3.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.g3.spring.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
