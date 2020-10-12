package com.schoolofnet.helpdesk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.schoolofnet.helpdesk.models.User;

public interface UserRepository extends JpaRepository<User, Long>{

	
	@Query(value= "select u.* from users u inner join users_roles ur on u.id = ur.user_id where ur.role_id = :roleId and u.id not in (:userId)", nativeQuery = true)
	public List<User> findAllWhereRoleEquals (@Param("roleId") Long roleId, @Param("userId") Long userId);

	public User findByEmail(String email);
}
