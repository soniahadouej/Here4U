package tn.g3.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.g3.spring.entity.Provision;
@Repository
public interface ProvisionRepository  extends CrudRepository<Provision, Long>  {

}
