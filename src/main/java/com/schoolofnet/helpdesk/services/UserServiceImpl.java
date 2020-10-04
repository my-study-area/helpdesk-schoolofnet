package com.schoolofnet.helpdesk.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolofnet.helpdesk.models.User;
import com.schoolofnet.helpdesk.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;
	
	@Override
	public List<User> findAll() {
		return null;
	}

	@Override
	public User create(User user) {
		user.setActive(true);
		return this.repository.save(user);
	}

	@Override
	public boolean delete(Long id) {
		return false;
	}

	@Override
	public boolean update(Long id) {
		return false;
	}

}
