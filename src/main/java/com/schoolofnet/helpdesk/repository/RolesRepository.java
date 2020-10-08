package com.schoolofnet.helpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolofnet.helpdesk.models.Role;

@Repository
public interface RolesRepository extends JpaRepository<Role, Long>{
	Role findByName(String name);
}
