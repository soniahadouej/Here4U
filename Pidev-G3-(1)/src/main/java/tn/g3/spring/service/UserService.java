package tn.g3.spring.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.g3.spring.entity.User;
import tn.g3.spring.repository.UserRepository;


@Service
public class UserService implements IUserService{
	@Autowired
	UserRepository ur;
	private static final Logger L = LogManager.getLogger(UserService.class);
	@Override
	public List<User> retrieveAllusers() {
		List<User> users = (List<User>)ur.findAll();
		for (User u:users){
			L.info("contract +++ : "+u);
		}
		return users;
	}
	@Override
	public User addUser(User u) {
		User usersaved=null;
		usersaved =ur.save(u);
		return usersaved;
	}

	@Override
	public void deleteUser(String id) {
		ur.deleteById(Long.parseLong(id));
		
	}

	@Override
	public User updateUser(User u) {
		User useradded =ur.save(u);
		return useradded ;
	}
	@Override
	public User retrieveUser(String id){
		User u = ur.findById(Long.parseLong(id)).orElse(null);
		return u;
		
	}
	@Override
	public User authenticate(String login, String password) {
	return ur.getUserByEmailAndPassword(login, password);
	}
	


}
