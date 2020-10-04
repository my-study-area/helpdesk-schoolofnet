package com.schoolofnet.helpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schoolofnet.helpdesk.models.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
