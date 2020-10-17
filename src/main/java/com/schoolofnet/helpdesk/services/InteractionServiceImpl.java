package com.schoolofnet.helpdesk.services;

import org.springframework.stereotype.Service;

import com.schoolofnet.helpdesk.models.Interaction;

@Service
public class InteractionServiceImpl implements InteractionService {

	@Override
	public Interaction create(Interaction interaction) {
		return null;
	}

	@Override
	public boolean delete(Long id) {
		return false;
	}

}
