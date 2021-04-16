package tn.g3.spring.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import tn.g3.spring.annotation.CurrentUser;
import tn.g3.spring.entity.CustomUserDetails;
import tn.g3.spring.entity.Role;
import tn.g3.spring.entity.User;
import tn.g3.spring.entity.UserDevice;
import tn.g3.spring.entity.payload.LogOutRequest;
import tn.g3.spring.entity.payload.RegistrationRequest;
import tn.g3.spring.exception.UserLogoutException;
import tn.g3.spring.repository.UserRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class UserService {



	private static final Logger L = Logger.getLogger(UserService.class);

	private final PasswordEncoder passwordEncoder;
	private final UserRepository userRepository;
	private final RoleService roleService;
	private final UserDeviceService userDeviceService;
	private final RefreshTokenService refreshTokenService;

	@Autowired
	public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository, RoleService roleService, UserDeviceService userDeviceService, RefreshTokenService refreshTokenService) {
		this.passwordEncoder = passwordEncoder;
		this.userRepository = userRepository;
		this.roleService = roleService;
		this.userDeviceService = userDeviceService;
		this.refreshTokenService = refreshTokenService;
	}
	/////////////////////////////////////////CRUD//////////////////////////////////////////////////////////
	/*Retrieve all User*/
	public List<User> RetrieveAllUsers(){
		List<User>users= ( List <User>) userRepository.findAll();

		for (User user : users){
			L.info("user +++ :" + user);
		} 
		return users;
	}
	/*Create user*/
	public User AddUser(User u) {
		User us = userRepository.save(u);
		return us;
	}

	/*Delete User*/
	public void DeleteUser(String id) {
		userRepository.deleteById(Long.parseLong(id));
	}

	/*Update User*/
	public User UpdateUser(User u) {
		// TODO Auto-generated method stub
		User UserUpdated = userRepository.save(u);
		return UserUpdated;

	}
	/**/

	public User RetrieveUser(String id) {
		L.info("in RetrieveUser id = " + id);
		User u = userRepository.findById(Long.parseLong(id)).get();
		L.info("Usert returned = : " + u);
		return u;	
	}

	/////////////////////////

	/**
	 * Finds a user in the database by username
	 */  Optional<User> findByUsername(String username) {
		 return userRepository.findByUsername(username);
	 }

	 /**
	  * Finds a user in the database by email
	  */
	 public Optional<User> findByEmail(String email) {
		 return userRepository.findByEmail(email);
	 }

	 /**
	  * Find a user in db by id.
	  */
	 public Optional<User> findById(Long Id) {
		 return userRepository.findById(Id);
	 }

	 /**
	  * Save the user to the database
	  */
	 public User save(User user) {
		 return userRepository.save(user);
	 }

	 /**
	  * Check is the user exists given the email: naturalId
	  */
	 public Boolean existsByEmail(String email) {
		 return userRepository.existsByEmail(email);
	 }

	 /**
	  * Check is the user exists given the username: naturalId
	  */
	 public Boolean existsByUsername(String username) {
		 return userRepository.existsByUsername(username);
	 }


	 /**
	  * Creates a new user from the registration request
	  */
	 public User createUser(RegistrationRequest registerRequest) {
		 User newUser = new User();
		 Boolean isNewUserAsAdmin = registerRequest.getRegisterAsAdmin();
		 newUser.setEmail(registerRequest.getEmail());
		 newUser.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
		 newUser.setUsername(registerRequest.getEmail());
		 newUser.addRoles(getRolesForNewUser(isNewUserAsAdmin));
		 newUser.setActive(true);
		 newUser.setEmailVerified(false);
		 return newUser;
	 }

	 /**
	  * Performs a quick check to see what roles the new user could be assigned to.
	  *
	  * @return list of roles for the new user
	  */
	 private Set<Role> getRolesForNewUser(Boolean isToBeMadeAdmin) {
		 Set<Role> newUserRoles = new HashSet<>(roleService.findAll());
		 if (!isToBeMadeAdmin) {
			 newUserRoles.removeIf(Role::isAdminRole);
		 }
		 L.info("Setting user roles: " + newUserRoles);
		 return newUserRoles;
	 }
	    /**
	     * Log the given user out and delete the refresh token associated with it. If no device id is found matching the database for the given user, throw a log out exception.
	     */
	    public void logoutUser(@CurrentUser CustomUserDetails currentUser, LogOutRequest logOutRequest) {
	        String deviceId = logOutRequest.getDeviceInfo().getDeviceId();
	        UserDevice userDevice = userDeviceService.findByUserId(currentUser.getId())
	                .filter(device -> device.getDeviceId().equals(deviceId))
	                .orElseThrow(() -> new UserLogoutException(logOutRequest.getDeviceInfo().getDeviceId(), "Invalid device Id supplied. No matching device found for the given user "));

	        L.info("Removing refresh token associated with device [" + userDevice + "]");
	        refreshTokenService.deleteById(userDevice.getRefreshToken().getId());
	    }
}