package tn.g3.spring.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tn.g3.spring.entity.Role;
import tn.g3.spring.entity.User;
import tn.g3.spring.repository.UserRepository;
@Service
public class UserServiceImpl implements IUserService { 
	
	@Autowired
	UserRepository userRepository;
	
	private static final Logger L= LogManager.getLogger(UserServiceImpl.class);
	
	@Override
	public List<User> RetrieveAllUsers(){
		List<User>users= ( List <User>) userRepository.findAll();
	
		for (User user : users){
			L.info("user +++ :" + user);
		} 
		return users;
	}
	@Override
	public User AddUser(User u) {
		User us = userRepository.save(u);
		return us;
	}
	
	
	@Override
	public void DeleteUser(String id) {
	userRepository.deleteById(Long.parseLong(id));
	}


	@Override
	public User UpdateUser(User u) {
		// TODO Auto-generated method stub
		User UserUpdated = userRepository.save(u);
		return UserUpdated;
	
	}

	@Override
	public User RetrieveUser(String id) {
		L.info("in RetrieveUser id = " + id);
		User u = userRepository.findById(Long.parseLong(id)).get();
		L.info("Usert returned = : " + u);
		return u;	
	}
	@Override
	public Optional<User> findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}	
	
}