package tn.g3.spring.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.g3.spring.entity.Role;
import tn.g3.spring.repository.RoleRepository;

import java.util.Collection;
@Service
public class RoleService {

	private final RoleRepository roleRepository;

	@Autowired

	public RoleService(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	/**
	 * Find all roles from the database
	 */
	public Collection<Role> findAll() {
		return roleRepository.findAll();
	}

}
