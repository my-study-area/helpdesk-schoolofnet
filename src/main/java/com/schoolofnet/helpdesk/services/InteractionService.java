package com.schoolofnet.helpdesk.services;

import com.schoolofnet.helpdesk.models.Interaction;

public interface InteractionService {
	public Interaction create(Interaction interaction, Long ticketId);
	public boolean delete(Long id, Long ticketId);
}
