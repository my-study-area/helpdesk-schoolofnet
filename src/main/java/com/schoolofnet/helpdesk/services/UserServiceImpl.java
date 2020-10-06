package com.schoolofnet.helpdesk.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.schoolofnet.helpdesk.models.User;
import com.schoolofnet.helpdesk.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;
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
			this.repository.save(userUpdated);
			return true;
		}
		return false;
	}

	@Override
	public User show(Long id) {
		return this.findById(id);
	}

}
