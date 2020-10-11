package com.schoolofnet.helpdesk.services;

import java.util.List;

import com.schoolofnet.helpdesk.models.Ticket;
import com.schoolofnet.helpdesk.models.User;

public class TicketServiceImpl implements TicketService {

	@Override
	public List<Ticket> findAll() {
		return null;
	}

	@Override
	public User create(Ticket ticket) {
		return null;
	}

	@Override
	public boolean delete(Long id) {
		return false;
	}

	@Override
	public boolean update(Long id, Ticket ticket) {
		return false;
	}

	@Override
	public User show(Long id) {
		return null;
	}

}
