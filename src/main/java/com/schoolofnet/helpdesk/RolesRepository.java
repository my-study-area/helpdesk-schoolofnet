package com.schoolofnet.helpdesk;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolofnet.helpdesk.models.Role;

@Repository
public interface RolesRepository extends JpaRepository<Role, Long>{

}
