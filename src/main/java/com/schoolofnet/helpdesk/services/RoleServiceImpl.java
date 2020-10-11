package com.schoolofnet.helpdesk.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolofnet.helpdesk.models.Role;
import com.schoolofnet.helpdesk.repository.RolesRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RolesRepository repository;

	@Override
	public List<Role> findAll() {
		return repository.findAll();
	}

	@Override
	public Role create(Role role) {
		return this.repository.save(role);
	}

	@Override
	public boolean delete(Long id) {
		Role role = findById(id);
		if (role == null) {
			return false;
		}
		this.repository.delete(role);
		return true;
	}


	@Override
	public Role findByName(String name) {
		return this.repository.findByName(name);
	}

	private Role findById(Long id) {
		 return this.repository.findById(id).orElse(null);
	}
	
}
