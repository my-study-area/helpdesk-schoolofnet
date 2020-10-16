package com.schoolofnet.helpdesk.services;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.schoolofnet.helpdesk.models.Role;
import com.schoolofnet.helpdesk.models.User;
import com.schoolofnet.helpdesk.repository.RolesRepository;
import com.schoolofnet.helpdesk.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private RolesRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder enconder;
	
	@Override
	public List<User> findAll() {
		return this.repository.findAll();
	}

	@Override
	public User create(User user) {
		user.setActive(true);
		user.setPassword(enconder.encode(user.getPassword()));
		
		Role userRole = this.roleRepository.findByName("USER");
		
		HashSet<Role> roles = new HashSet<>();
		roles.add(userRole);
		user.setRoles(roles);
		return this.repository.save(user);
	}

	@Override
	public boolean delete(Long id) {
		User user = findById(id);
		if (user == null) {
			return false;
		}
		this.repository.delete(user);
		return true;
	}

	private User findById(Long id) {
		return this.repository.findById(id).orElse(null);
	}

	@Override
	public boolean update(Long id, User user) {
		User userUpdated = findById(id);
		if (userUpdated != null) {
			userUpdated.setId(user.getId());
			userUpdated.setName(user.getName());
			userUpdated.setLastName(user.getLastName());
			userUpdated.setEmail(user.getEmail());
			userUpdated.setPassword(enconder.encode(user.getPassword()));
			userUpdated.setActive(user.getActive());
			
			String roleName = user.getRoles().iterator().next().getName();
			Role userRole = this.roleRepository.findByName(roleName);
			HashSet<Role> roles = new HashSet<>();
			roles.add(userRole);
			
			userUpdated.setRoles(roles);
			this.repository.save(userUpdated);
			return true;
		}
		return false;
	}
	
	@Override
	public List<User> findAllWhereRoleEquals(Long roleId, Long userId) {
		return this.repository.findAllWhereRoleEquals(roleId, userId);
	}

	@Override
	public User show(Long id) {
		return this.findById(id);
	}

	@Override
	public User findCurrentUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = auth.getName();
		return this.repository.findByEmail(userName);
	}

}
