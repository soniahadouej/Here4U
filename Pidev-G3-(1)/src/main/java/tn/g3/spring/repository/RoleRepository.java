package tn.g3.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.g3.spring.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
