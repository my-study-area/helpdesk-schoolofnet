package com.schoolofnet.helpdesk.services;

import java.util.List;

import com.schoolofnet.helpdesk.models.User;

public interface UserService {
	public List<User> findAll();
	public User create(User user);
	public boolean delete(Long id);
	public boolean update(Long id, User user);
	public User show(Long id);
	public List<User> findAllWhereRoleEquals(Long roleId, Long userId);
	public User findCurrentUser();
}
