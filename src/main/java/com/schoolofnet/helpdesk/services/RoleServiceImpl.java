package com.schoolofnet.helpdesk.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolofnet.helpdesk.RolesRepository;
import com.schoolofnet.helpdesk.models.Role;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RolesRepository repository;

	@Override
	public List<Role> findAll() {
		return null;
	}

	@Override
	public Role create(Role role) {
		return this.repository.save(role);
	}
	
}
