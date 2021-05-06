package tn.g3.spring.service;

import java.util.List;

import tn.g3.spring.entity.User;

public interface IUserService {

	List<User> retrieveAllusers();

	User addUser(User u);

	User retrieveUser(String id);

	User updateUser(User u);

	void deleteUser(String id);

	User authenticate(String login, String password);

}
