package com.schoolofnet.helpdesk.services;

import java.util.List;

import com.schoolofnet.helpdesk.models.Ticket;
import com.schoolofnet.helpdesk.models.User;

public interface TicketService {
	public List<Ticket> findAll();
	public User create(Ticket ticket);
	public boolean delete(Long id);
	public boolean update(Long id, Ticket ticket);
	public User show(Long id);
}
