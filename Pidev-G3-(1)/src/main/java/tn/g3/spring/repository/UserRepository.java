package tn.g3.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.g3.spring.entity.User;

public interface UserRepository extends CrudRepository<User,Long>{
	public User getUserByEmailAndPassword(String login, String password);
}
