package tn.g3.spring.service;

import java.util.List;
import java.util.Optional;

import tn.g3.spring.entity.Role;
import tn.g3.spring.entity.User;

public interface IUserService {
	List<User> RetrieveAllUsers(); 
	
	 User AddUser(User u);
	 void DeleteUser(String id);
	 User UpdateUser(User u);
	 User RetrieveUser(String id);

	Optional<User> findByUsername(String username);
}
